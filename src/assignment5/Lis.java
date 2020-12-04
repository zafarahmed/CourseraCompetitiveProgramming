package assignment5;

import java.util.Scanner;

public class Lis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		int a[] = new int[n];
		int[] table = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			table[i] = -1;
		}
		in.close();
		
		//int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			table[i] = 1;
			for (int j = 0; j < i; j++) {
				if(a[j] < a[i] && table[i] < table[j] + 1) {
					table[i] = table[j] + 1; 
				}
			}
		}
//		for (int i = 0; i < result.length; i++) {
//			result[i] = lis(a, table, i);
//		}
		int max = table[0];
		for (int i = 0; i < table.length; i++) {
			if( table[i] > max ) {
				max = table[i];
			}
		}
		System.out.println( max );
		
	}
	
	public static int lis( int[] a, int[] table, int i) {
		
		if( table[i] == -1 ) {
			table[i] = 1;
		}
		for (int j = 0; j < i; j++) {
			if(a[j] < a[i]) {
				table[i] = Math.max(table[i], lis(a, table, j) + 1);
			}
		}
		
		return table[i];
	}

}
