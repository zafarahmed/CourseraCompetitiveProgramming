package assignment5;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int i = in.nextInt();
		int j = in.nextInt();
		String u = in.next();
		String w = in.next();
		int I = in.nextInt();
		int D = in.nextInt();
		int S = in.nextInt();
		in.close();
		int[][] table = new int[i+1][j+1];
		for (int k = 0; k <= i; k++) {
			table[k][0] = k*I;
		}
		for (int l = 0; l <= j; l++) {
			table[0][l] = l*D;
		}
		table[0][0] = 0;
		for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				
					int diff = u.charAt(k-1) == w.charAt(l - 1) ? 0 : S;
					table[k][l] = Math.min(Math.min(table[k][l-1] + I, table[k-1][l] + D),table[k-1][l-1] + diff);
				
			}
		}
		System.out.println(table[i][j]);
		
		for (int k = 0; k <= i; k++) {
			for (int l = 0; l <= j; l++) {
				
				System.out.print(table[k][l] + " ");
			}
			System.out.println();
		}

	}
	
	public static int minValue( int a, int b, int c )
	{
		if (a<=c && a<=b) {
			return a;
		}
		else if (b<=c && b<=a) {
			return b;
		}
		return c;
	}

}
