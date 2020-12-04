package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Evaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		String s = in.next();
		in.close();
		String[] plusLiterals = s.split("\\+");
		long result = 0;
		for( String pElem : plusLiterals )
		{
			String[] minusLiteral = pElem.split( "-" );
			long diff = Long.parseLong( minusLiteral[0].trim() );
			for (int j = 1; j< minusLiteral.length; j++) {
				diff = diff - Long.parseLong(minusLiteral[j].trim());
			}
			result += diff;
		}
		System.out.println( result );
	}

}
