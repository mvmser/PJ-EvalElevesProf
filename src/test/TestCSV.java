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
		@SuppressWarnings("unused")
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		//System.out.println(eleves);
		Eleve eleve1 = new Eleve("SERHIR", "Mohamed", 16, 01, 1998);
		//afficherEleve(eleves);
		//afficherProfesseur(profs);
		WriteCSV.writeEleveToCSV(eleve1);
		menu(P2021, profs);
	}
	
	
	public static void menu(Promotion promotion, List<Professeur> profs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------MENU----------");
		System.out.println("1. Vous etes un prof ? ");
		System.out.println("2. Vous etes un eleve ? ");
		int choix = sc.nextInt();
		sc.nextLine();
		
		if(choix == 1) {
			System.out.println(whoProf(profs));
			System.out.println("3. Rechercher eleve ");
			System.out.println("4. Ajouter Notes ");
			int choix1 = sc.nextInt();
		
			if(choix1 == 3) {
				rechercherEleve(promotion);
			}
			if(choix == 4) {	
				//whoProf(profs);
				ajouterNote(profs, whoProf(profs));	
			}	
			else {
				System.out.println("\n----------error----------");
			}
		}else if(choix == 2) {
			
		}
		sc.close();		
	}
	

	
	public static String whoProf(List<Professeur> profs) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Quel est votre nom : ");
//		String nomm = sc.nextLine();
//		
//		for(Professeur prof : profs) {
//			if(prof.getNom().equals(nomm)) {
//				sc.close();
//				return prof;
//			}
//		}
//		System.out.println("Pas de prof trouvé avec ce nom");
//		sc.close();
//		return null;
		
		System.out.println("Vous etes profs, mais qui etes-vous ? ");
		int i = 0;
		for (Professeur prof : profs) {
			System.out.println(i + ". " + prof.getNom());
			i++;
		}
		
		String nomProf = null;
		int numProf = Integer.MAX_VALUE;
		
		@SuppressWarnings("unused")
		boolean OK = true;
		
		do {
			try {
				 numProf = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Entrer un entier");
				OK = false;
				sc.nextLine();
			}
			
			if(numProf <= profs.size()){
				nomProf = profs.get(numProf).getNom();
				OK = true;
			}else {
				System.out.println("Veuillez entre un numero valide");
				OK = false;
			}
		}while(OK == false);
		sc.close();
		return nomProf;
	}
	
	
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
		sc.close();
	}
	public static void ajouterNote(List<Professeur> profs, String nomProf) {
//		System.out.println("\n----------Ajouter une note a un eleve----------");
//		System.out.printf("Quel eleve ? Entrer son identifiant : ");
//		Scanner sc = new Scanner(System.in);
//		int numid = 0;
//		try {
//			numid = sc.nextInt();
//			Professeur.rechercheEleve(numid, promotion);
//		} catch (InputMismatchException e) {
//			System.out.println("Entrer un entier");
//		}
//		
//		try {
//			System.out.printf("Maintenant, entrer note pour cette eleve : ");
//			int note = sc.nextInt();
//			System.out.printf("Maintenant, entrer l'indice de cette note : ");
//			int indice = sc.nextInt();
//			
//			prof.setNote(promotion, numid, note, indice);
//		}catch(InputMismatchException e) {
//			System.out.println("Entrer un entier");
//		}
//		sc.close();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vous etes " + nomProf +", vous pouvez modifier une note d'un eleve : ");
		
		System.out.printf("Quel eleve ? Entrer son identifiant : ");
		int numid = 0;
		try {
			numid = sc.nextInt();
			Professeur.rechercheEleve(numid, P2021);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
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
				//eleve.setPromotion(P2021);
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
