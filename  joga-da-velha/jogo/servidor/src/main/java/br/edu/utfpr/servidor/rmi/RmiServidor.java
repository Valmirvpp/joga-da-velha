package br.edu.utfpr.servidor.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.comum.Jogador;
import br.edu.utfpr.comum.RmiProvider;

public class RmiServidor{
	
	List<Jogador> jogadores;
	
	public RmiServidor() {
		jogadores = new ArrayList<Jogador>();
		inicia();
	}
	
	public void inicia(){
		try {
			RmiProvider provider = new RmiProviderImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("JogoDaVelha", provider);
            System.out.println("Servidor executando servico 'JogoDaVelha'");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
