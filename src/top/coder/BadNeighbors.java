package top.coder;

import java.util.Arrays;

public class BadNeighbors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int[] donations = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };//{ 7, 7, 7, 7, 7, 7, 7 };//{ 11, 15 };//{ 10, 3, 2, 5, 7, 8 };
		System.out.println(maxDonations(donations));
	}
	
	public static int maxDonations( int[] donations ) {
		
		return Math.max(getMaxDonations(0, donations.length-1, donations), getMaxDonations(1, donations.length, donations));
	}
	
	public static int getMaxDonations( int start, int end, int[] donations) {
		
		int table[] = new int[end+1];
		//int n = donations.length;
		
		for (int i = start+1; i < table.length; i++) {
			table[i] = donations[i-1];
			for (int j = start+1; j < i; j++) {
				if( j <i- 1  ) {
					table[i] = Math.max(table[i], donations[i-1] + table[j]);
				}
				
			}
		}
		Arrays.sort(table);
		return table[table.length-1];
	}

}
