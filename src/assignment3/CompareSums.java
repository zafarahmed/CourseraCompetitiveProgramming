package assignment3;


import java.text.DecimalFormat;
import java.util.Scanner;

public class CompareSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		int size = in.nextInt();
		double sumA = 0.0;
		double sumB = 0.0;
		for (int i = 0; i < size; i++) {
			sumA += in.nextDouble();
		}
		for (int i = 0; i < size; i++) {
			sumB += in.nextDouble();
		}
		in.close();
		DecimalFormat df = new DecimalFormat("#.#########");
		sumA = Double.parseDouble(df.format(sumA));
		sumB = Double.parseDouble(df.format(sumB));
		//System.out.println(sumA + " " + sumB);
		
		if( sumA < sumB ) {
			System.out.println("SUM(A)<SUM(B)");
		}
		else if( sumA  > sumB )
		{
			System.out.println("SUM(A)>SUM(B)");
		}
		else
		{
			System.out.println("SUM(A)=SUM(B)");
		}

	}

}
