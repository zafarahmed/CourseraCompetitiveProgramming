package practice;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lis = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3};
		System.out.println(compute(lis));

	}
	public static int compute(int[] a) {
		
		int[] T = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			T[i] = 1;
			for (int j = 0; j < i; j++) {
				if(a[j] < a[i] && T[i] < T[j] + 1) {
					T[i] = T[j] + 1;
				}
			}
		}
		Arrays.sort(T);
		
		return T[T.length-1];
		
	}

}
