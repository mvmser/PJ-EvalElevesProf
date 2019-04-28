package test;

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
		/** On a besoin de la promotion pour un prof*/
		
		/** Permet d'enregistrer dans la memoire tous les eleves et profs des fichiers csv*/
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		
		/** On donne la promotion sur laquelle les profs interviennent */
		for (Professeur prof : profs) {
			prof.addPromotionToProf(P2021);
		}
		/** On rempli les notes des eleves*/
		P2021.remplirEvalEleves();
		
	
		
		
		/** Afficher la liste de tous les eleves*/
		//afficherEleve(eleves);
		
		/** Afficher la liste de tous les professeurs*/
		//afficherProfesseur(profs);
		
		
		
		menu(P2021);
	}
	
	
	public static void menu(Promotion promotion) {
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
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
				
				System.out.println("11. Rechercher eleve ");
				System.out.println("12. Ajouter Notes ou modification d'une note ");
				int choix1 = sc.nextInt();
				sc.nextLine();
				
				if(choix1 == 11) {
					rechercherEleve(promotion);
				}
				if(choix1 == 12) {	
					ajouterNote(profs, whoProf(profs).getNom());	
				}	
				else {
					System.out.println("\n----------error----------");
				}
				
			/** Si choix = eleve */
			}else if(choix == 2) {
				System.out.println("21. Consulter mon bulletin de note ");
				System.out.println("22. Ma moyenne ");
				System.out.println("23. Ma mediane ");
				int choix2 = sc.nextInt();
				sc.nextLine();
				
				if(choix2 == 21) {
					consulterBulletin(eleves, P2021);
				}
				else if(choix2 == 22) {
					consulterMoy(eleves, promotion);
				}
				else if(choix2 == 23) {
					consulterMed(eleves, promotion);
				}
				
				
			/** Si choix = consultation */
			}else if(choix == 3) {
				System.out.println("31. Voir la liste des élèves ");
				System.out.println("32. Voir la liste des professeurs ");
				int choix3 = sc.nextInt();
				sc.nextLine();
				
				if(choix3 == 31) {
					afficherListeEleve(eleves);
				}
				else if(choix3 == 32) {
					afficherListeProf(profs);
				}
				
			/** Si choix = classement */	
			}else if(choix == 4) {
				System.out.println("41. Classement par moyenne ");
				System.out.println("42. Classement par mediane ");	
				int choix4 = sc.nextInt();
				sc.nextLine();
				
				if(choix4 == 41) {
					System.out.println("411. Ordre croissant ");
					System.out.println("412. Ordre décroissant ");	
					int choix41 = sc.nextInt();
					sc.nextLine();
					
					if(choix41 == 411) {
						System.out.print("\n-------------classementOrdreCroissantMoyenne--------------\n");
						System.out.println(P2021.classementOrdreCroissantMoyenne());
					}
					else if(choix41 == 412) {
						System.out.print("\n------------classementOrdreDecroissantMoyenne-----------------\n");
						System.out.println(P2021.classementOrdreDecroissantMoyenne());
					}
				
				}
				else if(choix4 == 42) {
					System.out.println("421. Ordre croissant ");
					System.out.println("422. Ordre décroissant ");	
					int choix42 = sc.nextInt();
					sc.nextLine();
					
					if(choix42 == 421) {
						System.out.print("\n------------classementOrdreCroissantMediane---------------\n");
						System.out.println(P2021.classementOrdreCroissantMediane());
					}
					else if(choix42 == 422) {
						System.out.print("\n----------classementOrdreDecroissantMediane------------------\n");
						System.out.println(P2021.classementOrdreDecroissantMediane());
					}
				}
				
				
			/** Si choix = ajout */	
			}else if(choix == 5) {
				System.out.println("51. Ajout de professeur ");
				System.out.println("52. Ajout d'eleve ");	
				int choix5 = sc.nextInt();
				sc.nextLine();
				
				if(choix5 == 51) {
					ajoutProf();
				}
				else if(choix5 == 52) {
					ajoutEleve();
				}
			}
			//sc.close();		
		}while(choix == 1 || choix == 2 || choix == 3 || choix == 4 || choix == 5);
		
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
				//sc.nextLine();
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
		//sc.close();
		
		
		return proff;
	}
	
	/**
	 * Permet de rechercher un eleve par un professeur
	 * @param promotion
	 */
	public static void rechercherEleve(Promotion promotion) {
		System.out.println("\n----------Rechercher un eleve avec son identifiant :----------");
		System.out.printf("Quel est l'identifiant ?  ");
		Scanner sc = new Scanner(System.in);

		try {
			int numid = sc.nextInt();
			Professeur.rechercheEleve(numid, promotion);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
		//sc.close();
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
		
		//sc.close();
	}
	
	public static void consulterBulletin(List<Eleve> eleves, Promotion promotion) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Consultation des notes : ");
		System.out.printf("Entrer son identifiant : ");
		int numid = 0;
		try {
			numid = sc.nextInt();
			sc.nextLine();
			Professeur.rechercheEleve(numid, P2021);
			
			
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
		
		//getMatieresAndNotes()
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
	
		
	}
	
	public static void consulterMed(List<Eleve> eleves, Promotion promotion) {
		
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
