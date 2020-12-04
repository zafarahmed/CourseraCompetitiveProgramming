package assignment4;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequentSymbol2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String[] S = in.next().split("");
//		Node[] tree = new Node[2*S.length];
//		buildMFSegmentTree(S, tree, 0, S.length-1, 1);
		
		
//		for (int i = 1; i < tree.length; i++) {
//			System.out.println("{ start: "+tree[i].start + ", end: "+tree[i].end+", value: "+tree[i].value +", Occurance: " + tree[i].occurance + " } ");
//		}
		int n = in.nextInt();
		int[] lArr = new int[n];
		int[] rArr = new int[n];
		for (int i = 0; i < n; i++) {
			int l = in.nextInt();
			lArr[i] = l;
			int r = in.nextInt();
			rArr[i] = r;
			
		}
		in.close();
		for (int i = 0; i < n; i++) {
//			List<Map> result = new ArrayList<>();
//			getMFLiteral(tree, lArr[i], rArr[i], 1, result);
//			printRessult(result);
			
			bruteForce(S, lArr[i], rArr[i]);
		}
		
	}
	
	static void bruteForce(String[] S, int l, int r) {
		Map<String, Integer> freqMap = new HashMap<String, Integer>();
		for (int i = l-1; i < r; i++) {
			if( freqMap.get(S[i]) == null) {
				freqMap.put(S[i], 1);
			}
			else {
				freqMap.put(S[i], freqMap.get(S[i])+1);
			}
		}
		int maxOccr = 0;
		String maxKey = "";
		
		for (String key : freqMap.keySet()) {
		if(freqMap.get(key) > maxOccr) {
			maxOccr = freqMap.get(key);
			maxKey = key;
					
		}
		}
		System.out.println(maxKey);
	}
	static void printRessult( List<Map> result ) {
		Map<String, Integer> resMap = result.size()>0 ?result.get(0) : new HashMap<>();
		for (int i = 1; i < result.size(); i++) {
			result.get(i).forEach(
								( key, value) ->resMap.merge(key.toString(), (Integer)value, (v1,v2) -> v1+v2)
					);
		}
		int maxOccr = 0;
		String maxKey = "";
		
		for (String key : resMap.keySet()) {
		if(resMap.get(key) > maxOccr) {
			maxOccr = resMap.get(key);
			maxKey = key;
					
		}
	}
		System.out.println(maxKey);
	}
	
	static void buildMFSegmentTree(String[] S, Node[] tree, int start, int end, int v) {
		if( start == end ) {
			Map<String, Integer> freqMap = new HashMap<String, Integer>();
			freqMap.put(S[start], 1);
			tree[v] = new Node(start, end, freqMap);
		}
		else {
			Map<String, Integer> freqMap = new HashMap<String, Integer>();

			for (int i = start; i <= end; i++) {
				if( freqMap.get(S[i]) == null ) {
					freqMap.put(S[i], 1);
				}
				else {
					freqMap.put(S[i], freqMap.get(S[i])+1);
				}
			}

			tree[v] = new Node(start, end, freqMap);
			int mid = (start+end)/2;
			buildMFSegmentTree(S, tree, start, mid, 2*v);
			buildMFSegmentTree(S, tree, mid+1, end, 2*v + 1);
		}
	}
	
	static void getMFLiteral( Node[] tree, int l, int r, int v, List<Map> result) {
		
		Node vNode = tree[v];
		int start = vNode.start;
		int end = vNode.end;
		if( l > end || r < start) {
			return;
		}
		if( l <= start && r >=end ) {
			result.add(tree[v].value);
			return;
		}
		//int mid = (start+end)/2;
		 getMFLiteral(tree, l, r, 2*v, result);
		 getMFLiteral(tree, l, r, 2*v +1, result);
		
		
		
	}
//	static Node getMostOccured( Node n1, Node n2 ) {
//		
//		if(n1.occurance> n2.occurance) {
//			return n1;
//		}
//		return n2;
//	}
}
class Node
{
	int start;
	int end;
	Map value;
//	String value;
//	int occurance;
	
	public Node(int start, int end, Map val) {
		this.start = start+1;
		this.end = end+1;
		this.value = val;
		//this.occurance = occurance;
	}
}