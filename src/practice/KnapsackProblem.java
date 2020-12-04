package practice;

public class KnapsackProblem {
	
	public static int knapsack( int capacity, int[] wt, int val[], int currentItem, int[][] track) {
		
		if( currentItem  == 0 || capacity == 0) {
			return 0;
		}
		if (track[currentItem][capacity] != -1) {
			return track[currentItem][capacity];
		}
		
		if( wt[currentItem-1] > capacity ) {
			track[currentItem][capacity] =  knapsack(capacity, wt, val, currentItem-1, track);
			System.out.println(currentItem + " " + capacity + " = " + track[currentItem][capacity]);
			return track[currentItem][capacity];
		}
		else {
			int temp1 = val[currentItem-1] + knapsack(capacity-wt[currentItem-1], wt, val, currentItem-1,track);
			System.out.println(currentItem + " " + capacity + " = " + temp1);
			int temp2 = knapsack(capacity, wt, val, currentItem-1, track);
			System.out.println(currentItem + " " + capacity + " = " + temp2);
			track[currentItem][capacity] =  temp1>temp2?temp1:temp2;
			
			return track[currentItem][capacity];
		}
		
		//return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int val[] = new int[] { 60, 100, 120 }; 
	        int wt[] = new int[] { 10, 20, 30 }; 
	        int W = 50; 
        int n = val.length; 
        int track[][] = new int[n + 1][W+1];
        for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W+1; j++) {
				track[i][j]=-1;
			}
		}
        System.out.println(knapsack(W, wt, val, n, track));
	}

}
