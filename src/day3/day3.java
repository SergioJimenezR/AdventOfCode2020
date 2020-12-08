package day3;

import utils.parse;

public class day3 {

	public static void main(String[] args) {

		final String[] map = parse.readString("input3.txt");

		System.out.println(parse.countString(path(map, 3, 1), "#"));

		long n1 = parse.countString(path(map, 1, 1), "#");
		long n2 = parse.countString(path(map, 3, 1), "#");
		long n3 = parse.countString(path(map, 5, 1), "#");
		long n4 = parse.countString(path(map, 7, 1), "#");
		long n5 = parse.countString(path(map, 1, 2), "#");

		System.out.println(n1 * n2 * n3 * n4 * n5);

	}

	public static String path(String[] map, int right, int down) {
		String str = map[0].charAt(0) + "";

		for (int i = 1; i < map.length; i += down)
			str += map[i].charAt((right * i) % map[i].length());

		return str;
	}

}
