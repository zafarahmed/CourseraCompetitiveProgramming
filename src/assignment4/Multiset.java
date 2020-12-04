package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * So, we are checking for the repetitions of a number X in a range [minInterval maxInterval]
 * for each interval we mark the start in an array as start[interval[0]]+= 1 and end as end[interval[0]]+= 1
 * now we have all the repetitions on start and end interval, how find repetitions in between them ?
 * a number Y is in range if end[Y-1] does not exist i.e never an interval has ended on Y-1
 * repetitions of Y depends on repetitions of Result[Y-1] - end [Y-1] + start[Y]
 * */

public class Multiset {
	
	public static void main( String[] args) {
		Scanner in =  new Scanner( System.in );
		int n = in.nextInt();
		int min = 0;
		int max = 0;
		List<int[]> intervals = new ArrayList<>();
		//Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		//Date startDate = new Date();
		//Calendar startDate = Calendar.getInstance();
		
		for (int i = 1; i <= n; i++) {
			int[] interval = new int[2];
			interval[0] = in.nextInt();
			interval[1] = in.nextInt();
			intervals.add(interval);
//			int start = in.nextInt();
//			int end = in.nextInt();
			
			if( i == 1) {
				min = interval[0];
				max = interval[1];
			}
			else {
				min = interval[0] < min ? interval[0] : min;
				max = interval[1] > max ? interval[1] : max;
			}
			
//			for (int j = start; j <= end; j++) {
//				if ( countMap.get(j) == null) {
//					countMap.put(j, 1);
//				} else {
//					countMap.put(j, countMap.get(j)+1);
//				}
//			}
			
		}
		in.close();
		int[] start = new int[max + 1];
		int[] end = new int[max +1 ];
		for (int i = 0; i < intervals.size(); i++) {
			start[intervals.get(i)[0]] += 1;
			end[intervals.get(i)[1]] += 1;
		}
		int result[] = new int[max+1];
		for (int i = min; i <= max; i++) {
			result[i] = result[i-1] - end[i-1] + start[i];
		}
		for (int i = 0; i < result.length; i++) {
			if( result[i] > 0) {
				System.out.println( i +  " " + result[i] );
			}
		}
//		for ( int i = min; i<=max; i++) {
//			if ( countMap.get(i) != null && countMap.get(i) > 0 ) {
//				System.out.println(i + "  " + countMap.get(i));
//			}
//			
//		}
//		Calendar endDate = Calendar.getInstance();
//		System.out.println( ( endDate.getTimeInMillis() - startDate.getTimeInMillis() ) / 1000.0 );
		
	}

}
