package assignment5;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int s = in.nextInt();
		int l = in.nextInt();
		in.close();
//		long start =  (long)Math.pow(10, l-1);
//		long end = (long)Math.pow(10, l) - 1;
//		int count = 0;
//		
//		for (long i = start; i <= end; i++) {
//			long temp = i;
//			int tempSum = 0;
//			
//			while( temp > 0) {
//				tempSum += temp % 10;
//				temp = temp/10;
//			}
//			if( tempSum == s) {
//				count++;
//				i += 9;
//			}
//			
//			
//			
//		}
//		
//		System.out.println(count);
		if( s == 0 && l == 1) {
			System.out.println(1);
			
		}
		else {
		long[][] table = new long[s+1][l+1];
		for (int i = 0; i <= s; i++) {
			for (int j = 0; j <= l; j++) {
				table[i][j] = -1;
			}
		}
		System.out.println( sumOfDigits(s, l,l, table));
		
	}
	}
	
	public static long sumOfDigits ( int sum, int l, int n, long table[][] )
	{
		if( table[sum][l] != -1 ) {
			return table[sum][l];
		}
		if( l == 0) {
			return sum == 0 ? 1 : 0;
		}
		long ans  = 0;
		for (int i = l==n?1:0; i <= 9; i++) {
			if( sum - i >= 0 ) {
				ans +=  sumOfDigits(sum - i, l -1,  n, table);
			}
		}
		return table[sum][l] = ans;
	}
	
	public static int forFirst ( int sum, int l, long[][] table )
	{
//		if( l == 0) {
//			return sum == 0 ? 1 : 0;
//		}
//		if( sum == 0) {
//			return 1;
//		}
//		if( table[sum][l] != -1 ) {
//			return table[sum][l];
//		}
		int ans = 0;
		for (int i = 1; i <= 9; i++) {
			if( sum - i >= 0 ) {
				ans += sumOfDigits(sum - i, l -1,l, table);
			}
		}
		return ans;
	}

}
