package day12;

import java.util.ArrayList;

public class day12 {

	static final String[] orientations = { "N", "E", "S", "W" };
	static int orientation = 1;

	static int Xaxis = 0;
	static int Yaxis = 0;

	public static void main(String[] args) {

		String[] input = utils.parse.readString("input12.txt");
		ArrayList<String> instructions = new ArrayList<String>();
		for (int i = 0; i < input.length; i++)
			instructions.add(input[i]);

		System.out.println("W/E: " + Xaxis + ". N/S: " + Yaxis + ".\nOrientation: " + orientation + " ("
				+ orientations[orientation] + ").\n");

		while (instructions.size() > 0)
			algorithm12a(instructions.remove(0));

		System.out.println("Result: " + (Math.abs(Yaxis) + Math.abs(Xaxis)) + ".");

	}

	private static void algorithm12a(String instruction) {

		char type = instruction.charAt(0);
		int number = Integer.parseInt(instruction.substring(1));

		switch (type) {
		case 'N':
			Yaxis += number;
			break;
		case 'S':
			Yaxis -= number;
			break;
		case 'E':
			Xaxis += number;
			break;
		case 'W':
			Xaxis -= number;
			break;
		case 'L':
			orientation = (orientation - number / 90 + 4) % 4;
			break;
		case 'R':
			orientation = (orientation + number / 90 + 4) % 4;
			break;
		case 'F':
			algorithm12a(orientations[orientation] + number);
		}

		if (type != 'F')
			System.out.println(instruction + "\nW/E: " + Xaxis + ". N/S: " + Yaxis + ".\nOrientation: " + orientation
					+ " (" + orientations[orientation] + ").\n");

	}

}
