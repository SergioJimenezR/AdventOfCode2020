package day5;

import java.util.ArrayList;

import utils.parse;

public class day5 {

	public static void main(String[] args) {
		String[] sets = parse.readString("input5.txt");
		
		firstHalf(sets);
		secondHalf(sets);
	}

	public static void firstHalf(String[] sets) {
		int max = 0;
		for (int i = 0; i < sets.length; i++) {
			int result = parse.fromStringBinToInt(sets[i].substring(0, sets[i].length() - 3), 'B', 'F') * 8
					+ parse.fromStringBinToInt(sets[i].substring(sets[i].length() - 3), 'R', 'L');
			if (result > max)
				max = result;
		}
		System.out.println(max);
	}

	public static void secondHalf(String[] sets) {

		ArrayList<Integer> asientosOriginales = new ArrayList<Integer>();
		for (int i = 0; i < sets.length; i++)
			asientosOriginales.add(parse.fromStringBinToInt(sets[i].substring(0, sets[i].length() - 3), 'B', 'F') * 8
					+ parse.fromStringBinToInt(sets[i].substring(sets[i].length() - 3), 'R', 'L'));

		for (int F = 1; F <= 126; F++)
			for (int C = 0; C <= 7; C++) {
				int ID = F * 8 + C;
				if (!asientosOriginales.contains(ID) && asientosOriginales.contains(ID - 1)
						&& asientosOriginales.contains(ID + 1)) {
					System.out.println(ID);
				}
			}
	}

}
