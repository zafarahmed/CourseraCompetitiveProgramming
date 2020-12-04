package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ErasingMaximim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		int n = in.nextInt();
		int[] a = new int[n];
		for( int i = 0; i < n; i++ )
		{
			a[i] = in.nextInt();
		}
		in.close();
		int pos = 0;
		int occurance = 1; 
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if( a[i] > max)
			{
				max = a[i];
				pos = i;
				occurance = 1;
			}
			else if( a[i] == max )
			{
				occurance++;
				if(occurance == 3)
				{
					pos = i;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if( i != pos )
			{
				System.out.print(a[i] +" ");
			}
		}

	}
/*
 * 
 *

3
1 3 2

------>  1 2

7
4 1 4 2 4 3 4


--------> 4 1 4 2 3 4

2
4 1

---------> 1

2
1 4

----------> 1

3
5 4 2

-----------> 4 2 

3
4 5 2

------------> 4 2 


3
2 4 5

-------------> 2 4


3
4 4 4

--------------> 4 4

4
3 4 4 4

--------------> 3 4 4 

4
4 4 4 3

-------------> 4 4 3 


4
4 3 4 4

--------------> 4 3 4 

 * 
 * */
}
