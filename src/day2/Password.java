package day2;

import utils.parse;

public class Password {

	private int min;
	private int max;
	private String letter;
	private String password;

	public Password(String str) {
		String[] parts = str.split(":");
		password = parts[1].substring(1);

		String[] policy = parts[0].split(" ");
		min = Integer.parseInt((policy[0].split("-"))[0]);
		max = Integer.parseInt((policy[0].split("-"))[1]);
		letter = policy[1];
	}

	public boolean isCorrect1() {
		
		

		int count = parse.countString(password, letter);

		if (count >= min && count <= max)
			return true;
		return false;
	}

	public boolean isCorrect2() {
		return password.charAt(min - 1) == letter.charAt(0) ^ password.charAt(max - 1) == letter.charAt(0);
	}

}
