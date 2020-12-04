package assignment6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = in.nextInt();
		}
		in.close();
		
		int table[][] = new int[n+1][n+1];
		for (int i = 0; i < table.length; i++) {
		for (int j = 0; j < table.length; j++) {
			table[i][j] = -1;
		}
		}
		System.out.println(solve(table, x, y, n, n));
		
//		for (int i = 0; i < table.length; i++) {
//			for (int j = 0; j < table.length; j++) {
//				System.out.print(table[i][j] +" ");
//			}
//			System.out.println();
//		}
		List<Integer> xList = new ArrayList<>();
		List<Integer> yList = new ArrayList<>();
		backtrack(table, x, y, n, n, xList, yList);
		
		for (int i = xList.size()-1; i >= 0; i--) {
			System.out.print( xList.get(i) + " ") ;
			
			
		}
		System.out.println();
		for (int i = yList.size()-1; i >= 0; i--) {
			System.out.print( yList.get(i) + " ") ;
			
			
		}
		
		
	}
	
	public static int solve( int[][] table, int[] x, int[] y, int i, int j) {
		if ( table[i][j] == -1) {
			
		
		if( i == 0 || j == 0) {
			return 0;
		}
		else {
			if(x[i-1] == y[j-1]) {
				table[i][j] = 1 + solve(table, x, y, i-1, j-1);
			}
			else {
				table[i][j] = Math.max(solve(table, x, y, i, j-1), solve(table, x, y, i-1, j));
			}
		}
		
		 return table[i][j];
	}
		else {
			return table[i][j];
		}
		
	}
	
	public static void backtrack( int[][] table, int[] x, int[] y,int i, int j, List xList, List yList ) {
		if( i == 0 || j == 0) {
			return;
		}
		else if( x[i-1] == y[j-1] ) {
			xList.add(i-1);
			yList.add(j-1);
			backtrack(table, x, y, i-1, j-1, xList, yList);
		}
		else {
			if( table[i][j-1] > table[i-1][j] ) {
				backtrack(table, x, y, i, j-1, xList, yList);
			}
			else {
				backtrack(table, x, y, i-1, j, xList, yList);
			}
		}
		
	}

}
