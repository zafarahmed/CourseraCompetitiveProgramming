package assignment4;

import java.util.Scanner;

public class Maximalsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		int[] prefixSum = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			prefixSum[i+1] = prefixSum[i] + a[i];
		}
		
		int[] minPrefixSum = prefixSum;
		for (int i = 0; i < minPrefixSum.length; i++) {
			System.out.print(minPrefixSum[i] + " ");
		}
		System.out.println();
		for (int i = 0; i <  n; i++) {
			minPrefixSum[i+1] = Math.min(minPrefixSum[i+1], minPrefixSum[i]);
		}
		
		int[] suffixSum = new int[n+1];
		
		for (int i = n-1; i >=0 ; i--) {
			suffixSum[i] = suffixSum[i+1] + a[i];
		}
		
		int[] minSuffixSum = suffixSum;
		
		for (int i = 0; i < minSuffixSum.length; i++) {
			System.out.print(minSuffixSum[i] + " ");
		}
		System.out.println();
		for (int i = n-1; i >= 0; i--) {
			minSuffixSum[i] = Math.min(minSuffixSum[i+1], minSuffixSum[i]);
		}
		
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		for (int i = 0; i < n; i++) {
//			int tempSum = sum;
//			if (i == 0) {
//				tempSum = tempSum - minSuffixSum[i+1];
//			} 
//			else if( i == n-1) {
//				tempSum = tempSum - minPrefixSum[i-1];
//			}
//			else {
//				tempSum = tempSum - (minPrefixSum[i-1]) - (minSuffixSum[i+1]);
//			}
			//System.out.print(tempSum +" ");
			//System.out.print(Math.max(sum, tempSum) +" ");
			System.out.print(sum - minPrefixSum[i] - minSuffixSum[i+1] +" " );
		}
		System.out.println();
		for (int i = 0; i < minPrefixSum.length; i++) {
			System.out.print(minPrefixSum[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < minSuffixSum.length; i++) {
			System.out.print(minSuffixSum[i] + " ");
		}
	}

}
