package practice;

public class SwapTest {
	
	Integer a;
	Integer b;
	
	public SwapTest( int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public static void swap(SwapTest obj)
	{
		Integer temp = obj.a;
		obj.a = obj.b;
		obj.b = temp;
		System.out.println(obj.a + " " +obj.b);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapTest s = new SwapTest( 5, 7);
		swap(s);
		System.out.println(s.a + " " +s.b);

	}
	

}

