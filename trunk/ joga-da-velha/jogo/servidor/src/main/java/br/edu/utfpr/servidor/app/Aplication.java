package br.edu.utfpr.servidor.app;

import br.edu.utfpr.servidor.rmi.RmiServidor;

public class Aplication {
	public static void main(String[] args) {
		try {
			new RmiServidor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
