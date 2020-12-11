package day4;

import java.util.ArrayList;

import utils.parse;

public class day4 {

	public static void main(String[] args) {

		String[] passports = parse.readString("input4.txt");
		ArrayList<String> passport = new ArrayList<String>();

		int count = 0;
		for (int i = 0; i < passports.length; i++) {
			if (!passports[i].equals("")) {
				passport.add(passports[i]);
			} else {
				count += isValid1(passport) ? 1 : 0;
				passport.clear();
			}
		}

		System.out.println(count);

	}

	public static boolean isValid1(ArrayList<String> passport) {
		String forEcl[] = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };

		int count = 0;
		for (int i = 0; i < passport.size(); i++) {
			String[] a = passport.get(i).split(" ");
			for (int j = 0; j < a.length; j++)
				if (!a[j].split(":")[0].equals("cid"))
					count++;
		}
		return count == 7 ? true : false;
	}

	public static boolean isValid2(ArrayList<String> passport) {
		return false;
	}

}
