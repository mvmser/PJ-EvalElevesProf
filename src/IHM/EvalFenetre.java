package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;




public class EvalFenetre extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitre, labelTitreSec, labelFooter;
	private JPanel panel, panelMenu, panelBody, panelTitre, panelImage, panelFooter;
	private JPanel panelBodyCard, panelProfesseur, panelEleve, panelClassement;
	private JPanel panelAnwser, panelR;
	private JButton buttonProfesseur, buttonEleve, buttonClassement, buttonRetour;
	private JButton buttonRecherche, buttonModifierNote, buttonAjoutEvaluation;
	private JButton buttonConsulterNote, buttonMoyenne, buttonMediane;
	private JButton buttonClassementMoyenne, buttonClassementMediane, buttonCourbeMatiere;
	
	
	
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
		CardLayout cardLayout = new CardLayout(); 
		panelBodyCard = new JPanel(cardLayout); /** Panel qui va contenir TOUS les Panel de chaque boutons */

		/** Panel qui va contenir la 1er page */
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
			labelFooter.setText("© SERHIR Mohamed - ZARGA Ines");
			labelFooter.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelFooter.setForeground(Color.BLACK);
		
		panelFooter.add(labelFooter);
		
		panelBody.add(panelTitre, BorderLayout.NORTH);
		panelBody.add(panelImage, BorderLayout.CENTER);
		panelBody.add(panelFooter, BorderLayout.SOUTH);
		panelBodyCard.add(panelBody, "FistPage");
		panel.add(panelBodyCard, BorderLayout.CENTER); /** au centre */

	
		
		return panel;
	}

	

	
	
	/**
	 * Affichage des panel quand on clique sur professeur
	 * 
	 * @param panel
	 * @return panel
	 */
	public JPanel professeur(JPanel panel) {
		/** Panel qui va contenir la page professeur */
		panelProfesseur = new JPanel();
			panelProfesseur.setLayout(new BorderLayout());
			panelProfesseur.setBackground(Color.WHITE);
		
		/** Panel du haut */
		JPanel panelHaut = new JPanel(new BorderLayout());
			panelHaut.setBackground(Color.WHITE);
			
		/** Panel des 2 titre */
		JPanel panel1P = new JPanel();
			panel1P.setLayout(new GridBagLayout());
			panel1P.setBackground(Color.WHITE);
		
		buttonRetour = new JButton("Retour");
			buttonRetour.setFocusPainted(false);
			buttonRetour.addActionListener(this);
			
		JLabel labelTitreProf = new JLabel();
			labelTitreProf.setText("Professeur");
			labelTitreProf.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		/** Placement du labelTitreProf */
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0; 							
			gbc.gridheight = 2; 								
			gbc.insets = new Insets(60, 0, 20, 0); 				
		
		panel1P.add(buttonRetour);
		panel1P.add(labelTitreProf, gbc);	
		panelHaut.add(panel1P, BorderLayout.NORTH);
		
		/** Panel du milieu pour les differents choix*/
		JPanel panelChooseP = new JPanel(new FlowLayout());
			panelChooseP.setBackground(Color.WHITE);
			
		buttonRecherche = new JButton("Rechercher un eleve");
			buttonRecherche.setBackground(Color.WHITE);
			buttonRecherche.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonRecherche.addActionListener(this);
			buttonRecherche.setFocusPainted(false);
			buttonRecherche.setPreferredSize(new Dimension(170, 60));
			
		buttonModifierNote = new JButton("Modification d'une note");
			buttonModifierNote.setBackground(Color.WHITE);
			buttonModifierNote.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonModifierNote.addActionListener(this);
			buttonModifierNote.setFocusPainted(false);
			buttonModifierNote.setPreferredSize(new Dimension(170, 60));
		buttonAjoutEvaluation = new JButton("Ajout d'une evalution");
			buttonAjoutEvaluation.setBackground(Color.WHITE);
			buttonAjoutEvaluation.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonAjoutEvaluation.addActionListener(this);
			buttonAjoutEvaluation.setFocusPainted(false);
			buttonAjoutEvaluation.setPreferredSize(new Dimension(170, 60));
			
		panelChooseP.add(buttonRecherche);
		panelChooseP.add(buttonModifierNote);
		panelChooseP.add(buttonAjoutEvaluation);
		panelHaut.add(panelChooseP, BorderLayout.CENTER);
		panelProfesseur.add(panelHaut, BorderLayout.NORTH);
		
		/** Panel du Milieu */
		panelAnwser = new JPanel(new BorderLayout());
			panelAnwser.setBackground(Color.WHITE);
	
			
		panelProfesseur.add(panelAnwser, BorderLayout.CENTER);
		
		panelBodyCard.add(panelProfesseur, "ProfesseurPage");
		panel.add(panelBodyCard, BorderLayout.CENTER); /** au centre */
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
		/** Panel qui va contenir la page eleve */
		panelEleve = new JPanel();
			panelEleve.setLayout(new BorderLayout());
			panelEleve.setBackground(Color.WHITE);
		
		/** Panel du haut */
		JPanel panelHaut = new JPanel(new BorderLayout());
			panelHaut.setBackground(Color.WHITE);
			
		/** Panel des 2 titre */
		JPanel panel1E = new JPanel();
			panel1E.setLayout(new GridBagLayout());
			panel1E.setBackground(Color.WHITE);
		
		buttonRetour = new JButton("Retour");
			buttonRetour.setFocusPainted(false);
			buttonRetour.addActionListener(this);
			
		JLabel labelTitreEleve = new JLabel();
			labelTitreEleve.setText("Eleve");
			labelTitreEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		/** Placement du labelTitreEleve */
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0; 							
			gbc.gridheight = 2; 								
			gbc.insets = new Insets(60, 0, 20, 0); 				
		
		panel1E.add(buttonRetour);
		panel1E.add(labelTitreEleve, gbc);	
		panelHaut.add(panel1E, BorderLayout.NORTH);
		
		/** Panel du milieu pour les differents choix*/
		JPanel panelChooseE = new JPanel(new FlowLayout());
			panelChooseE.setBackground(Color.WHITE);
		
		buttonConsulterNote = new JButton("Consultation de notes");
			buttonConsulterNote.setBackground(Color.WHITE);
			buttonConsulterNote.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonConsulterNote.addActionListener(this);
			buttonConsulterNote.setFocusPainted(false);
			buttonConsulterNote.setPreferredSize(new Dimension(170, 60));
		buttonMoyenne = new JButton("Mes moyennes");
			buttonMoyenne.setBackground(Color.WHITE);
			buttonMoyenne.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonMoyenne.addActionListener(this);
			buttonMoyenne.setFocusPainted(false);
			buttonMoyenne.setPreferredSize(new Dimension(170, 60));
		buttonMediane = new JButton("Mes medianes");
			buttonMediane.setBackground(Color.WHITE);
			buttonMediane.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonMediane.addActionListener(this);
			buttonMediane.setFocusPainted(false);
			buttonMediane.setPreferredSize(new Dimension(170, 60));
			
		panelChooseE.add(buttonConsulterNote);
		panelChooseE.add(buttonMoyenne);
		panelChooseE.add(buttonMediane);
		panelHaut.add(panelChooseE, BorderLayout.CENTER);
		
		panelEleve.add(panelHaut, BorderLayout.NORTH);
		panelBodyCard.add(panelEleve, "ElevePage");
		panel.add(panelBodyCard, BorderLayout.CENTER); /** au centre */
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
		/** Panel qui va contenir la page classe */
		panelClassement = new JPanel();
			panelClassement.setLayout(new BorderLayout());
			panelClassement.setBackground(Color.WHITE);
		
		/** Panel du haut */
		JPanel panelHaut = new JPanel(new BorderLayout());
			panelHaut.setBackground(Color.WHITE);
			
		/** Panel des 2 titre */
		JPanel panel1C = new JPanel();
			panel1C.setLayout(new GridBagLayout());
			panel1C.setBackground(Color.WHITE);
		
		buttonRetour = new JButton("Retour");
			buttonRetour.setFocusPainted(false);
			buttonRetour.addActionListener(this);
			
		JLabel labelTitreClassement = new JLabel();
			labelTitreClassement.setText("Classements des eleves");
			labelTitreClassement.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		/** Placement du labelTitreClassement */
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0; 							
			gbc.gridheight = 2; 								
			gbc.insets = new Insets(60, 0, 20, 0); 				
		
		panel1C.add(buttonRetour);
		panel1C.add(labelTitreClassement, gbc);	
		panelHaut.add(panel1C, BorderLayout.NORTH);
		
		/** Panel du milieu pour les differents choix*/
		JPanel panelChooseC = new JPanel(new FlowLayout());
			panelChooseC.setBackground(Color.WHITE);
		
		buttonClassementMoyenne = new JButton("Classements par moyenne");
			buttonClassementMoyenne.setBackground(Color.WHITE);
			buttonClassementMoyenne.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonClassementMoyenne.addActionListener(this);
			buttonClassementMoyenne.setFocusPainted(false);
			buttonClassementMoyenne.setPreferredSize(new Dimension(190, 60));
		buttonClassementMediane = new JButton("Classements par mediane");
			buttonClassementMediane.setBackground(Color.WHITE);
			buttonClassementMediane.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonClassementMediane.addActionListener(this);
			buttonClassementMediane.setFocusPainted(false);
			buttonClassementMediane.setPreferredSize(new Dimension(190, 60));
		buttonCourbeMatiere = new JButton("Courbes par matiere");
			buttonCourbeMatiere.setBackground(Color.WHITE);
			buttonCourbeMatiere.setFont(new Font("Tahoma", Font.PLAIN, 15));
			buttonCourbeMatiere.addActionListener(this);
			buttonCourbeMatiere.setFocusPainted(false);
			buttonCourbeMatiere.setPreferredSize(new Dimension(190, 60));
			
		panelChooseC.add(buttonClassementMoyenne);
		panelChooseC.add(buttonClassementMediane);
		panelChooseC.add(buttonCourbeMatiere);
		panelHaut.add(panelChooseC, BorderLayout.CENTER);
		
		panelClassement.add(panelHaut, BorderLayout.NORTH);
		panelBodyCard.add(panelClassement, "ClassementPage");
		panel.add(panelBodyCard, BorderLayout.CENTER); /** au centre */
		setContentPane(panel);
		return panel;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source = e.getSource();
		
		if  (source == buttonProfesseur) {
			System.out.println("Professeur..");
			professeur(panel);
			
			CardLayout cl = (CardLayout)(panelBodyCard.getLayout()); 
		    cl.show(panelBodyCard, "ProfesseurPage");	
		}
		else if(source == buttonEleve) {
			System.out.println("Eleve..");
			eleve(panel);
			CardLayout cl = (CardLayout)(panelBodyCard.getLayout()); 
		    cl.show(panelBodyCard, "ElevePage");
		}
		else if(source == buttonClassement) {
			System.out.println("Classement..");
			classement(panel);
			CardLayout cl = (CardLayout)(panelBodyCard.getLayout());
		    cl.show(panelBodyCard, "ClassementPage");
		}

		else if(source == buttonRetour) {
			System.out.println("Retour à la page d'accueil..");
			CardLayout cl = (CardLayout)(panelBodyCard.getLayout()); //implimented the change respectivly
		    cl.show(panelBodyCard, "FistPage");
		}
		else if(source == buttonRecherche) {
			System.out.println("Un professeur veut rechercher un eleve");
			
			panelR = new JPanel(new GridBagLayout());
			panelR.setBackground(Color.WHITE);
			JLabel laberEnter= new JLabel("Entrer le numero d'identification de l'eleve : ");
				laberEnter.setFont(new Font("Tahoma", Font.PLAIN, 20));
			JTextField Choice = new JTextField(30);
				Choice.setEditable(true);
			JButton valider = new JButton("Valider");
				valider.setFocusPainted(false);
				valider.setPreferredSize(new Dimension(100, 60));
				valider.setBackground(new Color(1,127,48));
				valider.addActionListener(this);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.insets = new Insets(30, 0, 0, 0); 
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			panelR.add(laberEnter, gbc);
			
			gbc.gridx = 0;
		    gbc.gridy = 1;
		    panelR.add(Choice, gbc);
		    
		    gbc.gridx = 1;
		    gbc.gridy = 2;
		    panelR.add(valider, gbc);

			panelAnwser.add(panelR, BorderLayout.NORTH);
			professeur(panel);	
		}
		else if(source == buttonModifierNote) {
			System.out.println("Un professeur veut rechercher un eleve");
			
			panelR = new JPanel(new GridBagLayout());
			panelR.setBackground(Color.WHITE);
			JLabel laberEnter= new JLabel("Entrer le numero d'identification de l'eleve : ");
				laberEnter.setFont(new Font("Tahoma", Font.PLAIN, 20));
			JTextField Choice = new JTextField("Enter un nom", 100);
				Choice.setEditable(true);
				Choice.setPreferredSize( new Dimension(200, 24) );
			JButton Valider = new JButton("Valider");
				Valider.addActionListener(this);
				Valider.setFocusPainted(false);
				Valider.setPreferredSize(new Dimension(190, 60));
				
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0; 							
			gbc.gridheight = 10;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.insets = new Insets(30, 1, 20, 1); 
			
			panelR.add(laberEnter, gbc);
			panelR.add(Choice);
			panelR.add(Valider);
			panelAnwser.add(panelR, BorderLayout.NORTH);
			
			professeur(panel);	
		}
		
	}
	
	
	
	
	
}