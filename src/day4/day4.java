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
		/*String forEcl[] = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };

		int count = 0;
		for (int i = 0; i < passport.size(); i++) {
			String[] a = passport.get(i).split(" ");
			for (int j = 0; j < a.length; j++) {
				String secondPart = a[j].split(":")[1];
				switch (a[j].split(":")[0]) {
				case "byr":
					if (parse.isBetween(Integer.parseInt(secondPart), 1920, 2002)) {
						count++;
					} else {
						return false;
					}
					break;
				case "iyr":
					if (parse.isBetween(Integer.parseInt(secondPart), 2010, 2020)) {
						count++;
					} else {
						return false;
					}
					break;
				case "eyr":
					if (parse.isBetween(Integer.parseInt(secondPart), 2020, 2030)) {
						count++;
					} else {
						return false;
					}
					break;
				case "hgt":
					String b[] = { secondPart.substring(0, secondPart.length() - 3),
							secondPart.substring(secondPart.length() - 2) };
					if (b[1].equals("cm")) {
						if (!parse.isBetween(Integer.parseInt(b[0]), 150, 193))
							return false;
						count++;
					} else if (b[1].equals("in")) {
						if (!parse.isBetween(Integer.parseInt(b[0]), 59, 76))
							return false;
						count++;
					} else {
						return false;
					}
					break;
				case "hcl":
					if (!parse.isRGB(secondPart))
						return false;
					count++;
					break;
				case "ecl":
					if (!parse.contains(forEcl, secondPart))
						return false;
					count++;
					break;
				case "pid":
					if (!(secondPart.length() == 9 && parse.allNumbers(secondPart)))
						return false;
					count++;
					break;
				default:
					break;
				}

				if (!a[j].split(":")[0].equals("cid"))
					count++;
			}
		}
		return count == 7 ? true : false;*/
		
		return false;
	}

}
