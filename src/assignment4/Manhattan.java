package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manhattan {
	
	/*
	 * For 2 points (x1,y1) and (x2,y2) the manhattan distance is |x1-x2| + |y1-y2|.
	 * which is equal to |(x1+y1) - (x2+y2)| or |(x1-y1) - (x2-y2)|
	 * To get the maximum distance we need to maximize (x1+y1) maxSum and (x1-y1)maxDif and minimize (x2+y2)minSum and (x2-y2)minDif
	 * So we just need to record these 4 values
	 * For any two points if one point has maxSum and other has minSum they have maximum distance
	 * Similarly, if one point has maxDif and other has minDif they have maximum distance
	 * we consider the greater of absolute(maxSum-minSum) or absolute(maxDif - minDif)
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Math.abs(1-88));
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		//int[] left = new int[2];
		//int leftIdx = 0;
		//int[] rigth = new int[2];
		//int rightIdx = 0;
		//int maxDist = 0;
		List<String> result = new ArrayList<>();
		//List<int[]> maxSumList = new ArrayList<>();
		
		int maxSum = 0;
		int minSum = 0;
		int maxDif = 0;
		int minDif = 0;
		
		int maxSumPt = 0;
		int minSumPt = 0;
		int maxDifPt = 0;
		int minDifPt = 0;
		
		
		for (int i = 1; i <= n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
//			int[] maxSum = new int[2];
//			maxSum[0] = x+y;
//			maxSum[1] = x-y;
			if(i == 1) {
				
//				leftIdx = rightIdx = i;
//				maxDist = 0;
//				maxSumList.add( maxSum );
				
				maxSum = minSum = x+y;
				maxDif = minDif = x-y;
				maxSumPt = minSumPt = maxDifPt = minDifPt = 1;
			}
			else {
				
				if( x+y > maxSum ) {
					maxSum = x+y;
					maxSumPt = i;
				}
				if( x+y < minSum) {
					minSum = x+y;
					minSumPt = i;
				}
				if( x-y > maxDif ) {
					maxDif = x-y;
					maxDifPt = i;
				}
				if( x-y < minDif) {
					minDif = x-y;
					minDifPt = i;
				}
//					for (int j = 0; j < maxSumList.size(); j++) {
//						int tempMaxDist = Math.max(Math.abs(maxSum[0] - maxSumList.get(j)[0]), Math.abs(maxSum[1] - maxSumList.get(j)[1]));
//						if( tempMaxDist > maxDist) {
//							maxDist = tempMaxDist;
//							leftIdx = j+1;
//							rightIdx = i;
//						}
//					}
//					maxSumList.add( maxSum );
				//Test Left
//				int leftMax = Math.abs( x - left[0] ) +  Math.abs( y - left[1]);
//				int rightMax = Math.abs( x - rigth[0] ) +  Math.abs( y - rigth[1]);
//				if ( leftMax >= rightMax && leftMax > maxDist ) {
//					maxDist = leftMax;
//					rigth[0] = x;
//					rigth[1] = y;
//					rightIdx = i;
//				}
				
				//Test Right
				
//				if ( rightMax >= leftMax && rightMax > maxDist ) {
//					maxDist = rightMax;
//					left[0] = x;
//					left[1] = y;
//					leftIdx = i;
//				}
				
				
//				if( x - left[0] < y - left[1]) {
//					left[0] = x;
//					left[1] = y;
//					leftIdx = i;
//				}
//				if ( x - rigth[0] > y - rigth[1] ) {
//					rigth[0] = x;
//					rigth[1] = y;
//					rightIdx = i;
//				}
			}
			if( Math.abs(maxSum - minSum) > Math.abs(maxDif - minDif)) {
				result.add( maxSumPt + " " +minSumPt );
			}
			else {
				result.add( maxDifPt + " " +minDifPt );
			}
			
		}
		in.close();
		for (String string : result) {
			System.out.println( string );
		}
	}

}
