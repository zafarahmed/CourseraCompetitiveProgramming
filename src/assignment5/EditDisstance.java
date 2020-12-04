package assignment5;

import java.util.Scanner;

public class EditDisstance {
	
	public static int I;
	public static int D;
	public static int S;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int j = in.nextInt();
		int i = in.nextInt();
		String w = in.next();
		String u = in.next();
		 I = in.nextInt();
		 D = in.nextInt();
		 S = in.nextInt();
		in.close();
		int[][] table = new int[i+1][j+1];
		for (int k = 0; k <= i; k++) {
			for (int l = 0; l <= j; l++) {
				table[k][l] = -1;
			}
		}
		System.out.println(minED(table, i, j, u, w));
		
		for (int k = 0; k <= i; k++) {
			for (int l = 0; l <= j; l++) {
				
				System.out.print(table[k][l] + " ");
			}
			System.out.println();
		}
		

	}
	
	public static int minED( int[][] table, int i, int j, String u , String w) {
		if(table[i][j] == -1) {
			if( j == 0) {
				table[i][0] = i;
			}
			else if( i == 0) {
				table[0][j] = j;
			}
			else {
				int diff = u.charAt(i-1) == w.charAt(j-1) ? 0 : S;
				table[i][j] = minValue( minED(table, i-1, j, u, w) +D , minED(table, i, j-1, u, w)+I, minED(table, i-1, j-1, u, w) + diff);
			}
		}
		
		return table[i][j];
	}
	
	public static int minValue(int a, int b, int c) {
		if (a <= b && a <= c) {
			return a;
		} else if( b<=a && b<=c ) 
		{
			return b;
		}
		return c;
	}

}
