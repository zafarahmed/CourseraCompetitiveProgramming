package practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution3 {
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        
	        for(int a0 = 0; a0 < t; a0++){
	            long n = in.nextLong();
	            Set<Long> primeFact = new HashSet<>();
	            long nSqrt = (long)Math.sqrt(n);
	            while( n%2 == 0){
	                n = n/2;
	                primeFact.add(2l);
	            }
	            for (long i = 3; i <= nSqrt; i += 2) {
					
	            	while( n % i == 0) {
	            		n = n/i;
	            		primeFact.add(i);
	            	}
				}
	            if(n>2) {
	            	primeFact.add(n);
	            }
	            System.out.println( Collections.max(primeFact) );

	        }
	        in.close();
	    }
}
