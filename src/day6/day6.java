package day6;

import java.util.ArrayList;

public class day6 {

	public static void main(String[] args) {

		ArrayList<String> grupos = obtenerGrupos(utils.parse.readString("input6.txt"));

		System.out.println(contarParte1(grupos));
		System.out.println(separarGrupos(grupos));

	}

	private static ArrayList<String> obtenerGrupos(String[] input) {
		ArrayList<String> grupos = new ArrayList<String>();
		grupos.add("");
		for (int i = 0; i < input.length; i++)
			if (input[i].equals(""))
				grupos.add("");
			else
				grupos.add(grupos.remove(grupos.size() - 1) + " " + input[i]);
		return grupos;
	}

	private static int contarParte1(ArrayList<String> grupos) {
		int contador = 0;

		for (int i = 0; i < grupos.size(); i++) {
			String g = grupos.get(i);
			ArrayList<Character> charact = new ArrayList<Character>();
			for (int j = 0; j < g.length(); j++)
				if (!charact.contains(g.charAt(j)) && g.charAt(j) != ' ')
					charact.add(g.charAt(j));
			contador += charact.size();
		}

		return contador;
	}

	private static int contarParte2(ArrayList<String> M) {

		int R = M.size() - 1;

		int contadorCaracteres = 0;
		for (int i = 0; i < M.get(0).length(); i++) {
			int contadorVectores = 0;
			boolean continuarV = true;
			for (int v = 1; v < M.size() && continuarV; v++) {
				int j;
				boolean continuarJ = true;
				for (j = 0; j < M.get(v).length() && continuarJ; j++)
					if (M.get(0).charAt(i) == M.get(v).charAt(j)) {
						contadorVectores++;
						continuarJ = false;
					}
				if (j == M.get(v).length() - 1 && continuarJ)
					continuarV = false;
			}
			if (contadorVectores == R)
				contadorCaracteres++;
		}

		// Los boolean continuarJ y continuarV podan por eficiencia.

		return contadorCaracteres;
	}

	private static int separarGrupos(ArrayList<String> grupos) {

		int contadorGeneral = 0;
		for (int i = 0; i < grupos.size(); i++) {
			String g = grupos.get(i);

			ArrayList<String> L = new ArrayList<String>();
			for (int j = 0; j < g.length(); j++)
				if (g.charAt(j) == ' ')
					L.add("");
				else
					L.add(L.remove(L.size() - 1) + g.charAt(j));
			contadorGeneral += contarParte2(L);
		}

		return contadorGeneral;
	}

}
