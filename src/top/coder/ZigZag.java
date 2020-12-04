package top.coder;

import java.util.Scanner;

public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int[] seq = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };//new int[n];
//		for (int i = 0; i < seq.length; i++) {
//			seq[i] = in.nextInt();
//		}
//		in.close();
		System.out.println(longestZigZag(seq));
	}
	
	public static int longestZigZag( int[] sequence ) {
		Node[] table = new Node[ sequence.length + 1 ];
		boolean isNextPos;
		for (int i = 1; i < table.length; i++) {
			table[i] = new Node();
			for (int j = 1; j < i; j++) {
				if( sequence[i-1] != sequence[j-1] ) {
					if( table[j].next.equals("+") ) {
						if( sequence[j-1] - sequence[i-1] < 0 && table[i].value < table[j].value + 1) {
							table[i].value = table[j].value + 1;
							table[i].next = "-";
						}
					}
					else if( table[j].next.equals("-") ) {
						if( sequence[j-1] - sequence[i-1] > 0 && table[i].value < table[j].value + 1) {
							table[i].value = table[j].value + 1;
							table[i].next = "+";
						}
					}
					else {
						if(  table[i].value < table[j].value + 1) {
							table[i].value = table[j].value + 1;
							if( sequence[j-1] - sequence[i-1] > 0){
								table[i].next = "+";
							}
							else {
								table[i].next = "-";
							}
							
						}
					}
				}
			}
		}
	
		return table[sequence.length].value;
	}
	

}

class Node
{
	int value;
	String next;
	
	public Node() {
		value = 1;
		next = "0";
	}
}
