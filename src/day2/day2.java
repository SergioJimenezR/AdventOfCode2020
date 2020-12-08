package day2;

import utils.parse;

public class day2 {

	public static void main(String[] args) {

		String[] input = parse.readString("input2.txt");

		int count = 0;
		for (int i = 0; i < input.length; i++) {
			Password p = new Password(input[i]);
			if (p.isCorrect1())
				count++;
		}

		System.out.println(count);

	}

}
