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

	
	public static void main(String[] args) {
		/** On a besoin de la promotion pour un prof*/
		//Promotion promotion = null;
		
		/** Permet d'enregistrer dans la memoire tous les eleves et profs des fichiers csv*/
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		//System.out.println(eleves);
		Eleve eleve1 = new Eleve("SERHIR", "Mohamed", 16, 01, 1998);
		afficherEleve(eleves);
		afficherProfesseur(profs);
		//WriteCSV.writeEleveToCSV(eleve1);
		//menu(promotion, profs);

			
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
			else if(choix == 4) {
				ajouterNote(promotion, whoProf(profs));
			}	
			else {
				System.out.println("\n----------error----------");
			}
		}else if(choix == 2) {
			
		}
		
	}
	

	
	public static Professeur whoProf(List<Professeur> profs) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quel est votre nom : ");
		String nomm = sc.nextLine();
		
		for(Professeur prof : profs) {
			if(prof.getNom().equals(nomm)) {
				return prof;
			}
		}
		System.out.println("Pas de prof trouvé avec ce nom");
		return null;
	}
	
	
	public static void rechercherEleve(Promotion promotion) {
		System.out.println("\n----------Rechercher un eleve avec son identifiant :----------");
		System.out.printf("Quel est l'identifiant ?  ");
		try {
			Scanner sc = new Scanner(System.in);
			int numid = sc.nextInt();
		
			Professeur.rechercheEleve(numid, promotion);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
	}
	public static void ajouterNote(Promotion promotion, Professeur prof) {
		System.out.println("\n----------Ajouter une note a un eleve----------");
		System.out.printf("Quel eleve ? Entrer son identifiant : ");
		Scanner sc = new Scanner(System.in);
		int numid = 0;
		try {
			numid = sc.nextInt();
			Professeur.rechercheEleve(numid, promotion);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
		
		try {
			System.out.printf("Maintenant, entrer note pour cette eleve : ");
			int note = sc.nextInt();
			System.out.printf("Maintenant, entrer l'indice de cette note : ");
			int indice = sc.nextInt();
			
			prof.setNote(promotion, numid, note, indice);
		}catch(InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
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
				///** On ajoute a chaque prof la promotion de l'eleve */
				//prof.addPromotionToProf(promotion);
				System.out.println(prof);
				System.out.println("---------------------");
			}
		} else {
			System.out.println("Il n'y a pas de professeurs dans ce fichier...");
		}	
	}

}
