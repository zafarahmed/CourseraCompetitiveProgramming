package assignment4;

public class SegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		int[] tree = new int[arr.length * 2];
		build(tree, arr, 1, 0, arr.length-1);
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] +" ");
		}
	}
	
	static void build( int[] tree, int[] arr, int i, int a, int b ) {
		if( a == b) {
			tree[i] = arr[a];
		}
		else {
			for( int idx = a; idx <= b; idx++)
			{
				tree[i] += arr[idx];
			}
			int mid = (a+b)/2;
			build(tree, arr, 2*i, a, mid);
			build(tree, arr, 2*i+1, mid+1, b);
		}
		
	}

}
