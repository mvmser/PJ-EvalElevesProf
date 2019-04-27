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
		
		//Eleve eleve1 = new Eleve("SERHIR", "Mohamed", 16, 01, 1998);
		
		/** Afficher la liste de tous les eleves*/
		//afficherEleve(eleves);
		/** Afficher la liste de tous les professeurs*/
		//afficherProfesseur(profs);
		//WriteCSV.writeEleveToCSV(eleve1);
		menu(P2021, profs);
	}
	
	
	public static void menu(Promotion promotion, List<Professeur> profs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------MENU----------");
		System.out.println("1. Vous etes un prof ? ");
		System.out.println("2. Vous etes un eleve ? ");
		System.out.println("3. Consultation ");
		System.out.println("4. Classement ");
		System.out.println("0. Quitter ");
		int choix = sc.nextInt();
		sc.nextLine();
		
		do {
			/** Si choix = professeur */
			if(choix == 1) {
				/** Savoir qui est ce prof */
				whoProf(profs);
				
				System.out.println("11. Rechercher eleve ");
				System.out.println("12. Ajouter Notes ou modification d'une note ");
				int choix1 = sc.nextInt();
				//sc.nextLine();
				
				if(choix1 == 11) {
					rechercherEleve(promotion);
				}
				if(choix == 12) {	
					//whoProf(profs);
					//ajouterNote(profs, whoProf(profs));	
				}	
				else {
					System.out.println("\n----------error----------");
				}
				
			/** Si choix = eleve */
			}else if(choix == 2) {
				System.out.println("21. Consulter mon bulletin de note ");
				System.out.println("22. Ma moyenne ");
				System.out.println("23. Ma mediane ");
				
			/** Si choix = consultation */
			}else if(choix == 3) {
				System.out.println("31. Voir la liste des élèves ");
				System.out.println("32. Voir la liste des professeurs ");
				
			/** Si choix = classement */	
			}else if(choix == 4) {
				System.out.println("41. Classement de la promotion ");
				System.out.println("42. Classement par matière ");	
			}
			sc.close();		
		}while(choix == 1 || choix == 2 || choix == 3 || choix == 4);
		
	}
	

	
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
		sc.close();
		return proff;
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
