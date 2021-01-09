package day6;

import utils.parse;
import java.util.ArrayList;

public class day6 {

	public static void main(String[] args) {

		String[] input = parse.readString("input6.txt");

		ArrayList<String> grupos = new ArrayList<String>();
		grupos.add("");
		for (int i = 0; i < input.length; i++)
			if (input[i].equals(""))
				grupos.add("");
			else
				grupos.add(grupos.remove(grupos.size() - 1) + input[i]);
		
		//int suma
		for(int i = 0; i < grupos.size(); i++) {
			
		}

	}

}
