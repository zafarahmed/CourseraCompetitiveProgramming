package code.vita;

import java.util.Scanner;

public class Happy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		int k  = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int start = a[i] - k;
			int end = a[i] + k;
			
			for (int j = 0; j < a.length; j++) {
				if( i != j && ( start <= a[j] && a[j] <= end )) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
	

}
