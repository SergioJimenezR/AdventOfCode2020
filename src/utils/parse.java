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

	public static String fromIntToBin(int decimal) {
		String bin = "";
		for (; decimal >= 2; decimal /= 2)
			bin = decimal % 2 + bin;
		return decimal + bin;
	}

	public static int fromBinToInt(String bin) {
		int decimal = 0;

		for (int i = 0; i < bin.length(); i++)
			if (bin.charAt(bin.length() - 1 - i) == '1')
				decimal += Math.pow(2, i);

		return decimal;
	}

	public static int fromStringBinToInt(String S, char equals1, char equals0) {
		String R = "";
		for (int i = 0; i < S.length(); i++)
			if (S.charAt(i) == equals1)
				R += "1";
			else
				R += "0";
		return fromBinToInt(R);
	}

}
