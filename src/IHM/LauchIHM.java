package IHM;

import javax.swing.*;

/**
 * @version 1.0
 * @author SERHIR
 * @author ZARGA
 * @deprecated Utiliser InterfaceGraphique
 */
public class LauchIHM {

	@SuppressWarnings({})
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				EvalFenetre frame = new EvalFenetre();
				frame.setVisible(true);
			}
		});
	}

}
