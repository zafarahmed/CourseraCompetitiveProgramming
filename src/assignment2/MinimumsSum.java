package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumsSum {
	private static int[] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		int n = in.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		List<Integer> minList = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
			//	System.out.println( i + " " + j );
				minList.add( getMin(i, j) );
			}
		}
		
		long result = 0;
		for (int i = 0; i < minList.size(); i++) {
			result += minList.get(i);
		}
		System.out.println( result );
	}
	
	private static int getMin( int l, int r )
	{
		int min = a[l-1];
		for (int i = l; i < r; i++) {
			if ( a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}
	
	

}
