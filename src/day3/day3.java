package day3;

import utils.parse;

public class day3 {

	public static void main(String[] args) {

		final String[] map = parse.readString("input3.txt");

		System.out.println(parse.countString(path(map, 3, 1), "#"));

		long n1 = parse.countString(path(map, 1, 1), "#");
		n1 *= parse.countString(path(map, 3, 1), "#");
		n1 *= parse.countString(path(map, 5, 1), "#");
		n1 *= parse.countString(path(map, 7, 1), "#");
		n1 *= parse.countString(path(map, 1, 2), "#");

		System.out.println(n1);

	}

	public static String path(String[] map, int right, int down) {
		String str = "";

		for (int i = 0; i * down < map.length; i++)
			str += map[i * down].charAt((right * i) % map[i].length());

		return str;
	}
	
}