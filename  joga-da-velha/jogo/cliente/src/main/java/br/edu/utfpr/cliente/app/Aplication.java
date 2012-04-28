package br.edu.utfpr.cliente.app;

import java.rmi.RemoteException;

import br.edu.utfpr.cliente.rmi.RMICliente;
import br.edu.utfpr.cliente.view.JogoView;
import br.edu.utfpr.comum.RmiProvider;

public class Aplication {
	public static void main(String[] args) {
		try {
			final RmiProvider provider = new RMICliente().play();

			try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
						.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info
								.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException ex) {
				java.util.logging.Logger.getLogger(JogoView.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(JogoView.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(JogoView.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(JogoView.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			}

			java.awt.EventQueue.invokeLater(new Runnable() {

				public void run() {
					new JogoView(provider).setVisible(true);
				}
			});

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
