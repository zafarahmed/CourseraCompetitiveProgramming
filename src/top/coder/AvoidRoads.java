package top.coder;

public class AvoidRoads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] bad = {"0 0 0 1","6 6 5 6"};
		String[] bad1 = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
		String[] bad2 = {};
		
		System.out.println(numWays(35, 31, bad2));
	}
	
	public static long numWays(int width, int height, String[] bad)
	{
		long[][] table = new long[width+1][height+1];
		for (int i = 0; i <= width; i++) {
			for (int j = 0; j <= height; j++) {
				table[i][j] = -1;
			}
		}
		return solve(width, height, width +height, bad, false, table);
	}
	
	public static long solve( int i, int j, int stepsLeft, String[] bad, boolean isBad,long[][] table) {
		if(isBad) {
			return 0;
		}
		if( table[i][j] == -1) {
			
			if( stepsLeft == 0 && i ==  0 && j == 0) {
				return 1;
			}
			else {
				if( stepsLeft > 0) {
					table[i][j] =  solve(i, j-1, stepsLeft-1, bad, isBad(bad, i, j, i, j-1), table)
					+ solve(i-1, j, stepsLeft-1, bad, isBad(bad, i, j, i-1, j), table);
					
				}
			}
			
		}
		
		
		return table[i][j];
	}
	
	public static boolean isBad( String[] bad, int a, int b, int c, int d ) {
		if( c<0 || d<0) {
			return true;
		}
		String s1 = a + " " + b + " " + c + " " + d;
		String s2 = c + " " + d + " " + a + " " + b;
		for (int i = 0; i < bad.length; i++) {
			if( bad[i].trim().equals(s1) || bad[i].trim().equals(s2)) {
				return true;
			}
		}
		return false;
	}

}
