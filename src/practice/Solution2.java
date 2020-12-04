package practice;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long prev = 0;
            long current = 1;
            long sum = 0;
            while( prev + current < n) {
                if((prev + current) % 2 == 0) {
                    sum += prev + current;
                    }
                long temp = current;
                current = current + prev;
                prev = temp;
            }
            System.out.println(sum);
        }
        in.close();
    }
}
