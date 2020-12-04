package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		
		int startPt = 0;
		int startPtIdx = 0;
		int endPt = 0;
		int endPtIdx = 0;
		List<String> result = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			int x = in.nextInt();
			if (i == 1) {
				startPt = endPt = x;
				startPtIdx = endPtIdx = i;
				result.add( startPtIdx + " " + endPtIdx );
			} else {
				if ( x < startPt ) {
					startPt = x;
					startPtIdx = i;
				}
				if( x > endPt ) {
					endPt = x;
					endPtIdx = i;
				}
				result.add( startPtIdx + " " + endPtIdx );
			}
		}
		in.close();
		
		for (String string : result) {
			System.out.println(string);
		}

	}

}
