package test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import notesElevesProfesseurs.*;


/**
 * Permet de creer des eleves, des profs et des evaluations
 * puis de les tester 
 * @author SERHIR
 * @author ZARGA
 * @version 2.0
 */
public class Test {

	public static void main(String[] args) {
		
		/** Les eleves et professeurs cod�s en dur seront enregistr� dans des arraylist*/
		List<Eleve> eleves = new ArrayList<Eleve>();
		List<Professeur> profs = new ArrayList<Professeur>();		
		
		/**Initialisation de plusieurs eleves et ajout dans arraylist*/
		Eleve elev1 = new Eleve("Serhir", "Mohamed", 16, 01, 1998);
		eleves.add(elev1);
		Eleve elev2 = new Eleve("Zarga", "Ines", 25, 07, 1998);
		eleves.add(elev2);
		Eleve elev3 = new Eleve("TAREK", "Alan", 06, 03, 1998);
		eleves.add(elev3);
		Eleve elev4 = new Eleve("YAI", "Yous", 19, 02, 1998);
		eleves.add(elev4);
		
		/**Initialisation de plusieur professeurs et ajout dans arraylist*/
		Professeur prof1 = new Professeur("TELLER", "Patrick");
		profs.add(prof1);
		Professeur prof2 = new Professeur("CONTEVILLE", "Laurie");
		profs.add(prof2);
		Professeur prof3 = new Professeur("SIROT", "Isabelle");
		profs.add(prof3);
		Professeur prof4 = new Professeur("SOMA", "Jean");
		profs.add(prof4);
		Professeur prof5 = new Professeur("FERRANDIS", "Philippe");
		profs.add(prof5);
		
		
		/** On cree une promotion et on met tous les eleves dedans */
		Promotion P2021 = new Promotion("P2021");
		for (Eleve eleve : eleves) {
			eleve.setPromotion(P2021);
		}
		
		/**Initialisation des evaluations*/
		elev1.setEvaluation(new Evaluation("maths", 11, elev1, prof1));
		elev1.setEvaluation(new Evaluation("physique", 19.6, elev1, prof2));
		elev1.setEvaluation(new Evaluation("informatique", 13, elev1, prof3));
		elev1.setEvaluation(new Evaluation("communication", 13, elev1, prof4));
		elev1.setEvaluation(new Evaluation("finance", 20, elev1, prof5));
		
		elev2.setEvaluation(new Evaluation("maths", 20, elev2, prof1));
		elev2.setEvaluation(new Evaluation("physique", 11, elev2, prof2));
		elev2.setEvaluation(new Evaluation("informatique", 13, elev2, prof3));
		elev2.setEvaluation(new Evaluation("communication", 17, elev2, prof4));
		elev2.setEvaluation(new Evaluation("finance", 15, elev2, prof5));
		
		elev3.setEvaluation(new Evaluation("maths", 20, elev3, prof1));
		elev3.setEvaluation(new Evaluation("physique", 11, elev3, prof2));
		elev3.setEvaluation(new Evaluation("informatique", 5, elev3, prof3));
		elev3.setEvaluation(new Evaluation("communication", 9, elev3, prof4));
		elev3.setEvaluation(new Evaluation("finance", 13, elev3, prof5));

		elev4.setEvaluation(new Evaluation("maths", 20, elev4, prof1));
		elev4.setEvaluation(new Evaluation("physique", 20, elev4, prof2));
		elev4.setEvaluation(new Evaluation("informatique", 7, elev4, prof3));
		elev4.setEvaluation(new Evaluation("communication",7, elev4, prof4));
		elev4.setEvaluation(new Evaluation("finance", 8, elev4, prof5));
		
		/**Afficher un eleve*/
		System.out.print(elev1);

		
		/** Afficher tous les eleves de la promo 2021*/
		System.out.print("-------------------------ELEVES:-----------------\n");
		for(Eleve eleve : P2021.getEleves()) {
			 System.out.print(eleve);
		 }
		System.out.print("\n-------------------------------------------------------------\n");
		 
		System.out.print("\n-------------classementOrdreCroissantMoyenne--------------\n");
		System.out.println(P2021.classementOrdreCroissantMoyenne());
		
		System.out.print("\n------------classementOrdreDecroissantMoyenne-----------------\n");
		System.out.println(P2021.classementOrdreDecroissantMoyenne());
		
		System.out.print("\n------------classementOrdreCroissantMediane---------------\n");
		System.out.println(P2021.classementOrdreCroissantMediane());

		System.out.print("\n----------classementOrdreDecroissantMediane------------------\n");
		System.out.println(P2021.classementOrdreDecroissantMediane());
		 
		
		/**----RECHERCHER ELEVE et l'afficher----*/
		System.out.println("\n----------Rechercher un eleve avec son identifiant :----------");
		System.out.printf("Quel est l'identifiant ?  ");
		Scanner sc = new Scanner(System.in);

		try {
			int numid = sc.nextInt();
		
			Professeur.rechercheEleve(numid, P2021);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
			sc.nextLine();
		}
		
		
		/**----AJOUTER/MODIFIER NOTES----*/
		System.out.println("\n----------Ajouter ou modifier une note a un eleve----------");
		System.out.println("Vous etes profs, mais qui etes-vous ? ");
		int i = 0;
		for (Professeur prof : profs) {
			System.out.println(i + ". " + prof.getNom());
			i++;
		}
		
		String nomProf = null;
		int numProf = Integer.MAX_VALUE;
		
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
		
		
		for(Eleve eleve : eleves) {
			 System.out.print(eleve);
			 System.out.print("\n-------------------------------------------------------------\n");
		 }
		
		sc.close();
		
	}
		
		
		/** idee :
		 * for(Professeur prof : profs) {
			if(prof.getNom() == nom) {
				System.out.println("Vous etes " + prof +", vous pouvez modifier une note d'un eleve : ");
				
				System.out.printf("Quel eleve ? Entrer son identifiant : ");
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
			else {
				System.out.println("Ce prof n'existe pas");
			}
		}
		 */

}
