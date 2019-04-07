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
	
	private JLabel labelTitre, labelTitreSec, labelFooter;
	private JPanel panel, panelMenu, panelBody, panelTitre, panelImage, panelFooter;
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
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelMenu.setBackground(new Color(237,237,237));
		
		GridLayout gl = new GridLayout(5,1);
		gl.setVgap(60);
		panelMenu.setLayout(gl);

		/** Creation d'un label blanc pr faire une bordure en haut */
		JLabel labelBlanc = new JLabel("");
		labelBlanc.setSize(10, 10);
		panelMenu.add(labelBlanc);
		
		/** Creation des 3 boutons du menu */
		buttonProfesseur = new JButton("Professeur");
		buttonProfesseur.setForeground(Color.BLACK);
		buttonProfesseur.setBackground(new Color(219,164,164)); 
		buttonProfesseur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonProfesseur.addActionListener(this);
		buttonProfesseur.setFocusPainted(false); 
		panelMenu.add(buttonProfesseur);
		
		buttonEleve = new JButton("Eleve");
		buttonEleve.setForeground(Color.BLACK); 
		buttonEleve.setBackground(new Color(219,164,164));
		buttonEleve.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonEleve.addActionListener(this);
		buttonEleve.setFocusPainted(false);
		panelMenu.add(buttonEleve);
		
		buttonClassement = new JButton("Classements des eleves");
		buttonClassement.setForeground(Color.BLACK); 
		buttonClassement.setBackground(new Color(219,164,164));
		buttonClassement.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		panelBody.setBackground(Color.WHITE);
		
		/** Creation du JPanel qui va contenir les titres du projet */
		panelTitre = new JPanel();
		panelTitre.setLayout(new GridBagLayout());
		panelTitre.setBackground(Color.WHITE);
		
		/** Creation du JLabel pour le titre */
		labelTitre = new JLabel();
		labelTitre.setText("Accueil");
		labelTitre.setFont(new Font("Tahoma", Font.BOLD, 35));


		/** Placement du labelTitre */
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0; 							/**  la grille commence en (0, 0)*/
		gbc.gridwidth = GridBagConstraints.REMAINDER; 		/**  seul composant de sa colonne, il est donc le dernier. */
		gbc.gridheight = 2; 								/**  valeur par défaut - peut s'étendre sur une seule ligne */
		//gbc.anchor = GridBagConstraints.LINE_START; 		/**  ou BASELINE_LEADING mais pas WEST. */
		gbc.insets = new Insets(70, 0, 20, 0); 				/**  Marge à gauche de 15 et marge au dessus de 70. */
		
	
		/** Creation d'un JLabel pour le second titre*/
		labelTitreSec = new JLabel();
		labelTitreSec.setText("Bienvenue dans le gestionnaire de note");
		labelTitreSec.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTitreSec.setForeground(new Color(152,152,152));

		panelTitre.add(labelTitre, gbc);
		panelTitre.add(labelTitreSec);
		
		/** Creation du JPanel pour l'image */
		panelImage = new JPanel();
		panelImage.setLayout(new GridBagLayout());
		panelImage.setBackground(Color.WHITE);
		
		/** Creation de l'image */
		ImageIcon icon = new ImageIcon(new ImageIcon("img.png").getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT));		
		JLabel image = new JLabel(icon, JLabel.CENTER); 
		panelImage.add(image);
		
		/** Creation du JPanel pour le footer */
		panelFooter = new JPanel();
		panelFooter.setLayout(new GridBagLayout());
		panelFooter.setBackground(Color.WHITE);
		
		/** Creation d'un JLabel pour le footer*/
		labelFooter = new JLabel();
		labelFooter.setText("© SERHIR Mohamed - ZARGA Inès");
		labelFooter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelFooter.setForeground(Color.BLACK);
		
		panelFooter.add(labelFooter);
		
	
		panelBody.add(panelTitre, BorderLayout.NORTH);
		panelBody.add(panelImage, BorderLayout.CENTER);
		panelBody.add(panelFooter, BorderLayout.SOUTH);
		panel.add(panelBody, BorderLayout.CENTER); /** au centre */

	
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source = e.getSource();
		if  (source == buttonProfesseur) {
			System.out.println("Professeur..");
			professeur(panel);
			
		}
		else if(source == buttonEleve) {
			System.out.println("Eleve..");
			eleve(panel);
		}
		else if(source == buttonClassement) {
			System.out.println("Classement..");
			classement(panel);
		}
		
	}
	

	
	
	/**
	 * Affichage des panel quand on clique sur professeur
	 * 
	 * @param panel
	 * @return panel
	 */
	public JPanel professeur(JPanel panel) {
		
		
		setContentPane(panel);
		return panel;
	}
	
	/**
	 * Affichage des panel quand on clique sur eleve
	 * 
	 * @param panel
	 * @return
	 */
	public JPanel eleve(JPanel panel) {
		
		
		setContentPane(panel);
		return panel;
	}
	
	
	
	/**
	 * Affichage des panel quand on clique sur classement
	 * 
	 * @param panel
	 * @return
	 */
	public JPanel classement(JPanel panel) {
	
	
		setContentPane(panel);
		return panel;
	}
	
	
	
	
}