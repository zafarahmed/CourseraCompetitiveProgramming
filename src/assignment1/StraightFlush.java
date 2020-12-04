package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class StraightFlush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String theOrder = "AKQJT98765432A";
		
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		String input = in.nextLine().trim();
		in.close();
		//System.out.println(input);
		String[] inputArr = input.split(" ");
		//System.out.println(inputArr.length);
		for (int i = 1; i < inputArr.length; i++) {
			if(inputArr[i-1].charAt(1) != inputArr[i].charAt(1)) {
				System.out.println("NO");
				return;
			}
		}
		if( input.contains("K") || input.contains("Q") || input.contains("J") )
		{
			theOrder = theOrder.substring(0, theOrder.length()-1);
		}
		else {
			theOrder = theOrder.substring(1);
		}
		//System.out.println(theOrder);
		char maxElem = inputArr[0].charAt(0);
		for (int i = 1; i < inputArr.length; i++) {
			//System.out.println(theOrder.indexOf(inputArr[i].charAt(0))+ " "+theOrder.indexOf(maxElem));
			if(theOrder.indexOf(inputArr[i].charAt(0)) < theOrder.indexOf(maxElem))
			{
				maxElem = inputArr[i].charAt(0);
			}
		}
		//System.out.println(maxElem);
		int beginIdx = theOrder.indexOf(maxElem);
		int endIdx = beginIdx + 4;
		String resullt = "YES";
		//System.out.println(beginIdx + " " + endIdx);
		if (endIdx >= theOrder.length()) {
			System.out.println("NO");
			return;
		}
		else
		{
			for (int i = beginIdx; i <= endIdx; i++) {
				if (!input.contains(theOrder.charAt(i)+"")) {
					resullt = "NO";
					break;
				}
			}
		}
		System.out.println(resullt);
		
	}

}
