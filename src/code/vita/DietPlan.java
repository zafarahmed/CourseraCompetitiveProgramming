package code.vita;

import java.util.Scanner;

public class DietPlan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		String s1[] = in.nextLine().split(" ");
		String s21 = in.nextLine();
		s21 = s21.replace("|", ",");
		String s2[] = s21.split(",");
		in.close();
		
		int[] plan = getCalValues(s1);
		int[][] items = new int[s2.length][3];
		
		for (int i = 0; i < s2.length; i++) {
			items[i] = getCalValues(s2[i].split(" "));
			
		}
		
		int[] itemSum = new int[3];
		for (int i = 0; i < items.length; i++) {
			itemSum[0] += items[i][0];
			itemSum[1] += items[i][1];
			itemSum[2] += items[i][2];
		}
		
		int[] deficit =new int[3];
		deficit[0] = plan[0];
		deficit[1] = plan[1];
		deficit[2] = plan[2];
		while( deficit[0] - itemSum[0] >= 0 && deficit[1] - itemSum[1] >= 0 && deficit[2] - itemSum[2] >= 0 ) {
			deficit[0] = deficit[0] - itemSum[0];
			deficit[1] = deficit[1] - itemSum[1];
			deficit[2] =  deficit[2] - itemSum[2];
			
		}
		
		
		for (int i = 0; i < plan.length; i++) {
			System.out.print(plan[i] + " ");
		}
		System.out.println();
		
		
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(items[i][j] + " ");
				
			}
			System.out.println();
			
			
		}
		System.out.println();
		for (int i = 0; i < itemSum.length; i++) {
			System.out.print(itemSum[i] + " ");
		}
		
		System.out.println();
		for (int i = 0; i < deficit.length; i++) {
			System.out.print(deficit[i] + " ");
		}
		
		int[] min = new int[3];
		min[0] = deficit[0];
		min[1] = deficit[1];
		min[2] = deficit[2];
		for (int i = 0; i < items.length; i++) {
			int[] temp = new int[3];
			temp[0] = deficit[0];
			temp[1] = deficit[1];
			temp[2] = deficit[2];
			while( temp[0] - items[i][0] >= 0 && temp[1] - items[i][1] >= 0 && temp[2] - items[i][2] >= 0 ) {
				temp[0] = temp[0] - items[i][0];
				temp[1] = temp[1] - items[i][1];
				temp[2] =  temp[2] - items[i][2];
				if(min[0]+min[1]+min[2] > temp[0]+temp[1]+temp[2]) {
					min[0] = temp[0];
					min[1] = temp[1];
					min[2] = temp[2];
				}
			}
		}
		
		System.out.println();
		for (int i = 0; i < min.length; i++) {
			System.out.print(min[i]+" ");
		}
		
		
	}
	
	public static int[] getCalValues( String[] s1) {
		int[] calories = new int[3];
		for (int i = 0; i < s1.length; i++) {
			if( s1[i].contains("P") || s1[i].contains("p")) {
				calories[0] = Integer.parseInt(s1[i].substring(0, s1[i].length()-1));
			}
			else if( s1[i].contains("C") || s1[i].contains("c") ) {
				calories[1] = Integer.parseInt(s1[i].substring(0, s1[i].length()-1));
			}
			else {
				calories[2] = Integer.parseInt(s1[i].substring(0, s1[i].length()-1));
			}
				
		}
		return calories;
	}

}
