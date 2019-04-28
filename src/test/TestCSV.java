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

public class TestCSV {

	private static Promotion P2021 = new Promotion("2021");
	static int numProf;

	public static void main(String[] args) {		
		/** Afficher la liste de tous les eleves*/
		//afficherEleve(eleves);
		
		/** Afficher la liste de tous les professeurs*/
		//afficherProfesseur(profs);
		
		menu(P2021);
	}
	
	
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

		Scanner sc = new Scanner(System.in);
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
				whoProf(profs);
				
				int choixProf = 0;
				do {
					System.out.println("1. Rechercher eleve");
					System.out.println("2. Ajouter Notes ou modification d'une note");

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
					
				}while(choixProf < 1 || choixProf > 2);
				
				switch (choixProf) {
					case 1:
						rechercherEleve(promotion);
						break;
					case 2:
						ajouterNote(profs, whoProf(profs).getNom());	
						break;
		
					default:
						System.out.println("\n----------error----------");
						break;
				}
				
			/** Si choix = eleve */
			}else if(choix == 2) {
				int choixBulletin = 0;
				Eleve eleve =  getEleveFromID(eleves);
				if(eleve != null) {
					do {
						System.out.println("1. Consulter mon bulletin de note");
						System.out.println("2. Consulter ma moyenne");
						System.out.println("3. Consulter ma mediane");

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
						
					}while(choixBulletin < 1 || choixBulletin > 3);
					
					switch (choixBulletin) {
						case 1:
							System.out.println("Mes notes:");
							System.out.println(eleve.getMatieresAndNotes());
							break;
						case 2:
							System.out.println("Mes notes:");
							System.out.println(eleve.moyenne());
							break;
						case 3:
							System.out.println("Mes notes:");
							System.out.println(eleve.mediane());
							break;
			
						default:
							break;
					}
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
					System.out.println("1. Ajout de professeur");
					System.out.println("2. Ajout d'eleve");
					System.out.println("2. Ajout de promotion");

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
						
						break;
						
					case 2:
						
						break;
						
					case 3:
						
						break;
	
					default:
						break;
				}
			}
		}while(choix != 0);
		
		sc.close();
	}
	
	
	public static Eleve getEleveFromID(ArrayList<Eleve> eleves) {
		int id = 0;
		System.out.printf("Quel est l'identifiant ?  ");
		Scanner sc = new Scanner(System.in);
		
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
		
		sc.close();
		
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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous etes profs, mais qui etes-vous ? ");
		int i = 0;
		for (Professeur prof : profs) {
			System.out.println(i + ". " + prof.getNom());
			i++;
		}
		
		@SuppressWarnings("unused")
		String nomProf = null;
		Professeur proff = new Professeur(null, null);
		int numProf = Integer.MAX_VALUE;
		
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
				nomProf = profs.get(numProf).getNom();
				proff = profs.get(numProf);
				OK = true;
			}else {
				System.out.println("Veuillez entre un numero valide");
				OK = false;
			}
		}while(OK == false);
		
		
		return proff;
	}
	
	/**
	 * Permet de rechercher un eleve par un professeur
	 * @param promotion
	 */
	public static Eleve rechercherEleve(Promotion promotion) {
		//System.out.println("\n----------Rechercher un eleve avec son identifiant :----------");
		System.out.printf("Quel est l'identifiant ?  ");
		Scanner sc = new Scanner(System.in);
		Eleve eleve = null;
		try {
			int numid = sc.nextInt();
			eleve = Professeur.rechercheEleve(numid, promotion);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
		sc.close();
		return eleve;
	}
	
	
	/**
	 * Modifier ou ajouter une note pour un professeur
	 * @param profs
	 * @param nomProf
	 */
	public static void ajouterNote(List<Professeur> profs, String nomProf) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous etes " + nomProf +", vous pouvez modifier une note d'un eleve : ");
	
		System.out.printf("Quel eleve ? Entrer son identifiant : ");
		int numid = 0;
		try {
			numid = sc.nextInt();
			Professeur.rechercheEleve(numid, P2021);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
		
		
		try {
			System.out.printf("Maintenant, entrer note pour cette eleve : ");
			int note = sc.nextInt();
			System.out.printf("Maintenant, entrer l'indice de cette note : ");
			int indice = sc.nextInt();
			
			if(profs.get(numProf).setNote(P2021, numid, note, indice)) {
				System.out.println("La note a ete ajoutee");
			}else {
				System.out.println("Aucune note ajoutee");
			}
		}catch(InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
		
		Professeur.rechercheEleve(numid, P2021);
		
		sc.close();
	}
	
	public static void consulterBulletin(Promotion promotion) {
		Scanner sc = new Scanner(System.in);
		
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
		sc.close();
	}
	
	public static void consulterMoy(List<Eleve> eleves, Promotion promotion) {
		Scanner sc = new Scanner(System.in);
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
	
		sc.close();
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
		Scanner sc = new Scanner(System.in);
		System.out.println("AJOUT PROF :");
		System.out.println("Entrer un nom :");
		String nom = sc.nextLine();
		sc.nextLine();
		System.out.println("Entrer un prenom:");
		String prenom = sc.nextLine();
		sc.nextLine();
		
		Professeur prof1 = new Professeur(nom, prenom);
		WriteCSV.writeProfToCSV(prof1);
		
		sc.close();
	}
	public static void ajoutEleve() {
		Scanner sc = new Scanner(System.in);
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
		
		sc.close();
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
