package assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequentSymbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		String s = in.next();
		String[] sTokens = s.split("");
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
		String[] result = new String[n];
		
		Map<String, int[]> countMap = new HashMap<String, int[]>();
		for ( String str : sTokens ) {
			if( countMap.get(str) == null ) {
				int[] count = new int[ sTokens.length ];
				if( sTokens[0] == str ) {
					count[0] = 1;
				}
				for (int i = 1; i < sTokens.length; i++) {
					if( sTokens[i].equalsIgnoreCase( str )  ) {
						count[i] = count[ i - 1] + 1;
					}
					else {
						count[i] = count[ i - 1];
					}
				}
				countMap.put(str, count);
				
			}
		}
		for (int i = 0; i < n; i++) {
			int l = lArr[i] - 1;
			int r = rArr[i] - 1;
			result[i] = getMaxOccur(countMap, l, r, sTokens[l]);
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
//		for (String s1 : countMap.keySet()) {
//			System.out.print(s1 +" : ");
//			for (int i1 : countMap.get(s1)) {
//				System.out.print(i1 + " ");
//			}
//			System.out.println();
//		}

	}
	
	public static String getMaxOccur( Map<String, int[]> countMap, int l, int r, String first) {
		
		int max = 0;
		String result = first;
		for (String key : countMap.keySet()) {
			int[] count = countMap.get(key);
			int value = 0;
			if( l == 0) {
				 value = count[r];
			}
			else {
				 value = count[r] - count[l-1];
			}
			if( value > max) {
				max = value;
				result = key;
			}
			
		}
		
		
		return result;
	}

}
