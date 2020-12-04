package assignment6;

import java.util.Scanner;

public class ChainMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] m = new int[n+1];
		for (int i = 0; i < m.length; i++) {
			m[i] = in.nextInt();
		}
		in.close();
		long[][] table = new long[n+1][n+1];
		
		for (int i = 0; i <=n; i++) {
			for (int j = 0; j <= n; j++) {
				table[i][j] = -1;
			}
		}
		System.out.println(solve(m, 0, n, table));
		
	}
	
	public static long solve( int[] m, int i, int j, long[][] table ) {
		
		if( table[i][j] == -1) {
			
			if( j == i+1 ) {
				table[i][j] = 0;
			}
			else {
				table[i][j] = Integer.MAX_VALUE;
				for (int k = i+1; k < j; k++) {
					table[i][j] = Math.min(table[i][j],solve(m, i, k, table) + solve(m, k, j, table) + (m[i]*m[j]*m[k]) );
				}
			}
			
		}
		return table[i][j];
	}

}
