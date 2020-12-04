
package assignment3;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RoundUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		long x = in.nextLong();
		long y = in.nextLong();
		in.close();
		double eval = (double)x/y;
		DecimalFormat df = new DecimalFormat("#.#######");
		eval = Double.parseDouble(df.format(eval));
		long z = (long)eval;
//		if( y < 0 ) 
//		{
//			x = x * -1;
//			y = y * -1;
//		}
//		long z = 0;
		while( !(z>=eval))
		{
			z++;
		}
		System.out.println(z);
	//System.out.println(x + " " + y + " " + eval);

	}

}

/*
 * 
1 2
1 -2
10 10
6 -5
-1 -100000
-1 100000
6 5
999999 1000000
 * */
