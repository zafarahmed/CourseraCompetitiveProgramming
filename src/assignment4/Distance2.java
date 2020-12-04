package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Distance2 implements Comparable<Distance2> {
	
	Integer start;
	Integer end;
	Integer distance;
	
	public Distance2( Integer start, Integer end, Integer distance) {
		if (distance < 0) {
			distance = distance * -1;
		}
		this.distance = distance;
		this.end = end;
		this.start = start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =  new Scanner( System.in );
		int n = in.nextInt();
		List<Integer> queue = new ArrayList<>();
		List<Distance2> disList = new ArrayList<>();
		List<Distance2> result = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			int x = in.nextInt();
			queue.add(x);
			for (int j = 0; j < queue.size(); j++) {
				Distance2 temp = new Distance2( j+1, i, x-queue.get(j));
				disList.add(temp);
			}
			Collections.sort(disList);
			result.add(disList.get(disList.size() - 1));
			
		}
		in.close();
		
		for (Distance2 dist: result) {
			System.out.println(dist.start + " " + dist.end);
			
		}
	}

	@Override
	public int compareTo(Distance2 o) {
		// TODO Auto-generated method stub
		
		return this.distance.compareTo(o.distance);
	}

}
