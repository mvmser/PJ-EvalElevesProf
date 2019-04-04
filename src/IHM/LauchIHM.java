package IHM;

import javax.swing.*;

public class LauchIHM {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				EvalFenetre frame = new EvalFenetre();
				frame.setVisible(true);
			}
		});
	}

}
