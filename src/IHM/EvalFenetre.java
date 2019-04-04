package IHM;

import java.awt.*;
import javax.swing.*;

public class EvalFenetre extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel labelNom, labelPrenom, labelAnnee;
	private JTextField textFieldNom, textFieldPrenom, textField, textFieldAnnee;
	private JPanel panel, panelSaisie, panelResult, panelButtons, panelNom, panelPrenom, panelNaissance;
	private JButton buttonAgeCalcul, buttonReverse;
	private int anneeCours;
	
	
	public EvalFenetre() {
		super();
		build(); //On initialise notre fenetre
	}

	public void build() {
		this.setTitle("Evaluation Eleve / Professeur"); 
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //regarder c quoi
		this.setResizable(true); 
		
		setContentPane(buildContentPane());
	}


	private JPanel buildContentPane(){
		panelSaisie = new JPanel();
		panelSaisie.setLayout(new BorderLayout());
		
		panelNom = new JPanel();
		panelNom.setLayout(new BorderLayout());
		
		return panelSaisie;
	}
}