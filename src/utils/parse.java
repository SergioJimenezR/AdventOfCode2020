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

		/* int count = 0;
		 * for (int i = 0; i < string.length(); i++)
		 *	if (string.charAt(i) == substring.charAt(0))
		 *		count++;
		 */

		int count = string.length() - string.replace(substring, "").length();

		return count;
	}

}
