package test;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import readCSV.ReadCSV;

public class TestCSV {

	
	public static void main(String[] args) {
		/** On a besoin de la promotion pour un prof*/
		Promotion promotion = new Promotion("P2021");
		
		/** Permet d'enregistrer dans la memoire tous les eleves et profs des fichiers csv*/
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		
		//afficherEleve(eleves, promotion);
		//afficherProfesseur(profs, promotion);

			
	}
	
	
	public static void menu(Promotion promotion, List<Professeur> profs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------MENU----------");
		System.out.println("1. Vous etes un prof ? ");
		System.out.println("2. Vous etes un eleve ? ");
		int choix = sc.nextInt();
		
		if(choix == 1) {
			System.out.println("Quel est votre nom : ");
			String nomm = sc.nextLine();
			 //faire methode pr savoir qui est le nom du prof
			for(Professeur prof : profs) {
				if(prof.getNom() == nomm) {
					System.out.println("Bienvenue " + prof);
				}
			}
			System.out.println("1. Rechercher eleve ");
			System.out.println("2. Ajouter Notes ");
			int choix1 = sc.nextInt();
			
			if(choix1 == 1) {
				rechercherEleve(promotion);
			}
			else if(choix == 2) {
				//ajouterNote(promotion, prof1);
			}
			
		}
			else if(choix == 2) {
			
		}
		
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
	public static void afficherEleve(List<Eleve> eleves, Promotion promotion) {
		/** Si le fichier contient au moins un eleve*/
		if(eleves.size() > 0) {
			/** On recupere la promo des eleves ajout�s (on part du principe qu'ils sont tous dans la meme promo*/
			promotion = eleves.get(0).getPromotion();
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
	public static void afficherProfesseur(List<Professeur> profs, Promotion promotion) {
		/** Si le fichier contient au moins un prof*/
		if(profs.size() > 0) {
			/** Permet d'afficher tous les profs du fichier csv*/
			
			
			for(Professeur prof : profs) {
				/** On ajoute a chaque prof la promotion de l'eleve */
				prof.addPromotionToProf(promotion);
				System.out.println(prof);
				System.out.println("---------------------");
			}
		} else {
			System.out.println("Il n'y a pas de professeurs dans ce fichier...");
		}	
	}

}
