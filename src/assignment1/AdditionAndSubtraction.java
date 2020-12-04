package assignment1;

import java.io.PrintWriter;
import java.util.Scanner;

public class AdditionAndSubtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		PrintWriter out = new PrintWriter(System.out);
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		in.close();
		int diff = x - y;
		int pos = -1;
		int rem1 = -1 , rem2 = -1;
		if( diff != 0 )
		{
			rem1 = z % diff;
			rem2 = (z -x) % diff;
		}
		if( diff < 0 )
		{
			rem1 = rem1 - diff;
			rem2 = rem2 - diff;
		}
		if( z == 0 )
		{
			pos = 0;
		}
		else if( z == x ) 
		{
			pos = 1;
		}
		else if( rem1 == 0 || rem2 == 0 )
		{
			int i = 2;
			int multiplier = 1;
			int num = -1;
			while( num != z)
			{
				if ( i % 2 == 0 ) {
					num = multiplier * diff;
					multiplier++;
				}
				else {
					num = num + x;
				}
				i++;
			}
			pos = i-1; 
		}
		out.println(pos);
		out.close();
		

	}

}

/*
 * 
2 1 3 -->  3
2 0 3 --> -1
2 5 2 -->  1
2 1 0 -->  0
0 0 0 -->  0
0 0 1 --> -1
0 1 0 -->  0
0 1 1 --> -1
1 0 0 -->  0
1 0 1 -->  1
1 1 0 -->  0
1 1 1 -->  1
 * 
 * */
