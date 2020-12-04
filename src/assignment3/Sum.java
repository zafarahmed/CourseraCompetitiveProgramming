package assignment3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double sum = 0.0;
		double fracSum = 0.0;
		for (int i = 0; i < n; i++) {
			double x = in.nextDouble();
			double x1 = 1/x;
			DecimalFormat df = new DecimalFormat("#.##########");
			x1 = Double.parseDouble(df.format(x1));
			sum = sum + x;
			fracSum = fracSum + x1;
		}
		in.close();
		System.out.println(sum+fracSum);
	}
	
	// Use Euclids GCD for better performance (Precision). 3333333333

}
