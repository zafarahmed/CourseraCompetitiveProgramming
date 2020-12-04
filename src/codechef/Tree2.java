package codechef;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Tree2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			Set<Integer> a = new HashSet<>(n);
			for (int j = 0; j < n; j++) {
				int elem = in.nextInt();
				if(elem > 0) {
					a.add(elem);
				}
			}
			System.out.println(a.size());
		}
		in.close();
		
	}
}

