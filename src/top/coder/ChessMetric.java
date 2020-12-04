package top.coder;

public class ChessMetric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = {0,0};
		int[] end = {0,1};
		System.out.println(howMany(2, start, end, 2));
	}
	
	public static long howMany(int size, int[] start, int[] end, int numMoves) {
		long table[][] = new long[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				table[i][j] = -1;
			}
		}
		//table[start[0]][start[1]] = 1;
		long res = solve(size, start[0], start[1], end[0], end[1], numMoves, table);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(table[i][j]); 
			}
			System.out.println();
		}
		
		return table[end[0]][end[1]];
	}
	
	public static long solve( int n, int i, int j,int l, int m,  int moves, long[][] table) {
		if( l >= 0 && m>= 0 && l < n && m < n ) {
		
		if( table[l][m] == -1) {
			if( moves == 0 && l == i && m == j) {
				return 1;
			}
			else {
				if( moves > 0) {
					table[l][m] = solve(n, i, j, l+1, m,    moves-1, table) 
								+ solve(n, i, j, l,   m+1,  moves-1, table)
								+ solve(n, i, j, l-1, m,    moves-1, table)
								+ solve(n, i, j, l,   m-1,  moves-1, table)
								+ solve(n, i, j, l+1, m+1,  moves-1, table)
								+ solve(n, i, j, l+1, m-1,  moves-1, table)
								+ solve(n, i, j, l-1, m-1,  moves-1, table)
								+ solve(n, i, j, l-1, m+1,  moves-1, table)
								
								+ solve(n, i, j, l-2, m-1,  moves-1, table)
								+ solve(n, i, j, l-1, m-2,  moves-1, table)
								+ solve(n, i, j, l+2, m-1,  moves-1, table)
								+ solve(n, i, j, l+1, m-2,  moves-1, table)
								+ solve(n, i, j, l-2, m+1,  moves-1, table)
								+ solve(n, i, j, l-2, m+2,  moves-1, table)
								+ solve(n, i, j, l+1, m+2,  moves-1, table)
								+ solve(n, i, j, l+2, m+1,  moves-1, table);
				}
				
			}
			
		}
	}
		else {
			return 0;
		}
		return table[l][m];
	}

}
