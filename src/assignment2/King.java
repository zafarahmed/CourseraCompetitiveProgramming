package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class King {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		int r = in.nextInt();
		int c = in.nextInt();
		in.close();
		int fullC = 2 * ( c / 3 ) + ( c % 3 ) / 2;
		int fullR = 2 * ( r / 3 ) + ( r % 3 ) / 2;
		int result = fullC * r + fullR * ( c - fullC );
		System.out.println( result );
	}

}
