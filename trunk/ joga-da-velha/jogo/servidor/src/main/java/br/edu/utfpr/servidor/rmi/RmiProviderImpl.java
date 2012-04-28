package br.edu.utfpr.servidor.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.comum.Jogador;
import br.edu.utfpr.comum.Resultado;
import br.edu.utfpr.comum.RmiProvider;

public class RmiProviderImpl extends UnicastRemoteObject  implements RmiProvider{

	private static final long serialVersionUID = 1L;
	List<Jogador> jogadores;
	Integer matriz[][];
	
	public RmiProviderImpl() throws RemoteException {
		super();
		jogadores = new ArrayList<Jogador>();
		matriz = new Integer[3][3];
	}
	
	public void novoJogo() throws RemoteException {
		matriz = new Integer[3][3];
	}

	public Resultado efetuarJogada(String posicao,Jogador jogador) throws RemoteException {
		return jogar(posicao, jogador);
	}

	public List<Jogador> getJogadores() throws RemoteException {
		return jogadores;
	}

	public void incluirJogador(Jogador jogador) throws RemoteException {
		jogadores.add(jogador);
	}
	
	protected Resultado jogar(String p,Jogador jogador){
		Integer l = Integer.parseInt(String.valueOf(p.charAt(0)));
		Integer c = Integer.parseInt(String.valueOf(p.charAt(1)));
		Integer jogada = Integer.valueOf(jogador.getId().toString());

		matriz[l][c] = jogada;

		return verifica(l,c,jogada, jogador);
	}
	
	protected Resultado verifica(Integer l, Integer c, Integer jogada,Jogador jogador){
	
		try {
			//verifica as linhas
			if ((matriz[l][0] == jogada) && (matriz[l][1] == jogada) && (matriz[l][2] == jogada)) {
				return Resultado.VITORIA;
			}
			
			//verifica as colunas
			if ((matriz[0][c] == jogada) && (matriz[1][c] == jogada) && (matriz[2][c] == jogada)) {
				return Resultado.VITORIA;
			}
			
			//verifica as diagonais
			if ((matriz[0][0] == jogada) && (matriz[1][1] == jogada) && (matriz[2][2] == jogada)) {
				return Resultado.VITORIA;
			}
			
			//verifica as diagonais
			if ((matriz[0][2] == jogada) && (matriz[1][1] == jogada) && (matriz[2][0] == jogada)) {
				return Resultado.VITORIA;
			}
			
			if(Resultado.EMPATE == verificaEmpate()){
				return Resultado.EMPATE;
			}
			
		} catch (Exception e) {
			return Resultado.CONTINUA;
		}
		
		return Resultado.CONTINUA;
	}

	private Resultado verificaEmpate() {
		try {
			for (int l = 0; l < 3; l++) {
				for (int c = 0; c < 3; c++) {
					if(matriz[l][c] == null){
						return Resultado.CONTINUA;
					}
				}
			}
			return Resultado.EMPATE;
		} catch (Exception e) {
			return Resultado.CONTINUA;
		}
	}

	

}
