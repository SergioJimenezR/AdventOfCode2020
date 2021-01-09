package day9;

import java.math.BigInteger;

import utils.parse;

public class day9 {

	public static void main(String[] args) {
		String[] numeros = parse.readString("input9.txt");
		BigInteger[] v = new BigInteger[numeros.length];
		for (int i = 0; i < v.length; i++)
			v[i] = new BigInteger(numeros[i]);

		System.out.println(problem9A(v).toString());

	}

	private static BigInteger problem9A(BigInteger[] numeros) {

		int i;
		for (i = 25; i < numeros.length && isSum(numeros, i); i++)
			;

		return numeros[i];
	}
	
	private static boolean isSum(BigInteger[] numeros, int index) {
		for(int i = index - 25; i < index; i++) {
			for(int j = index - 25; j < index; j++) {
				if(i != j) {
					if(numeros[i].add(numeros[j]).equals(numeros[index])) {
						return true;
					}
				}
			}
		}
		return false;
		
		
	}

}