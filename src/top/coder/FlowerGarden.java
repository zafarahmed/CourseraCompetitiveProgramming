package top.coder;

public class FlowerGarden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {3,2,5,4};//{1,2,3,4,5,6};//{5,4,3,2,1};//{5,4,3,2,1};//{5,4,3,2,1};//{5,4,3,2,1};
		int[] bloom =  {1,2,11,10};//{1,3,1,3,1,3};//{1,5,10,15,20};//{1,5,10,15,20};//{1,5,10,15,20};//{1,1,1,1,1};
		int[] wilt = {4,3,12,13};//{2,4,2,4,2,4};//{5,10,14,20,25};//{5,10,15,20,25};//{4,9,14,19,24};//{365,365,365,365,365};
		int[] result = getOrdering(height, bloom, wilt);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
	
	public static int[] getOrdering(int[] height, int[] bloom, int[] wilt)
	{
		int n = height.length;
		for (int i = 0; i < n; i++) {
			int currIdx = i;
			int currHt = height[i];
			int currB = bloom[i];
			int currW = wilt[i];
			for (int j = i-1; j >=0; j--) {
				if( currHt < height[j] && currB <= wilt[j] ) {
//					int tempH = height[j];
//					int tempB = bloom[j];
//					int tempW = wilt[j];
//					
					for (int k = currIdx-1; k >= j; k--) {
						height[k+1] = height[k];
						bloom[k+1] = bloom[k];
						wilt[k+1] = wilt[k];
					}
//					height[currIdx] = tempH;
//					bloom[currIdx] = tempB;
//					wilt[currIdx] = tempW;
					
					height[j] = currHt;
					bloom[j] = currB;
					wilt[j] = currW;
					
					currIdx = j;
					
				}
				else if( currHt > height[j] && currB > wilt[j] ) {
//					int tempH = height[j];
//					int tempB = bloom[j];
//					int tempW = wilt[j];
					
					for (int k = currIdx-1; k >= j; k--) {
						height[k+1] = height[k];
						bloom[k+1] = bloom[k];
						wilt[k+1] = wilt[k];
					}
					
//					height[currIdx] = tempH;
//					bloom[currIdx] = tempB;
//					wilt[currIdx] = tempW;
					
					height[j] = currHt;
					bloom[j] = currB;
					wilt[j] = currW;
					
					currIdx = j;
				}
			}
		}
		
		return height;
	}

}
