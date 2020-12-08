package day1;

import utils.parse;

public class day1 {

	public static void main(String[] args) {

		int[] A = parse.readInt("input1.txt");
		firstHalf(A);
		secondHalf(A);
		
	}

	public static void firstHalf(int[] A) {
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A.length; j++)
				if (A[i] + A[j] == 2020) {
					System.out.println(A[i] * A[j]);
					return;
				}
	}

	public static void secondHalf(int[] A) {
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A.length; j++)
				for (int k = 0; k < A.length; k++)
					if (A[i] + A[j] + A[k] == 2020) {
						System.out.println(A[i] * A[j] * A[k]);
						return;
					}
	}

}
