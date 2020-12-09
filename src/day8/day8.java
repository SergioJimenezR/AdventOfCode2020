package day8;

import java.util.ArrayList;

import utils.parse;

public class day8 {

	public static void main(String[] args) {

		firstHalf(parse.readString("input8.txt"));
		secondHalf(parse.readString("input8.txt"));

	}

	public static void firstHalf(String[] argv) {
		System.out.println(algoritmo(argv));
	}

	public static void secondHalf(String[] argv1) {
		ArrayList<Integer> jumpsIndex = new ArrayList<Integer>();
		for (int i = 0; i < argv1.length; i++)
			if (argv1[i].split(" ")[0].equals("jmp"))
				jumpsIndex.add(i);

		String[] argv2 = new String[argv1.length];
		for (int i = 0; i < jumpsIndex.size(); i++) {
			parse.copy(argv1, argv2);
			argv2[jumpsIndex.get(i)] = "nop " + argv1[jumpsIndex.get(i)].split(" ")[1];
			String res = algoritmo(argv2);
			if (res.split(" ")[0].equals("result"))
				System.out.println(res);
		}

	}

	public static String algoritmo(String[] argv) {
		int[] times = new int[argv.length];

		int index = 0;
		int accumulator = 0;
		while (++times[index] != 2 && index != argv.length - 1) {
			String op = argv[index].split(" ")[0];

			if (op.equals("nop")) {
				index++;
			} else if (op.equals("acc")) {
				accumulator += Integer.parseInt(argv[index].split(" ")[1]);
				index++;
			} else if (op.equals("jmp")) {
				index += Integer.parseInt(argv[index].split(" ")[1]);
			}
		}

		if (times[index] == 2) {
			return "loop " + accumulator;
		} else {
			return "result " + accumulator;
		}
	}

}
