package com;

import java.util.Scanner;

public class Sample {

	public static void metodo1() throws Exception {
		Scanner s = new Scanner(System.in);
		Double d = null;
		while (d==null) {
			System.out.println("Introduce un n�mero decimal:");
			String numStr = s.nextLine();
			s.next();
			try {
				d = Double.parseDouble(numStr);
			} catch  (NumberFormatException nfe) {
				throw new Exception(nfe);
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
	
			//
			//
			metodo1();
			//
			System.out.println("Hola, pas� del m�todo 1");
			//
			System.out.println("Buenos d�as");
		
	}

}
