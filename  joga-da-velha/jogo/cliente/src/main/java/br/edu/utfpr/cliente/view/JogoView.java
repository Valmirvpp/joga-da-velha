
package br.edu.utfpr.cliente.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.edu.utfpr.comum.Jogador;
import br.edu.utfpr.comum.Resultado;
import br.edu.utfpr.comum.RmiProvider;

public class JogoView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	Jogador jogador1,jogador2,vez;
	RmiProvider provider;
  
    public JogoView(RmiProvider provider) {
    	initComponents();
    	this.provider = provider;
    	
    	try {
			jogador1 = provider.getJogadores().get(0);
			jogador2 = provider.getJogadores().get(1);
			
			vez = jogador2;
			
			passaVez();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
    public void passaVez(){
    	if(vez.equals(jogador1)){
    		vez = jogador2;
    	}
    	else{
    		vez = jogador1;
    	}
    	
    	labelTopo.setText("Jogador da vez: "+vez.getNome());
    }

	public void event(String posicao, JButton botao) {
		try {
			if (botao.getIcon() == null) {// se ja tem icone é porque esse botao
											// ja foi marcado, logo nao faz nada
				if (vez.equals(jogador1)) {
					botao.setIcon(new ImageIcon(getClass().getClassLoader().getResource("x.png")));
				} else {
					botao.setIcon(new ImageIcon(getClass().getClassLoader().getResource("o.png")));
				}
				
				Resultado resultado = provider.efetuarJogada(posicao, vez);
				
				if (resultado.equals(Resultado.VITORIA)) {
					JOptionPane.showMessageDialog(this, "Jogador "+vez.getNome() + " ganhou o jogo!");
					provider.novoJogo();
					this.dispose();
					return;
				}
				
				else if (resultado.equals(Resultado.EMPATE)) {
					JOptionPane.showMessageDialog(this, "O jogo empatou!");
					provider.novoJogo();
					this.dispose();
					return;
				}
				passaVez();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt00 = new javax.swing.JButton();
        bt01 = new javax.swing.JButton();
        bt02 = new javax.swing.JButton();
        
        bt10 = new javax.swing.JButton();
        bt11 = new javax.swing.JButton();
        bt12 = new javax.swing.JButton();
        
        bt20 = new javax.swing.JButton();
        bt21 = new javax.swing.JButton();
        bt22 = new javax.swing.JButton();
        
        panelTopo = new javax.swing.JPanel();
        labelTopo = new javax.swing.JLabel();
        labelRodape = new javax.swing.JLabel();
        
        bt00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("00",bt00);
			}
		});
        
        bt01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("01",bt01);
			}
		});
        
        bt02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("02",bt02);
			}
		});
        
        bt10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("10",bt10);
			}
		});
        
        bt11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("11",bt11);
			}
		});
        
        bt12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("12",bt12);
			}
		});
        
        bt20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("20",bt20);
			}
		});
        
        bt21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("21",bt21);
			}
		});
        
        bt22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				event("22",bt22);
			}
		});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTopo.setBackground(new java.awt.Color(255, 255, 255));
        panelTopo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTopo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTopo.setText("Jogador da vez: ");

        javax.swing.GroupLayout panelTopoLayout = new javax.swing.GroupLayout(panelTopo);
        panelTopo.setLayout(panelTopoLayout);
        panelTopoLayout.setHorizontalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTopoLayout.setVerticalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTopo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelRodape.setText("Jogo da Velha v.1 -Desenvolvido por Luan Malaguti e Bernardo Vale");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(bt20, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt21, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(bt10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt22, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt00, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt01, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt02, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(labelRodape)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt01, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt02, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt00, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt21, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt22, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt20, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRodape)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt00;
    private javax.swing.JButton bt01;
    private javax.swing.JButton bt02;
    private javax.swing.JButton bt10;
    private javax.swing.JButton bt11;
    private javax.swing.JButton bt12;
    private javax.swing.JButton bt20;
    private javax.swing.JButton bt21;
    private javax.swing.JButton bt22;
    private javax.swing.JLabel labelRodape;
    private javax.swing.JLabel labelTopo;
    private javax.swing.JPanel panelTopo;
    // End of variables declaration//GEN-END:variables
}
