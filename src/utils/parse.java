package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class parse {

	public static int[] readInt(String dir) {
		return parseFromStringToInt(readString(dir));
	}

	public static String[] readString(String dir) {

		ArrayList<String> L = new ArrayList<String>();

		try {
			Scanner sc = new Scanner(new File("resources/" + dir));
			while (sc.hasNextLine())
				L.add(sc.nextLine());
		} catch (FileNotFoundException fnfe) {
			System.out.println("Directory " + dir + " doesn't exist.");
		}

		return L.toArray(new String[0]);
	}

	public static int[] parseFromStringToInt(String[] input) {

		int[] output = new int[input.length];

		for (int i = 0; i < input.length; i++)
			output[i] = Integer.parseInt(input[i]);

		return output;
	}

	public static int countString(String string, String substring) {

		int count = string.length() - string.replace(substring, "").length();

		return count;
	}

	public static void copy(String[] from, String[] to) {
		for (int i = 0; i < from.length; i++)
			to[i] = from[i];
	}

	public static boolean isBetween(int n, int min, int max) {
		return min <= n && n <= max;
	}

	public static boolean isHexadecimal(char h) {
		return isBetween((int) h, 48, 57) || isBetween((int) h, 97, 102);
	}

	public static boolean isRGB(String hexa) {
		hexa = hexa.toUpperCase();
		if (hexa.charAt(0) == '#') {
			for (int i = 1; i < hexa.length(); i++)
				if (!isHexadecimal(hexa.charAt(i)))
					return false;
		} else
			return false;
		return true;
	}

	public static boolean contains(Object[] a, Object b) {
		for (int i = 0; i < a.length; i++)
			if (a[i].equals(b))
				return true;
		return false;
	}

	public static boolean allNumbers(String s) {
		for (int i = 0; i < s.length(); i++)
			if (!isBetween((int) s.charAt(i), 48, 57))
				return false;
		return true;
	}

}
