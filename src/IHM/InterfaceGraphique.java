package IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import readCSV.ReadCSV;
import writeCSV.WriteCSV;

import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class InterfaceGraphique extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static Promotion promotion = new Promotion("2021");
	private static List<Eleve> eleves = new ArrayList<>();
	private static List<Professeur> profs = new ArrayList<>();
	
	private JFrame frmEvaluationEleve;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldJour;
	private JTextField textFieldMois;
	private JTextField textFieldAnnee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/** On cree les eleves*/
    	eleves = ReadCSV.readElevesFromCSV();
		profs = ReadCSV.readProfesseursFromCSV();
		
		/** On donne la promotion sur laquelle les profs interviennent */
		for (Professeur prof : profs) {
			prof.addPromotionToProf(promotion);
			//System.out.println(prof.getNom() + " " +prof.getPromotionsOfProf());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraphique frame = new InterfaceGraphique();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGraphique() {
		super();
		build();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void build() {
		//frmEvaluationEleve = new JFrame();
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setResizable(false); 
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("Evaluation Eleve / Professeur");
		this.setBounds(100, 100, 700, 400);
		this.setLocationRelativeTo(null);
		
		//setContentPane(buildContentPane());
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 694, 35);
		panel.add(menuBar);
		
		JMenu mnEdition = new JMenu("Edition");
		mnEdition.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnEdition);
		
		JMenu mnAjout = new JMenu("Ajout");
		mnEdition.add(mnAjout);
		
		JMenuItem mntmEleve = new JMenuItem("Eleve");
		mntmEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel.add(fenetreAjouterEleve());
				}
		});
		mnAjout.add(mntmEleve);
		
		JMenuItem mntmProfesseur = new JMenuItem("Professeur");
		mntmProfesseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel.add(fenetreAjouterProf());
			}
		});
		mnAjout.add(mntmProfesseur);
		
		JSeparator separator = new JSeparator();
		mnEdition.add(separator);
		
		JMenuItem mntmRechercherUnEleve = new JMenuItem("Rechercher un eleve");
		mnEdition.add(mntmRechercherUnEleve);
		
		JMenuItem mntmModifierLesNotes = new JMenuItem("Modifier les notes d'un eleve");
		mnEdition.add(mntmModifierLesNotes);
		
		JMenu mnConsultation = new JMenu("Consultation");
		mnConsultation.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnConsultation);
		
		JMenuItem mntmConsulterSesNotes = new JMenuItem("Consulter ses notes");
		mnConsultation.add(mntmConsulterSesNotes);
		
		JMenuItem mntmVoirLesEleves = new JMenuItem("Voir les eleves");
		mnConsultation.add(mntmVoirLesEleves);
		
		JMenuItem mntmVoirLesProfesseurs = new JMenuItem("Voir les professeurs");
		mnConsultation.add(mntmVoirLesProfesseurs);
		
		JMenuItem mntmVoirLesPromotions = new JMenuItem("Voir les promotions");
		mnConsultation.add(mntmVoirLesPromotions);
		
		JMenu mnClassement = new JMenu("Classement");
		mnClassement.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnClassement);
		
		JMenuItem mntmClassementPromotion = new JMenuItem("Classement promotion");
		mnClassement.add(mntmClassementPromotion);
		
		JMenuItem mntmClassementParMatiere = new JMenuItem("Classement par matiere");
		mnClassement.add(mntmClassementParMatiere);
		
		JMenu mnAPropos = new JMenu("A propos");
		menuBar.add(mnAPropos);
		
		JMenuItem mntmCopyright = new JMenuItem("Copyright");
		mntmCopyright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, 
						  "Cette application est entierement réalisée par"
						+ "\n          SERHIR Mohamed et ZARGA Ines"
						+ "\n Pour le projet de JAVA du S6 à l'EFREI PARIS", "Copyright", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAPropos.add(mntmCopyright);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnAPropos.add(mntmQuitter);	
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(0, 34, 694, 337);
		panel.add(panelCentral);
		panelCentral.setLayout(new CardLayout(0, 0));
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		return panel;
	}
	
	public JPanel fenetreAjouterEleve() {
		JPanel panelEleve = new JPanel();

		panelEleve.setBackground(Color.WHITE);
		panelEleve.setBounds(0, 33, 694, 338);
		panelEleve.setLayout(null);

		JLabel lblAjouterUnEleve = new JLabel("Ajouter un eleve");
		lblAjouterUnEleve.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAjouterUnEleve.setBounds(280, 11, 145, 21);
		panelEleve.add(lblAjouterUnEleve);
		
		JLabel lblNom = new JLabel("Nom: ");
		lblNom.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNom.setBounds(218, 74, 43, 18);
		panelEleve.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom: ");
		lblPrenom.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrenom.setBounds(218, 104, 64, 18);
		panelEleve.add(lblPrenom);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance: ");
		lblDateDeNaissance.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDateDeNaissance.setBounds(218, 133, 145, 18);
		panelEleve.add(lblDateDeNaissance);
		
		JLabel lblPromotion = new JLabel("Promotion: ");
		lblPromotion.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPromotion.setBounds(218, 162, 83, 18);
		panelEleve.add(lblPromotion);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(375, 75, 109, 20);
		panelEleve.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(375, 105, 109, 20);
		panelEleve.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldJour = new JTextField();
		textFieldJour.setColumns(10);
		textFieldJour.setBounds(375, 134, 23, 20);
		panelEleve.add(textFieldJour);
		
		textFieldMois = new JTextField();
		textFieldMois.setColumns(10);
		textFieldMois.setBounds(408, 134, 23, 20);
		panelEleve.add(textFieldMois);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setColumns(10);
		textFieldAnnee.setBounds(441, 134, 43, 20);
		panelEleve.add(textFieldAnnee);
		
		Choice choice = new Choice();
		choice.setBounds(375, 160, 109, 20);
		for (Promotion promotion : Promotion.getPromotions()) {
			choice.add(promotion.getNom());
		}
		panelEleve.add(choice);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldNom.getText();
				String prenom = textFieldPrenom.getText();
				int jour = 0;
				int mois = 0;
				int annee = 0;
				
				try {
					jour = Integer.parseInt(textFieldJour.getText());
					mois = Integer.parseInt(textFieldMois.getText());
					annee = Integer.parseInt(textFieldAnnee.getText());
				}catch (NumberFormatException nfe) {
		            JOptionPane.showMessageDialog(null,"Merci d'entrer une date de naissance valide", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
				
				Promotion promotionEleve = null;
				for (Promotion promotion : Promotion.getPromotions()) {
					if(promotion.getNom() == choice.getSelectedItem())
						promotionEleve = promotion;
				}
				
				if(nom.length() > 0  && prenom.length() > 0 && promotionEleve != null && jour != 0 && mois != 0 && annee != 0) {
					Eleve eleve = new Eleve(nom, prenom, jour, mois, annee);
					/** Une fois crée, on l'ajoute dans le fichier mais aussi dans le tableau eleves*/
					eleves.add(eleve);
					WriteCSV.writeEleveToCSV(eleve);
					System.out.println(eleves);
					System.out.println(nom);
					System.out.println(prenom);
					System.out.println(eleve.getDateNaissance());
					System.out.println(promotion);
				}else {
		            JOptionPane.showMessageDialog(null,"Merci de remplir correctement tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		btnAjouter.setBounds(309, 210, 89, 23);
		panelEleve.add(btnAjouter);
		
		return panelEleve;
	}
	
	public JPanel fenetreAjouterProf() {
		JPanel panelProf = new JPanel();

		panelProf.setBackground(Color.WHITE);
		panelProf.setBounds(0, 33, 694, 338);
		panelProf.setLayout(null);

		JLabel lblAjouterUnEleve = new JLabel("Ajouter un professeur");
		lblAjouterUnEleve.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAjouterUnEleve.setBounds(280, 11, 145, 21);
		panelProf.add(lblAjouterUnEleve);
		
		JLabel lblNom = new JLabel("Nom: ");
		lblNom.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNom.setBounds(218, 74, 43, 18);
		panelProf.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom: ");
		lblPrenom.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrenom.setBounds(218, 104, 64, 18);
		panelProf.add(lblPrenom);
		
		JLabel lblPromotion = new JLabel("Promotion: ");
		lblPromotion.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPromotion.setBounds(218, 162, 83, 18);
		panelProf.add(lblPromotion);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(375, 75, 109, 20);
		panelProf.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(375, 105, 109, 20);
		panelProf.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(375, 160, 109, 20);
		for (Promotion promotion : Promotion.getPromotions()) {
			choice.add(promotion.getNom());
		}
		panelProf.add(choice);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldNom.getText();
				String prenom = textFieldPrenom.getText();
				
				Promotion promotionProf = null;
				for (Promotion promotion : Promotion.getPromotions()) {
					if(promotion.getNom() == choice.getSelectedItem())
						promotionProf = promotion;
				}
				
				if(nom.length() > 0  && prenom.length() > 0 && promotionProf != null) {
					Professeur professeur = new Professeur(nom, prenom);
					/** Une fois crée, on l'ajoute dans le fichier mais aussi dans le tableau profs*/
					profs.add(professeur);
					WriteCSV.writeProfToCSV(professeur);
					System.out.println(nom);
					System.out.println(prenom);
					System.out.println(promotion);
				}else {
		            JOptionPane.showMessageDialog(null,"Merci de remplir correctement tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		btnAjouter.setBounds(309, 210, 89, 23);
		panelProf.add(btnAjouter);
		
		return panelProf;
	}
}
