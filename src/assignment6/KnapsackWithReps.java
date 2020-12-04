package assignment6;

public class KnapsackWithReps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int W = 10;
		int[] w = { 6, 3, 4, 2 };
		int[] v = {30, 14, 16, 9};
		int[] table = new int[W+1];
		for (int i = 0; i < table.length; i++) {
			table[i] = -1;
		}
		
		System.out.println(solve(W, w, v, table));
		solveItr(W, w, v, table);
	}
	
	public static int solve( int W, int[] w, int[] v, int[] table) {
		
		if( table[W] == -1 ) {
			table[W] = 0;
		}
		
		for (int i = 0; i < w.length; i++) {
			if( w[i] <= W ) {
				table[W] = Math.max(table[W], solve(W - w[i], w, v, table) + v[i]);
			}
		}
		return table[W];
		
	}
	
	public static void solveItr( int W, int[] w, int[] v, int[] table ) {
		for (int i = 0; i < table.length; i++) {
			table[i] = 0;
		}
		
		for (int i = 1; i < W+1; i++) {
			for (int j = 0; j < w.length; j++) {
				
				if( w[j] <= i ) {
					table[i] = Math.max(table[i], table[i-w[j]]+v[j]);
				}
				
			}
		}
		System.out.println(table[W]);
	}

}
