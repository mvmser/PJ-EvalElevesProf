package IHM;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
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
import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import readCSV.ReadCSV;
import writeCSV.WriteCSV;
import javax.swing.JTextArea;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JProgressBar;

public class InterfaceGraphique extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static Promotion promotion = new Promotion("2021");
	private static List<Eleve> eleves = new ArrayList<>();
	private static List<Professeur> profs = new ArrayList<>();
	
	private JPanel cardsPanelCentral;
	
	final static String ACCUEIL = "ACCUEIL";
	final static String AJOUTER_ELEVE = "AJOUTER_ELEVE";
	final static String AJOUTER_PROF = "AJOUTER_PROF"; 
	final static String RECHERCHER_ELEVE = "RECHERCHER_ELEVE"; 
	final static String MODIFIER_NOTES = "MODIFIER_NOTES"; 
	final static String CONSULTER_NOTES = "CONSULTER_NOTES"; 
	final static String VOIR_ELEVES = "VOIR_ELEVES"; 
	final static String VOIR_PROFS = "VOIR_PROFS"; 
	final static String VOIR_PROMOTIONS = "VOIR_PROMOTIONS"; 
	final static String CLASSEMENT_PROMO = "CLASSEMENT_PROMO"; 
	final static String CLASSEMENT_MATIERE = "CLASSEMENT_MATIERE"; 
	final static String AJOUTER_PROMOTION = "AJOUTER_PROMOTION";
	
	DefaultTableModel tableModel;
	static JProgressBar progressBar = new JProgressBar();

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
		/** On rempli les notes des eleves*/
		promotion.remplirEvalEleves();
		
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
	 * Permet de creer l'application graphique
	 */
	public InterfaceGraphique() {
		super();
		build();
	}

	/**
	 * Permet de construire notre fenetre
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
		
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		
		/** Le MENU */
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 694, 35);
		panel.add(menuBar);
		
		JMenu menuEdition = new JMenu("Edition");
		menuEdition.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menuEdition);
		
		JMenu menuAjout = new JMenu("Ajout");
		menuEdition.add(menuAjout);
		
		JMenuItem menuItemEleve = new JMenuItem("Eleve");
		menuItemEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, AJOUTER_ELEVE);
				}
		});
		menuAjout.add(menuItemEleve);
		
		JMenuItem menuItemProfesseur = new JMenuItem("Professeur");
		menuItemProfesseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, AJOUTER_PROF);
			}
		});
		menuAjout.add(menuItemProfesseur);
		
		JMenuItem menuItemPromotion = new JMenuItem("Promotion");
		menuItemPromotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, AJOUTER_PROMOTION);
			}
		});
		menuAjout.add(menuItemPromotion);
		
		JSeparator separator = new JSeparator();
		menuEdition.add(separator);
		
		JMenuItem mntmRechercherUnEleve = new JMenuItem("Rechercher un eleve");
		mntmRechercherUnEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, RECHERCHER_ELEVE);
			}
		});
		menuEdition.add(mntmRechercherUnEleve);
		
		JMenuItem mntmModifierLesNotes = new JMenuItem("Modifier les notes d'un eleve");
		mntmModifierLesNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, MODIFIER_NOTES);
			}
		});
		menuEdition.add(mntmModifierLesNotes);
		
		JMenu mnConsultation = new JMenu("Consultation");
		mnConsultation.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnConsultation);
		
		JMenuItem mntmConsulterSesNotes = new JMenuItem("Consulter ses notes");
		mntmConsulterSesNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, CONSULTER_NOTES);
			}
		});
		mnConsultation.add(mntmConsulterSesNotes);
		
		JMenuItem mntmVoirLesEleves = new JMenuItem("Voir les eleves");
		mntmVoirLesEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, VOIR_ELEVES);
			}
		});
		mnConsultation.add(mntmVoirLesEleves);
		
		JMenuItem mntmVoirLesProfesseurs = new JMenuItem("Voir les professeurs");
		mntmVoirLesProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, VOIR_PROFS);
			}
		});
		mnConsultation.add(mntmVoirLesProfesseurs);
		
		JMenuItem mntmVoirLesPromotions = new JMenuItem("Voir les promotions");
		mntmVoirLesPromotions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, VOIR_PROMOTIONS);
			}
		});
		mnConsultation.add(mntmVoirLesPromotions);
		
		JMenu mnClassement = new JMenu("Classement");
		mnClassement.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnClassement);
		
		JMenuItem mntmClassementPromotion = new JMenuItem("Classement promotion");
		mntmClassementPromotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, CLASSEMENT_PROMO);
			}
		});
		mnClassement.add(mntmClassementPromotion);
		
		JMenuItem mntmClassementParMatiere = new JMenuItem("Classement par matiere");
		mntmClassementParMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, CLASSEMENT_MATIERE);
			}
		});
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
		
		JMenuItem mntmAccueil = new JMenuItem("Accueil");
		mntmAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardsPanelCentral.getLayout()).show(cardsPanelCentral, ACCUEIL);
			}
		});
		mnAPropos.add(mntmAccueil);
		mnAPropos.add(mntmCopyright);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnAPropos.add(mntmQuitter);	
		
		/** FIN MENU */
		
		/** Panel qui va contenir nos card*/
		cardsPanelCentral = new JPanel(new CardLayout());
		cardsPanelCentral.setBounds(0, 34, 694, 337);
		panel.add(cardsPanelCentral);
		
		/** On cree nos cards */
		JPanel cardAccueil = fenetreAccueil();
		JPanel cardEleve = fenetreAjouterEleve();
		JPanel cardProf = fenetreAjouterProf();
		JPanel cardPromotion = fenetreAjouterPromotion();
		JPanel cardRechercherEleve = fenetreRechercherEleve();
		JPanel cardModifierNotes = fenetreModifierNotes();
		JPanel cardConsulterNotes = fenetreConsulterNotes();
		JPanel cardVoirEleves = fenetreVoirEleves();
		JPanel cardVoirProfs = fenetreVoirProfs();
		JPanel cardVoirPromotions = fenetreVoirPromotions();
		JPanel cardClassementPromo = fenetreClassementPromo();

		/** Et on les ajoutes*/
		cardsPanelCentral.add(cardAccueil, ACCUEIL);		
		cardsPanelCentral.add(cardEleve, AJOUTER_ELEVE);		
		cardsPanelCentral.add(cardProf, AJOUTER_PROF);	
		cardsPanelCentral.add(cardPromotion, AJOUTER_PROMOTION);
		cardsPanelCentral.add(cardRechercherEleve, RECHERCHER_ELEVE);
		cardsPanelCentral.add(cardModifierNotes, MODIFIER_NOTES);
		cardsPanelCentral.add(cardConsulterNotes, CONSULTER_NOTES);
		cardsPanelCentral.add(cardVoirEleves, VOIR_ELEVES);
		cardsPanelCentral.add(cardVoirProfs, VOIR_PROFS);
		cardsPanelCentral.add(cardVoirPromotions, VOIR_PROMOTIONS);
		cardsPanelCentral.add(cardClassementPromo, CLASSEMENT_PROMO);
		
		return panel;
	}

	private JPanel fenetreAccueil() {
		JPanel panelAccueil = new JPanel();
		
		panelAccueil.setBackground(Color.WHITE);
		panelAccueil.setBounds(0, 33, 694, 338);
		panelAccueil.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 323, 694, 14);
		panelAccueil.add(progressBar);
		
		progressBar.setValue(100); 
		progressBar.setStringPainted(true);
						
		JLabel lblEvaluationEleve = new JLabel("Evaluation Eleve / Professeur");
		lblEvaluationEleve.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEvaluationEleve.setBounds(244, 11, 231, 18);
		panelAccueil.add(lblEvaluationEleve);
		
		JLabel lblRr = new JLabel("<html><p style=\"text-align: center;\">Bienvenue sur le projet evaluation eleves et professeurs.</p>\r\n" + 
				"<p style=\"text-align: center;\">Le menu ci-dessus, vous donne acc&egrave;s &agrave; de nombreuses fonctionnalit&eacute;s!</p></html>");
		lblRr.setBounds(185, 55, 359, 151);
		panelAccueil.add(lblRr);
		
		
		return panelAccueil;
	}

	public JPanel fenetreAjouterEleve() {
		JPanel panelEleve = new JPanel();
		JTextField textFieldNom, textFieldPrenom, textFieldJour, textFieldMois, textFieldAnnee;
		
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
		            JOptionPane.showMessageDialog(null,"L'eleve a bien ete ajoutee", "Ajout", JOptionPane.INFORMATION_MESSAGE);	

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
		JTextField textFieldNom, textFieldPrenom;
		
		panelProf.setBackground(Color.WHITE);
		panelProf.setBounds(0, 33, 694, 338);
		panelProf.setLayout(null);

		JLabel lblAjouterUnEleve = new JLabel("Ajouter un professeur");
		lblAjouterUnEleve.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAjouterUnEleve.setBounds(280, 11, 200, 21);
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
		            JOptionPane.showMessageDialog(null,"Le prof a bien ete ajoutee", "Ajout", JOptionPane.INFORMATION_MESSAGE);	

				}else {
		            JOptionPane.showMessageDialog(null,"Merci de remplir correctement tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		btnAjouter.setBounds(309, 210, 89, 23);
		panelProf.add(btnAjouter);
		
		return panelProf;
	}

	public JPanel fenetreAjouterPromotion() {
		JPanel panelProf = new JPanel();
		JTextField textFieldNom;
		
		panelProf.setBackground(Color.WHITE);
		panelProf.setBounds(0, 33, 694, 338);
		panelProf.setLayout(null);

		JLabel lblAjouterPromotion = new JLabel("Ajouter une promotion");
		lblAjouterPromotion.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAjouterPromotion.setBounds(280, 11, 200, 21);
		panelProf.add(lblAjouterPromotion);
		
		JLabel lblNom = new JLabel("Nom: ");
		lblNom.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNom.setBounds(218, 74, 43, 18);
		panelProf.add(lblNom);
				
		textFieldNom = new JTextField();
		textFieldNom.setBounds(375, 75, 109, 20);
		panelProf.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textFieldNom.getText();
								
				if(nom.length() > 3) {
					new Promotion(nom);
		            JOptionPane.showMessageDialog(null,"La promotion a bien ete ajoutee", "Ajout", JOptionPane.INFORMATION_MESSAGE);	
				}else {
		            JOptionPane.showMessageDialog(null,"Merci de remplir correctement le nom de la promotion", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		btnAjouter.setBounds(309, 210, 89, 23);
		panelProf.add(btnAjouter);
		
		return panelProf;
	}

	public JPanel fenetreRechercherEleve() {
		JPanel panelRecherche = new JPanel();
		JTextField textFieldID;

		panelRecherche.setBackground(Color.WHITE);
		panelRecherche.setBounds(0, 33, 694, 338);
		panelRecherche.setLayout(null);

		JLabel lblAjouterUnEleve = new JLabel("Rechercher un eleve");
		lblAjouterUnEleve.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAjouterUnEleve.setBounds(261, 11, 200, 21);
		panelRecherche.add(lblAjouterUnEleve);
		
		JLabel lblNom = new JLabel("Identifiant: ");
		lblNom.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNom.setBounds(218, 103, 150, 18);
		panelRecherche.add(lblNom);
		
		JLabel lblPromotion = new JLabel("Qui êtes vous: ");
		lblPromotion.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPromotion.setBounds(192, 66, 109, 18);
		panelRecherche.add(lblPromotion);
		
		Choice choixProfesseur = new Choice();
		choixProfesseur.setBounds(375, 66, 109, 20);
		for (Professeur prof : profs) {
			choixProfesseur.add(prof.getNom());
		}
		panelRecherche.add(choixProfesseur);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(375, 104, 109, 20);
		textFieldID.setColumns(10);
		panelRecherche.add(textFieldID);
		
		JTextArea zoneAffichage = new JTextArea("");
		JScrollPane scrollPane = new JScrollPane(zoneAffichage);
		scrollPane.setBounds(10, 176, 674, 150);
		panelRecherche.add(scrollPane);
		
		JButton btnAjouter = new JButton("Rechercher");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRecherche = 0;
				boolean error = false;
				
				try {
					idRecherche = Integer.parseInt(textFieldID.getText());
				}catch (NumberFormatException nfe) {
					error = true;
		            JOptionPane.showMessageDialog(null,"Merci d'entrer un ID valide", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
				
				Professeur professeurSelected = null;
				for (Professeur professeur : profs) {
					if(professeur.getNom() == choixProfesseur.getSelectedItem())
						professeurSelected = professeur;
				}
				
				if(!error) {
					if(professeurSelected != null && idRecherche != 0) {
						Eleve eleveRecherche = professeurSelected.rechercheEleve(idRecherche);
						if(eleveRecherche != null) {
							zoneAffichage.setText(eleveRecherche.toString());
						}else {
							JOptionPane.showMessageDialog(null,"Eleve inexistant!", "Erreur", JOptionPane.ERROR_MESSAGE);	
						}
					}else {
			            JOptionPane.showMessageDialog(null,"Merci de remplir correctement tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		btnAjouter.setBounds(293, 142, 133, 23);
		panelRecherche.add(btnAjouter);
		
		return panelRecherche;
	}

	public JPanel fenetreModifierNotes() {
		JPanel panelModiferNotes = new JPanel();

		return panelModiferNotes;
	}

	private JPanel fenetreConsulterNotes() {
		JPanel panelConsulterNotes = new JPanel();

		panelConsulterNotes.setBackground(Color.WHITE);
		panelConsulterNotes.setBounds(0, 33, 694, 338);
		panelConsulterNotes.setLayout(null);

		JLabel labelTitre = new JLabel("Consulter vos notes");
		labelTitre.setFont(new Font("Verdana", Font.BOLD, 16));
		labelTitre.setBounds(261, 11, 200, 21);
		panelConsulterNotes.add(labelTitre);

		JLabel labelEleve = new JLabel("Nom: ");
		labelEleve.setFont(new Font("Verdana", Font.PLAIN, 14));
		labelEleve.setBounds(249, 38, 50, 18);
		panelConsulterNotes.add(labelEleve);
		
		Choice choixEleve = new Choice();
		choixEleve.setBounds(315, 36, 176, 20);
		for (Eleve eleve : eleves) {
			choixEleve.add(eleve.getNom() + " " + eleve.getPrenom());
		}
		panelConsulterNotes.add(choixEleve);
		
		/** */
		ArrayList<String> matieres = new ArrayList<String>();
		ArrayList<String> notes = new ArrayList<String>();
		
		JLabel lblMoyenneGenerale = new JLabel();
		lblMoyenneGenerale.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMoyenneGenerale.setBounds(261, 183, 223, 16);
		panelConsulterNotes.add(lblMoyenneGenerale);
		lblMoyenneGenerale.setVisible(false);
		
		JLabel lblMedianeGenerale = new JLabel();
		lblMedianeGenerale.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMedianeGenerale.setBounds(261, 210, 223, 16);
		panelConsulterNotes.add(lblMedianeGenerale);
		lblMedianeGenerale.setVisible(false);
		
		JButton btnRechercher = new JButton("Consulter");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleve eleveSelected = null;
				
				DefaultTableModel modelEleve = new DefaultTableModel();
				JTable eleveTableau = new JTable(tableModel);
				eleveTableau.setModel(modelEleve);
				eleveTableau.setBounds(20, 100, 660, 40);

				JScrollPane scrollPane = new JScrollPane(eleveTableau);
				scrollPane.setBounds(20, 100, 660, 40);
				panelConsulterNotes.add(scrollPane);
								
				for (Eleve eleve : eleves) {
					if( (eleve.getNom() + " " + eleve.getPrenom()).compareTo(choixEleve.getSelectedItem()) == 0 ) {
						eleveSelected = eleve;
						
						/** On enregistre*/
						for (Evaluation evaluation : eleveSelected.getEvaluations()) {
							matieres.add(evaluation.getMatiere());
							notes.add(Double.toString(evaluation.getNote()) );
						}
						
						modelEleve.setColumnIdentifiers(matieres.toArray());
						modelEleve.addRow(notes.toArray());	
						
						lblMoyenneGenerale.setText("Moyenne generale: " + eleve.moyenne());
						lblMedianeGenerale.setText("Mediane generale: " + eleve.mediane());
						lblMoyenneGenerale.setVisible(true);
						lblMedianeGenerale.setVisible(true);
						
						notes.clear();
						matieres.clear();
					}
				}
				
				System.out.println(eleveSelected);
				
			}
		});
		
		btnRechercher.setBounds(281, 67, 133, 23);
		panelConsulterNotes.add(btnRechercher);		
		
		return panelConsulterNotes;
	}

	private JPanel fenetreVoirEleves() {
		JPanel panelVoirEleves = new JPanel();
		
		panelVoirEleves.setBackground(Color.WHITE);
		panelVoirEleves.setBounds(0, 33, 694, 338);
		panelVoirEleves.setLayout(null);
		
		JLabel lblTitre = new JLabel("Liste des eleves");
		lblTitre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTitre.setBounds(293, 11, 121, 18);
		panelVoirEleves.add(lblTitre);
		
		String header[] = {"ID", "Nom","Prenom","Date de Naissance", "Promo"};
		
		DefaultTableModel modelEleve = new DefaultTableModel();
		modelEleve.setColumnIdentifiers(header);
		JTable eleveTableau = new JTable(tableModel);
		eleveTableau.setAutoCreateRowSorter(true);
		eleveTableau.setModel(modelEleve);
		eleveTableau.setBounds(21, 36, 647, 291);

		JScrollPane scrollPane = new JScrollPane(eleveTableau);
		scrollPane.setBounds(21, 36, 647, 291);
		panelVoirEleves.add(scrollPane);
		
		JButton button = new JButton("Actualiser");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** On supprime toutes les lignes pour ajouter les anciennes et les nouvelles (actualiser)*/
				int n = modelEleve.getRowCount();
				for (int i=n-1 ; i>=0 ; --i) modelEleve.removeRow(i);

				for (Eleve eleve : eleves) {
					String[] data = {Integer.toString(eleve.getNumIdentifiant()), eleve.getNom(), 
							eleve.getPrenom(), eleve.getDateNaissance().toString(), eleve.getPromotion().getNom()};
					modelEleve.addRow(data);
				}
			}
		});
		button.setBounds(21, 6, 100, 23);
		panelVoirEleves.add(button);
		
		/** On insert les eleves*/
		for (Eleve eleve : eleves) {
			String[] data = {Integer.toString(eleve.getNumIdentifiant()), eleve.getNom(), 
					eleve.getPrenom(), eleve.getDateNaissance().toString(), eleve.getPromotion().getNom()};
			modelEleve.addRow(data);
		}
		
		return panelVoirEleves;
	}

	private JPanel fenetreVoirProfs() {
		JPanel panelVoirProf = new JPanel();

		panelVoirProf.setBackground(Color.WHITE);
		panelVoirProf.setBounds(0, 33, 694, 338);
		panelVoirProf.setLayout(null);
		
		JLabel lblTitre = new JLabel("Liste des professeurs");
		lblTitre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTitre.setBounds(262, 11, 193, 18);
		panelVoirProf.add(lblTitre);
		
		String header[] = {"Nom","Prenom"};
				
		DefaultTableModel modelProf = new DefaultTableModel();
		modelProf.setColumnIdentifiers(header);
		JTable profTableau = new JTable(modelProf);
		profTableau.setAutoCreateRowSorter(true);

		profTableau.setModel(modelProf);
		profTableau.setBounds(21, 36, 647, 291);

		JScrollPane scrollPane = new JScrollPane(profTableau);
		scrollPane.setBounds(21, 36, 647, 291);
		panelVoirProf.add(scrollPane);
		
		JButton button = new JButton("Actualiser");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = modelProf.getRowCount();
				for (int i=n-1 ; i>=0 ; --i) modelProf.removeRow(i);

				for (Professeur prof : profs) {
					String[] data = {prof.getNom(), prof.getPrenom()};
					modelProf.addRow(data);
				}
			}
		});
		button.setBounds(21, 6, 100, 23);
		panelVoirProf.add(button);
		
		/** On insert les eleves*/
		for (Professeur prof : profs) {
			String[] data = {prof.getNom(), prof.getPrenom()};
			modelProf.addRow(data);
		}
		
		return panelVoirProf;
	}
	

	private JPanel fenetreVoirPromotions() {
		JPanel panelPromotions = new JPanel();

		panelPromotions.setBackground(Color.WHITE);
		panelPromotions.setBounds(0, 33, 694, 338);
		panelPromotions.setLayout(null);
		
		JLabel lblTitre = new JLabel("Liste des promotions");
		lblTitre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTitre.setBounds(258, 11, 193, 18);
		panelPromotions.add(lblTitre);
		
		String header[] = {"Promotion", "Nombre d'eleves"};
				
		DefaultTableModel modelPromotion = new DefaultTableModel();
		modelPromotion.setColumnIdentifiers(header);
		JTable promotionTableau = new JTable(modelPromotion);
		promotionTableau.setAutoCreateRowSorter(true);

		promotionTableau.setModel(modelPromotion);
		promotionTableau.setBounds(23, 94, 647, 64);

		JScrollPane scrollPane = new JScrollPane(promotionTableau);
		scrollPane.setBounds(23, 94, 647, 64);
		panelPromotions.add(scrollPane);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = modelPromotion.getRowCount();
				for (int i=n-1 ; i>=0 ; --i) modelPromotion.removeRow(i);

				for (Promotion promo : Promotion.getPromotions()) {
					String[] data = {promo.getNom(), Integer.toString(promo.getEleves().size())};
					modelPromotion.addRow(data);
				}
			}
		});
		btnActualiser.setBounds(23, 11, 100, 23);
		panelPromotions.add(btnActualiser);
		
		/** On insert les eleves*/
		for (Promotion promo : Promotion.getPromotions()) {
			String[] data = {promo.getNom(), Integer.toString(promo.getEleves().size())};
			modelPromotion.addRow(data);
		}
		
		return panelPromotions;
	}
	

	private JPanel fenetreClassementPromo() {
		JPanel panelClassementPromo = new JPanel();
		panelClassementPromo.setBackground(Color.WHITE);
		panelClassementPromo.setBounds(0, 33, 694, 338);
		panelClassementPromo.setLayout(null);
		
		JLabel lblTitre = new JLabel("Classement de la promotion");
		lblTitre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTitre.setBounds(232, 7, 234, 18);
		panelClassementPromo.add(lblTitre);
		
		String header[] = {"Nom","Prenom","Promotion","Moyenne", "Mediane"};
		
		DefaultTableModel modelClassementPromo = new DefaultTableModel();
		modelClassementPromo.setColumnIdentifiers(header);
		JTable classementTableau = new JTable(tableModel);
		classementTableau.setAutoCreateRowSorter(true);
		classementTableau.setModel(modelClassementPromo);
		classementTableau.setBounds(20, 36, 660, 291);

		JScrollPane scrollPane = new JScrollPane(classementTableau);
		scrollPane.setBounds(20, 36, 660, 291);
		panelClassementPromo.add(scrollPane);
		
		JButton button = new JButton("Actualiser");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** On supprime toutes les lignes pour ajouter les anciennes et les nouvelles (actualiser)*/
				int n = modelClassementPromo.getRowCount();
				for (int i=n-1 ; i>=0 ; --i) modelClassementPromo.removeRow(i);

				for (Promotion promo : Promotion.getPromotions()) {
					for (Eleve eleve : promo.classementOrdreCroissantMoyenne()) {
						String[] data = {eleve.getNom(), eleve.getPrenom(), eleve.getPromotion().getNom(), Double.toString(eleve.moyenne()), Double.toString(eleve.mediane())};
						modelClassementPromo.addRow(data);
					}
				}
			}
		});
		button.setBounds(21, 6, 100, 23);
		panelClassementPromo.add(button);
		
		Choice choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
				String choix = (String)item.getItem();
				
				if(choix.equals("Moyenne: ordre croissant")) {
					/** On supprime toutes les lignes pour ajouter les anciennes et les nouvelles (actualiser)*/
					int n = modelClassementPromo.getRowCount();
					for (int i=n-1 ; i>=0 ; --i) modelClassementPromo.removeRow(i);

					for (Promotion promo : Promotion.getPromotions()) {
						for (Eleve eleve : promo.classementOrdreCroissantMoyenne()) {
							String[] data = {eleve.getNom(), eleve.getPrenom(), eleve.getPromotion().getNom(), Double.toString(eleve.moyenne()), Double.toString(eleve.mediane())};
							modelClassementPromo.addRow(data);
						}
					}
				}else if(choix.equals("Moyenne: ordre decroissant")) {
					/** On supprime toutes les lignes pour ajouter les anciennes et les nouvelles (actualiser)*/
					int n = modelClassementPromo.getRowCount();
					for (int i=n-1 ; i>=0 ; --i) modelClassementPromo.removeRow(i);

					for (Promotion promo : Promotion.getPromotions()) {
						for (Eleve eleve : promo.classementOrdreDecroissantMoyenne()) {
							String[] data = {eleve.getNom(), eleve.getPrenom(), eleve.getPromotion().getNom(), Double.toString(eleve.moyenne()), Double.toString(eleve.mediane())};
							modelClassementPromo.addRow(data);
						}
					}
				}else if(choix.equals("Mediane: ordre croissant")) {
					/** On supprime toutes les lignes pour ajouter les anciennes et les nouvelles (actualiser)*/
					int n = modelClassementPromo.getRowCount();
					for (int i=n-1 ; i>=0 ; --i) modelClassementPromo.removeRow(i);

					for (Promotion promo : Promotion.getPromotions()) {
						for (Eleve eleve : promo.classementOrdreCroissantMediane()) {
							String[] data = {eleve.getNom(), eleve.getPrenom(), eleve.getPromotion().getNom(), Double.toString(eleve.moyenne()), Double.toString(eleve.mediane())};
							modelClassementPromo.addRow(data);
						}
					}
				}else if(choix.equals("Mediane: ordre decroissant")) {
					/** On supprime toutes les lignes pour ajouter les anciennes et les nouvelles (actualiser)*/
					int n = modelClassementPromo.getRowCount();
					for (int i=n-1 ; i>=0 ; --i) modelClassementPromo.removeRow(i);

					for (Promotion promo : Promotion.getPromotions()) {
						for (Eleve eleve : promo.classementOrdreDecroissantMediane()) {
							String[] data = {eleve.getNom(), eleve.getPrenom(), eleve.getPromotion().getNom(), Double.toString(eleve.moyenne()), Double.toString(eleve.mediane())};
							modelClassementPromo.addRow(data);
						}
					}
				}
			}
		});
		choice.setBounds(495, 7, 185, 20);
		choice.add("Moyenne: ordre croissant");
		choice.add("Moyenne: ordre decroissant");
		choice.add("Mediane: ordre croissant");
		choice.add("Mediane: ordre decroissant");
		
		panelClassementPromo.add(choice);
		
		/** 1er affichage avant les choix: ordre croissant*/
		for (Promotion promo : Promotion.getPromotions()) {
			for (Eleve eleve : promo.classementOrdreCroissantMoyenne()) {
				String[] data = {eleve.getNom(), eleve.getPrenom(), eleve.getPromotion().getNom(), Double.toString(eleve.moyenne()), Double.toString(eleve.mediane())};
				modelClassementPromo.addRow(data);
			}
		}
		
		return panelClassementPromo;
	}
}