package codechef;

import java.util.Scanner;

public class Leadgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long max = 0;
		long player = 0;
		long p1Score = 0;
		long p2Score = 0;
		for (int i = 0; i < n; i++) {
			 p1Score += in.nextLong();
			 p2Score += in.nextLong();
			//System.out.println(p1Score + " " + p2Score);
			long diff = p1Score > p2Score ? p1Score - p2Score : p2Score - p1Score;
			long winner = p1Score > p2Score ? 1 :2;
			if(diff > max) {
				max = diff;
				player = winner;
			}
		}
		in.close();
		System.out.println(player + " " + max);
		
	}

}
