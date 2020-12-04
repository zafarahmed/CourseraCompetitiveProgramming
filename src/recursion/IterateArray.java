package recursion;

public class IterateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		System.out.println( displayArrayElems(a,0));
		System.out.println( getExponent(2, 5));

	}
	
	public static String displayArrayElems( int[] a, int i ) {
		if( i >= a.length) {
			return "";
		}
		return a[i]+", "+displayArrayElems(a, i+1);
	}
	
	public static Integer getExponent( int a, int pow) {
		
		if(pow == 0) {
			return 1;
		}
		if(pow == 1) {
			return a;
		}
		return a * getExponent(a, pow-1);
	}

}
