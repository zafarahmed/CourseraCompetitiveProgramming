package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Long> palindromeList = new ArrayList<>();
        for( int i =100; i < 1000; i++ ){
            for( int j = 100; j < 1000; j ++){
                long val = i * j;
                String s = String.valueOf( val);
                if( s.equals(reverse(s))) {
                	palindromeList.add(val);
                }
            }
        }
        Collections.sort(palindromeList);
       //System.out.println(palindromeList);
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            for (int i = palindromeList.size()-1; i >=0; i--) {
				if(palindromeList.get(i) < n) {
					System.out.println( palindromeList.get(i));
					break;
				}
			}
        }
        in.close();
    }
    
    public static String reverse( String s) {
    	String sRev = "";
    	for (int i = s.length()-1; i >=0; i--) {
			sRev = sRev + s.charAt(i);
		}
    	
    	return sRev;
    }
}