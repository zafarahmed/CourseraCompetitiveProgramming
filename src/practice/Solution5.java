package practice;

import java.util.Scanner;

public class Solution5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37};
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long primeProd = 1;
           // long diff = 1;
            
            for (int i = 0; i < primes.length; i++) {
                if(primes[i] <= n) {
                   long temp = primes[i];
                   while( temp*primes[i] <= n) {
                	   temp = temp * primes[i];
                   }
                   primeProd *= temp;
                    
                }
            }
//            for (int i = 1; i <= n; i++) {
//			 rem = primeProd % i;
//				if(rem > 0) {
//					diff = diff * rem;
//				}
//			}
            System.out.println( primeProd );
        }
        in.close();
    }
}
