package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class Booklist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int[] bookList = new int[m];
		for (int i = 0; i < bookList.length; i++) {
			bookList[i] = in.nextInt();
		}
		int n = in.nextInt();
		int borrowList[] = new int[n];
		for (int i = 0; i < borrowList.length; i++) {
			borrowList[i] = in.nextInt();
		}
		in.close();
		int[] borrowListCopy = Arrays.copyOf(borrowList, borrowList.length);
		Arrays.sort(borrowListCopy);
		for (int i = 0; i < borrowList.length; i++) {
			int book = borrowList[i];
			int pos = Arrays.binarySearch(borrowListCopy, book);
			System.out.println(bookList[book+pos-1]);
		}
				
	}

}
