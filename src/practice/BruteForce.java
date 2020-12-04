package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BruteForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		List<String> robList = new ArrayList<>();
		String[] s = {"a","b"};
		
//		for (int i = 0; i < s.length; i++) {
//			for (int j = 0; j < s.length; j++) {
//				for (int j2 = 0; j2 < s.length; j2++) {
//					for (int k = 0; k < s.length; k++) {
//						String str = s[i]+s[j]+s[j2]+s[k];
//						list.add(str);
//					}
//				}
//			}
//		}
		
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 2; j++) {
//				for (int j2 = 0; j2 < 2; j2++) {
//					String val = i+" "+j+" "+j2;
//					robList.add(val);
//				}
//			}
//		}
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if(j != i )
				{
					for (int j2 = 1; j2 <= 3; j2++) {
						if(j != j2 && j != i)
						{
							//if (i!=j && j!=j2 && j2 != i) {
								String str = i + " " + j + " " + j2;
								robList.add(str);
							//}
						}
						
				 	}	
				}
				
			}
		}
		int[][] arr = new int[1][2];
		List<Integer> lInt = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				lInt.add(i);
				lInt.add(j);
			}
		}
		int i = 0;
		while (i < lInt.size()) {
			
			for (int j = 0; j < 1; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					arr[j][j2] = lInt.get(i);
					i++;
				}
			}
			
			for (int j = 0; j < 1; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					System.out.print(arr[j][j2] + " ");
				}
			}
			System.out.println();
			
		}
		
//		System.out.println(robList.size());
//		for (String item : robList) {
//			System.out.println(item);
//		}
//		String pattern[] =new String[5];
//		recursiveGen(5, 0, s, list, pattern);
//		System.out.println(list.size());
//		for (String string : list) {
//			System.out.println(string);
//		}

	}
	
	private static void recursiveGen(int n, int forCount, String[] x, List<String> list, String[] pattern)
	{
		if(forCount < n)
		{
			for (int i = 0; i < x.length; i++) {
				pattern[forCount] = x[i];
				recursiveGen(n, forCount+1, x, list, pattern);
			}
		}
		else {
			list.add(String.join("", pattern));
		}
	}

}
