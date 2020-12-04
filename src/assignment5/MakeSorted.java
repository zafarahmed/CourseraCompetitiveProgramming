package assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MakeSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		List<Integer> aList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			aList.add(in.nextInt());
		}
		in.close();
		int max = Collections.max(aList);
		int dp[][] = new int[n+1][max+1];
		for (int i = 0; i < n; i++) {
			int minVal = dp[i][0];
			for (int j = 0; j <= max; j++) {
				minVal = Math.min(minVal, dp[i][j]);
				dp[i+1][j] = minVal + Math.abs( aList.get(i) - j);
			}
		}
		
		int[] result = dp[n];
		int resVal = result[0];
		for (int i = 1; i < result.length; i++) {
			if( result[i] < resVal ) {
				resVal = result[i];
			}
		}
		
		System.out.println(resVal);
		
		for (int k = 0; k <= n; k++) {
			for (int l = 0; l <= max; l++) {
				
				System.out.print(dp[k][l] + " ");
			}
			System.out.println();
		}
	}

}
