package br.edu.utfpr.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RmiProvider extends Remote{

	Resultado efetuarJogada(String posicao, Jogador vez)throws RemoteException;
	
	void incluirJogador (Jogador jogador) throws RemoteException;
		
	List<Jogador> getJogadores() throws RemoteException;
	
	void novoJogo() throws RemoteException;

}
