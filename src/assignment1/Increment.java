package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Increment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		String x = in.next().trim();
		in.close();
		int digits = x.length();
		x = x.replaceAll("9", "");
		if( x.isEmpty() )
		{
			digits ++;
		}
		
		System.out.println(digits);

	}

}
