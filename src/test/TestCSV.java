package test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import readCSV.ReadCSV;
import writeCSV.WriteCSV;

/**
 * 
 * @author SERHIR
 * @author ZARGA
 */
public class TestCSV {

	/** */
	private static Promotion P2021 = new Promotion("2021");
	static private Scanner sc;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {		
		/** Afficher la liste de tous les eleves*/
		//afficherEleve(eleves);
		
		/** Afficher la liste de tous les professeurs*/
		//afficherProfesseur(profs);
		sc = new Scanner(System.in);

		menu(P2021);
		sc.close();
	}
	
	/**
	 * 
	 * @param promotion
	 */
	public static void menu(Promotion promotion) {
		/** Permet d'enregistrer dans la memoire tous les eleves et profs des fichiers csv*/
		ArrayList<Professeur> profs = (ArrayList<Professeur>) ReadCSV.readProfesseursFromCSV();
		ArrayList<Eleve> eleves = (ArrayList<Eleve>) ReadCSV.readElevesFromCSV();
		
		/** On donne la promotion sur laquelle les profs interviennent */
		for (Professeur prof : profs) {
			prof.addPromotionToProf(P2021);
		}
		
		/** On rempli les notes des eleves*/
		P2021.remplirEvalEleves();

		int choix = 0;
		
		do {			
			System.out.println("\n----------MENU----------");
			System.out.println("1. Vous etes un prof ? ");
			System.out.println("2. Vous etes un eleve ? ");
			System.out.println("3. Consultation ");
			System.out.println("4. Classement ");
			System.out.println("5. Ajout ");
			System.out.println("0. Quitter ");
			
			//know if it is a number
            boolean isNumber = false;
			do {
				try {
					choix = sc.nextInt();
					isNumber = true;
				}catch(InputMismatchException e) {
					System.out.println("Entrer un entier");
					sc.nextLine();
				}
			}while(isNumber == false);
			
		
			/** Si choix = professeur */
			if(choix == 1) {
				
				/** Savoir qui est ce prof */
				Professeur professeur = whoProf(profs);
				
				int choixProf = 0;
				do {
					do {
						System.out.println("1. Rechercher eleve");
						System.out.println("2. Ajouter Notes ou modification d'une note");
						System.out.println("3. Retour");

						isNumber = false;
						do {
							try {
								choixProf = sc.nextInt();
								isNumber = true;
							}catch(InputMismatchException e) {
								System.out.println("Entrer un entier");
								isNumber = false;
								sc.nextLine();
							}
						}while(isNumber == false);
						
					}while(choixProf < 1 || choixProf > 3);
					
					switch (choixProf) {
						case 1:
							System.out.println(rechercherEleve(professeur));
							break;
						case 2:
							ajouterNote(professeur);	
							break;
			
						default:
							break;
					}
				}while(choixProf != 3);
				
				
			/** Si choix = eleve */
			}else if(choix == 2) {
				int choixBulletin = 0;
				Eleve eleve =  getEleveFromID(eleves);
				if(eleve != null) {
					do {
						do {
							System.out.println("1. Consulter mon bulletin de note");
							System.out.println("2. Consulter ma moyenne");
							System.out.println("3. Consulter ma mediane");
							System.out.println("4. Retour");
						
							isNumber = false;
							do {
								try {
									choixBulletin = sc.nextInt();
									isNumber = true;
								}catch(InputMismatchException e) {
									System.out.println("Entrer un entier");
									isNumber = false;
									sc.nextLine();
								}
							}while(!isNumber);
							
						}while(choixBulletin < 1 || choixBulletin > 4);
					
					
						switch (choixBulletin) {
						case 1:
							System.out.println("Mes notes:");
							System.out.println(eleve.getMatieresAndNotes());
							break;
						case 2:
							System.out.println("Ma moyenne:");
							System.out.println(eleve.moyenne());
							break;
						case 3:
							System.out.println("Ma mediane:");
							System.out.println(eleve.mediane());
							break;
			
						default:
							break;
						}
					}while(choixBulletin != 4);
					
				}else {
					System.out.println("Eleve introuvable.");
				}
				
				
			/** Si choix = consultation */
			}else if(choix == 3) {
				int choixListe = 0;
				do {
					System.out.println("1. Voir liste des eleves");
					System.out.println("2. Voir liste des professeurs");

					isNumber = false;
					do {
						try {
							choixListe = sc.nextInt();
							isNumber = true;
						}catch(InputMismatchException e) {
							System.out.println("Entrer un entier");
							isNumber = false;
							sc.nextLine();
						}
					}while(isNumber == false);
					
				}while(choixListe < 1 || choixListe > 2);

				switch (choixListe) {
					case 1:
						afficherListeEleve(eleves);
						break;
					case 2:
						afficherListeProf(profs);
						break;
	
					default:
						break;
				}
				
			/** Si choix = classement */	
			}else if(choix == 4) {
				int choixClassement = 0;
				do {
					System.out.println("1. Classement par moyenne (ordre croissant)");
					System.out.println("2. Classement par moyenne (ordre decroissant)");
					System.out.println("3. Classement par mediane (ordre croissant)");	
					System.out.println("4. Classement par mediane (ordre decroissant)");	

					isNumber = false;
					do {
						try {
							choixClassement = sc.nextInt();
							isNumber = true;
						}catch(InputMismatchException e) {
							System.out.println("Entrer un entier");
							isNumber = false;
							sc.nextLine();
						}
					}while(isNumber == false);
					
				}while(choixClassement < 1 || choixClassement > 4);
				
				switch (choixClassement) {
					case 1:
						System.out.print("\n--classementOrdreCroissantMoyenne-- Nb eleves: "
								+ P2021.classementOrdreCroissantMoyenne().size() +"\n");
							for (Eleve eleve : P2021.classementOrdreCroissantMoyenne()) {
								System.out.println(eleve.getNom() + " " + eleve.getPrenom() 
								+ " moyenne: " + eleve.moyenne());
							}	
						break;
					case 2:
						System.out.print("\n--classementOrdreDecroissantMoyenne-- Nb eleves: "
								+ P2021.classementOrdreDecroissantMoyenne().size() +"\n");
						for (Eleve eleve : P2021.classementOrdreDecroissantMoyenne()) {
							System.out.println(eleve.getNom() + " " + eleve.getPrenom() 
							+ " moyenne: " + eleve.moyenne());
						}
						break;
					case 3:
						System.out.print("\n--classementOrdreCroissantMediane-- Nb eleves: "
								+ P2021.classementOrdreCroissantMediane().size() +"\n");
						for (Eleve eleve : P2021.classementOrdreCroissantMediane()) {
							System.out.println(eleve.getNom() + " " + eleve.getPrenom() 
							+ " mediane: " + eleve.moyenne());
						}
						break;
					case 4:
						System.out.print("\n--classementOrdreDecroissantMediane-- Nb eleves: "
								+ P2021.classementOrdreDecroissantMediane().size() +"\n");
						for (Eleve eleve : P2021.classementOrdreDecroissantMediane()) {
							System.out.println(eleve.getNom() + " " + eleve.getPrenom() 
							+ " mediane: " + eleve.moyenne());
						}
						break;
					
					default:
						break;
				}
				
			/** Si choix = ajout */	
			}else if(choix == 5) {
				int choixAjout = 0;
				do {
					do {
						System.out.println("1. Ajout de professeur");
						System.out.println("2. Ajout d'eleve");
						System.out.println("3. Retour");

						isNumber = false;
						do {
							try {
								choixAjout = sc.nextInt();
								isNumber = true;
							}catch(InputMismatchException e) {
								System.out.println("Entrer un entier");
								isNumber = false;
								sc.nextLine();
							}
						}while(isNumber == false);
						
					}while(choixAjout < 1 || choixAjout > 3);
					
					switch (choixAjout) {
						case 1:
							sc.nextLine();
							System.out.println("Nom: ");
							String nom = sc.nextLine();
							System.out.println("Prenom: ");
							String prenom = sc.nextLine();
							
							Professeur prof = new Professeur(nom, prenom);
							prof.addPromotionToProf(promotion);
							/** On l'enregistre dans le fichier pour la prochaine ouverture
							 * mais aussi dans l'arraylist pour l'utilisation actuelle*/
							if(WriteCSV.writeProfToCSV(prof)) {
								profs.add(prof);
								System.out.println("Prof ajouté");
							}else {
								System.out.println("Prof non ajouté");
							}
							break;
							
						case 2:
							sc.nextLine();
							System.out.println("Nom: ");
							String nomEleve = sc.nextLine();
							
							System.out.println("Prenom: ");
							String prenomEleve = sc.nextLine();
							
							int jour = 0;
							int mois = 0;
							int annee = 0;
							
							isNumber = false;
							do {
								try {
									System.out.println("Jour: ");
									jour = sc.nextInt();
									System.out.println("Mois: ");
									mois = sc.nextInt();
									System.out.println("Annee: ");
									annee = sc.nextInt();
									isNumber = true;
								}catch(InputMismatchException e) {
									System.out.println("Entrer un entier");
									isNumber = false;
									sc.nextLine();
								}
							}while(isNumber == false);
							
							Eleve eleve = new Eleve(nomEleve, prenomEleve, jour, mois, annee);
							/** On l'enregistre dans le fichier pour la prochaine ouverture
							 * mais aussi dans l'arraylist pour l'utilisation actuelle*/
							if(WriteCSV.writeEleveToCSV(eleve)) {
								eleves.add(eleve);
								System.out.println("Eleve ajouté");
							}else {
								System.out.println("Eleve non ajouté");
							}
							break;
							
						default:
							break;
					}
				}while(choixAjout !=  3);
				
			}
		}while(choix != 0);
		
	}
	
	
	public static Eleve getEleveFromID(ArrayList<Eleve> eleves) {
		int id = 0;
		System.out.printf("Quel est l'identifiant ?  ");
		
		boolean isNumber = false;
		do {
			try {
				id = sc.nextInt();
				isNumber = true;
			}catch(InputMismatchException e) {
				System.out.println("Entrer un entier");
				isNumber = false;
				sc.nextLine();
			}
		}while(isNumber == false);
		
		for (Eleve eleve : eleves) {
			if(eleve.getNumIdentifiant() == id)
				return eleve;
		}
		return null;
	}
	
	/**
	 * Permet de savoir quel profeseur est l'utilisateur parmi la liste de professeur
	 * @param profs
	 * @return Professeur
	 */
	public static Professeur whoProf(List<Professeur> profs) {
		Professeur professeur = null;
		
		System.out.println("Vous etes profs, mais qui etes-vous ? ");
		int i = 0;
		for (Professeur prof : profs) {
			System.out.println(i + ". " + prof.getNom());
			i++;
		}
		
		int numProf = -1;
		
		boolean OK = true;
		
		do {
			try {
				 numProf = sc.nextInt();
				 sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrer un entier");
				OK = false;
				sc.nextLine();
			}
			
			if(numProf <= profs.size()){
				System.out.println(profs.get(numProf).getNom());
				professeur = profs.get(numProf);
				OK = true;
			}else {
				System.out.println("Veuillez entre un numero valide");
				OK = false;
			}
		}while(OK == false);
		
		
		return professeur;
	}
	
	/**
	 * Permet de rechercher un eleve par un professeur
	 * @param promotion
	 */
	public static Eleve rechercherEleve(Professeur professeur) {
		System.out.println("\n----------Rechercher un eleve avec son identifiant :----------");
		System.out.printf("Quel est l'identifiant ?  ");
		Eleve eleve = null;
		try {
			int numid = sc.nextInt();
			eleve = professeur.rechercheEleve(numid);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
		return eleve;
	}
	
	
	/**
	 * Modifier ou ajouter une note pour un professeur
	 * @param profs
	 * @param nomProf
	 */
	public static void ajouterNote(Professeur professeur) {
		
		System.out.println("Vous etes " + professeur.getNom() +", vous pouvez modifier une note d'un eleve : ");
	
		System.out.printf("Quel eleve ? Entrer son identifiant : ");
		int numid = 0;
		try {
			numid = sc.nextInt();
			System.out.println(professeur.rechercheEleve(numid));
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
		
		try {
			System.out.printf("Maintenant, entrer note pour cette eleve : ");
			int note = sc.nextInt();
			System.out.printf("Maintenant, entrer l'indice de cette note : ");
			int indice = sc.nextInt();
			
			if(professeur.setNote(P2021, numid, note, indice)) {
				System.out.println("La note a ete ajoutee");
			}else {
				System.out.println("Aucune note ajoutee");
			}
		}catch(InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
		
		System.out.println(professeur.rechercheEleve(numid));
	}
	
	public static void consulterBulletin(Promotion promotion) {
		
		System.out.println("Consultation des notes : ");
		System.out.printf("Entrer son identifiant : ");
		int numid = 0;
		Eleve eleve = null;
		try {
			numid = sc.nextInt();
			sc.nextLine();
			eleve = Professeur.rechercheEleve(numid, P2021);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
		
		if(eleve != null) {
			System.out.println("ok eleve1");
		}
		//getMatieresAndNotes()
	}
	
	public static void consulterMoy(List<Eleve> eleves, Promotion promotion) {
		int num = 0;
		
		System.out.println("Consultation de moyenne : ");
		System.out.printf("Entrer son identifiant : ");
		
		try {
			num = sc.nextInt();
			sc.nextLine();
			
			for(Eleve eleve : eleves) {
				if(eleve.getNumIdentifiant() == num) {
					System.out.println(eleve);
					System.out.println(eleve.getNom() + " " + eleve.getPrenom());
				}	
			}
		}catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
	
	}
	
	
	public static void afficherListeEleve(List<Eleve> eleves) {
		for(Eleve eleve : eleves) {	
			System.out.println(eleve.getNom() + " " + eleve.getPrenom());	
		}
	}
	public static void afficherListeProf(List<Professeur> profs) {
		for(Professeur prof : profs) {	
			System.out.println(prof.getNom() + " " + prof.getPrenom());	
		}
	}
	
	public static void ajoutProf() {
		System.out.println("AJOUT PROF :");
		System.out.println("Entrer un nom :");
		String nom = sc.nextLine();
		sc.nextLine();
		System.out.println("Entrer un prenom:");
		String prenom = sc.nextLine();
		sc.nextLine();
		
		Professeur prof1 = new Professeur(nom, prenom);
		WriteCSV.writeProfToCSV(prof1);
		
	}
	public static void ajoutEleve() {
		System.out.println("AJOUT ELEVE :");
		System.out.println("Entrer un nom :");
		String nom = sc.nextLine();
		System.out.println("Entrer un prenom:");
		String prenom = sc.nextLine();
		
		System.out.println("Date de naissance");
		System.out.println("Entrer le jour");
		int jour = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrer le mois");
		int mois = sc.nextInt();
		sc.nextLine();
		System.out.println("Entrer l'annee");
		int annee = sc.nextInt();
		sc.nextLine();
		
		
		Eleve eleve1 = new Eleve(nom, prenom, jour, mois, annee);
		WriteCSV.writeEleveToCSV(eleve1);
		
	}
	
	/**
	 * Permet d'afficher tous les eleves du fichier csv
	 * @param eleves
	 * @param promotion
	 */
	public static void afficherEleve(List<Eleve> eleves) {
		/** Si le fichier contient au moins un eleve*/
		if(eleves != null && eleves.size() >= 1) {
			for(Eleve eleve : eleves) {	
				eleve.setPromotion(P2021);
				System.out.println(eleve);
				System.out.println("---------------------");
			}
		} else {
			System.out.println("Il n'y a pas d'eleves dans ce fichier...");
		}
	}
	
	/**
	 * Permet d'afficher tous les profs du fichier csv
	 * @param profs
	 * @param promotion
	 */
	public static void afficherProfesseur(List<Professeur> profs) {
		/** Si le fichier contient au moins un prof*/
		if(profs != null && profs.size() >= 1) {
			/** Permet d'afficher tous les profs du fichier csv*/
			for(Professeur prof : profs) {
				/** On ajoute a chaque prof la promotion de l'eleve */
				prof.addPromotionToProf(P2021);
				System.out.println(prof);
				System.out.println("---------------------");
			}
		} else {
			System.out.println("Il n'y a pas de professeurs dans ce fichier...");
		}	
	}

}
