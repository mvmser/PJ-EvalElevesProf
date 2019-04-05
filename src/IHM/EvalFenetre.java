package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;




public class EvalFenetre extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitre;
	private JPanel panel, panelMenu, panelBody;
	private JButton buttonProfesseur, buttonEleve, buttonClassement;
	
	
	public EvalFenetre() {
		super();
		build(); //On initialise notre fenetre
	}

	public void build() {
		this.setTitle("Evaluation Eleve / Professeur"); 
		this.setSize(1200,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //regarder c quoi
		this.setResizable(false); 
		
		setContentPane(buildContentPane());
	}


	private JPanel buildContentPane(){
		/**
		 * CREATION DU PANEL TOTAL
		 */
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		/** 
		 * CREATION DU PANEL MENU EN WEST
		 */
		panelMenu = new JPanel();
		///panelMenu.setBounds(0, 0, 800, 1500);
		
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridLayout gl = new GridLayout(5,1);
		gl.setVgap(60);
		panelMenu.setLayout(gl);

		
		/** Creation d'un label blanc pr faire une bordure en haut */
		JLabel labelBlanc = new JLabel("");
		labelBlanc.setSize(10, 10);
		panelMenu.add(labelBlanc);
		
		/** Creation des 3 boutons du menu */
		buttonProfesseur = new JButton("Professeur");
		buttonProfesseur.setForeground(Color.GRAY); //Couleur du texte
		buttonProfesseur.setBackground(Color.BLUE); 
		buttonProfesseur.addActionListener(this);
		//buttonProfesseur.setBorderPainted(false); //on ne veut pas afficher les bordures.
		buttonProfesseur.setFocusPainted(false); 
		panelMenu.add(buttonProfesseur);
		
		buttonEleve = new JButton("Eleve");
		buttonEleve.setForeground(Color.GRAY); //Couleur du texte
		buttonEleve.addActionListener(this);
		buttonEleve.setFocusPainted(false);
		panelMenu.add(buttonEleve);
		
		buttonClassement = new JButton("Classement des eleves");
		buttonClassement.setForeground(Color.GRAY); //Couleur du texte
		buttonClassement.addActionListener(this);
		buttonClassement.setFocusPainted(false);
		panelMenu.add(buttonClassement);
		
		/** Creation d'un label blanc pr faire une bordure en bas */
		JLabel labelBlanc1 = new JLabel("");
		labelBlanc1.setSize(10, 10);
		panelMenu.add(labelBlanc1);
		
		panel.add(panelMenu, BorderLayout.WEST); /** a gauche */
		
		
		
		/** 
		 * CREATION DU PANEL BODY EN EAST
		 */
		panelBody = new JPanel();
		panelBody.setLayout(new BorderLayout());
		
		/** Creation du JLabel pour le titre */
		labelTitre = new JLabel();
		
		labelTitre.setText("<html><body><u>Accueil</u></body></html>");
		Font f = new Font("Lato", Font.PLAIN, 40);
		labelTitre.setFont(f);
		
		labelTitre.setBounds(10,5,10,10);
		labelTitre.setHorizontalAlignment(JLabel.CENTER);
		labelTitre.setVerticalAlignment(JLabel.CENTER);
		
		panelBody.add(labelTitre, BorderLayout.CENTER);
		
	
		panel.add(panelBody, BorderLayout.CENTER); /** au centre */

		
		/** set colors*/
		panelMenu.setBackground(new Color(237,237,237));
		panelBody.setBackground(new Color(255,255,255));
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}