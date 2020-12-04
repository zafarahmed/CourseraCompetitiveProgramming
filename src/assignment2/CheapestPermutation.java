package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class CheapestPermutation {
	
	
	private static int minCost = Integer.MAX_VALUE;
	private static int[] result;
	private static int[][] A;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		
		int n = in.nextInt();
		result = new int[n];
		A = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = in.nextInt();
				
			}
			
		}
		in.close();
		int a[] = new int[n];
		for (int i = 1; i <= n; i++) {
			a[i-1] = i;
		}
		//calcCheapestPerm(n, 1,new int[n] );
		heapPermutation(a, a.length, n) ;
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	private static boolean containsDuplicates( int[] elemArr )
	{
		Set<Integer> s = new HashSet<>( );
		for( int i=0; i < elemArr.length; i++ )
		{
			s.add( elemArr[i] );
		}
		return s.size() == elemArr.length;
	}
	
	private static void calcCheapestPerm( int n, int depth, int[] x)
	{
		if( depth <= n )
		{
			for (int i = 1; i <= n; i++) {
				x[depth-1] =i;
				calcCheapestPerm(n, depth+1, x);
			}
		}
		else 
		{
			if( containsDuplicates( x ) )
			{
				int sum = 0;
				for (int i = 0; i < x.length-1; i++) {
					sum += A[x[i] - 1][x[i+1]-1];
				}
				if( sum < minCost)
				{
					minCost = sum;
					for (int i = 0; i < x.length; i++) {
						result[i] = x[i];
					}
				}
			}
			
		}
	}
	
    private static void heapPermutation(int a[], int size, int n) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
        if (size == 1) 
        {
//        	for (int i = 0; i < a.length; i++) {
//				System.out.print(a[i] + " ");
//			}
//        	System.out.println();
        	int sum = 0;
			for (int i = 0; i < a.length-1; i++) {
				sum += A[a[i] - 1][a[i+1]-1];
			}
			if( sum < minCost)
			{
				minCost = sum;
				for (int i = 0; i < a.length; i++) {
					result[i] = a[i];
				}
			}
        } 
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
  
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last 
            // element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 
	


}
