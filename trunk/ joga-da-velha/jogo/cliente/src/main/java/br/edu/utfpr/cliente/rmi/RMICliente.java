package br.edu.utfpr.cliente.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import br.edu.utfpr.comum.Jogador;
import br.edu.utfpr.comum.RmiProvider;

public class RMICliente {
	Jogador jogador1;
	Jogador jogador2;

	public RMICliente() {
		jogador1 = new Jogador(JOptionPane.showInputDialog("Informe o nome do Primeiro Jogador", null), 0L);
		jogador2 = new Jogador(JOptionPane.showInputDialog("Informe o nome do Segundo Jogador", null), 1L);
	}

	public RmiProvider play() throws RemoteException {
		
			try {
	            RmiProvider provider = (RmiProvider) Naming.lookup("rmi://localhost:1099/JogoDaVelha");
	            
	            provider.incluirJogador(jogador1);
	            provider.incluirJogador(jogador2);
	            
	            return provider;
			} catch (NotBoundException e) {
				e.printStackTrace();
				return null;
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return null;
			}

	}
}
