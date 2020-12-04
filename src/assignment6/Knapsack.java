package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		int W = in.nextInt();
		int[] w = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
			v[i] = in.nextInt();
		}
//		for (int i = 0; i < n; i++) {
//			v[i] = in.nextInt();
//		}
		in.close();
		int[][] table = new int[W+1][n+1];
		for (int i = 0; i < W+1; i++) {
			for (int j = 0; j < n+1; j++) {
				table[i][j] = -1;
			}
		}
		Map<Integer, Integer[]> trace = new HashMap<>();
		for (int i = 0; i < W+1; i++) {
			trace.put(i, new Integer[n+1]);
		}
		//System.out.println(
				solve(W, w, v, n, table, trace)
		//		)
		;
		
//		for (int i = 0; i < W+1; i++) {
//			for (int j = 0; j < n+1; j++) {
//				System.out.print( table[i][j] + "  " );
//			}
//			System.out.println();
//		}
		
				
				//BackTracking
		int wt = W;
		int res = table[W][n];
		List<Integer> result = new ArrayList<>();
		
		for (int i = n; i > 0; i--) {
			
			if ( res == table[wt][i-1]) {
				continue;
			}
			else {
				//System.out.println(w[i-1]);
				result.add(i);
				res =  res - v[i-1];
				wt = wt - w[i-1];
			}
		}
		System.out.println(result.size());
		for (int i = result.size() - 1; i >=0 ; i--) {
			System.out.print(result.get(i)+" ");
		}
//		for (Integer key : trace.keySet()) {
//			Integer[] val = trace.get(key);
//			System.out.print( key + ": ");
//			for (int i = 0; i < val.length; i++) {
//				System.out.print(val[i] +"  ");
//			}
//			
//			System.out.println();
//		}
		
	}
	
	public static int solve( int W, int[] w, int[] v, int i, int[][] table, Map<Integer, Integer[]> trace ) 
	{
		if( table[W][i] == -1 ) {
			
			if( i == 0) {
				table[W][i] = 0;
			}
			else {
				table[W][i] = solve(W, w, v, i-1, table,trace);
				//trace.get(W)[i] = 1;
				if( W >= w[i-1]) {
					table[W][i] = Math.max(table[W][i], solve(W - w[i-1], w, v, i-1, table, trace) + v[i-1]);
					if (table[W][i] > solve(W - w[i-1], w, v, i-1, table, trace) + v[i-1] ) {
						trace.get(W)[i-1] = 1;
						trace.get(W)[i] = 0;
					} else {
						trace.get(W)[i] = 1;
						trace.get(W)[i-1] = 0;
						//trace.get(W)[i] = 0;
					}
				}
				
			}
			
		}
		return table[W][i];
	}

}
