package test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import notesElevesProfesseurs.*;
import readCSV.ReadCSV;

/*
 * @author SERHIR, ZARGA
 * @version 1.0
 */
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//Creation des promotions 
		Promotion promotion = new Promotion("P2021");
		List<Eleve> eleves = new ArrayList();
		List<Professeur> profs = new ArrayList();
		
		/**Initialisation de plusieurs eleves et ajout dans arraylist*/
		Eleve elev1 = new Eleve("Serhir", "Mohamed", 16, 01, 1998);
		eleves.add(elev1);
		Eleve elev2 = new Eleve("Zarga", "Ines", 25, 07, 1998);
		eleves.add(elev2);
		Eleve elev3 = new Eleve("TAREK", "Alan", 06, 03, 1998);
		eleves.add(elev3);
		Eleve elev4 = new Eleve("YAI", "Yous", 19, 02, 1998);
		eleves.add(elev4);
		
	
		/**initialisation de plusieur professeurs et ajout dans arraylist*/
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
		
		
		//initialisation des evaluations\\
		Evaluation eval1 = new Evaluation("maths", 11, elev1, prof1);
		Evaluation eval2 = new Evaluation("physique", 19.6, elev1, prof2);
		Evaluation eval3 = new Evaluation("informatique", 13, elev1, prof3);
		Evaluation eval4 = new Evaluation("communication", 19.5, elev1, prof4);
		Evaluation eval5 = new Evaluation("finance", 20, elev1, prof5);

		Evaluation eval6 = new Evaluation("maths", 20, elev2, prof1);
		Evaluation eval7 = new Evaluation("physique", 11, elev2, prof2);
		Evaluation eval8 = new Evaluation("informatique", 19, elev2, prof3);
		Evaluation eval9 = new Evaluation("communication", 17, elev2, prof4);
		Evaluation eval10 = new Evaluation("finance", 13, elev2, prof5);

		Evaluation eval11 = new Evaluation("maths", 20, elev3, prof1);
		Evaluation eval12 = new Evaluation("physique", 11, elev3, prof2);
		Evaluation eval13 = new Evaluation("informatique", 19, elev3, prof3);
		Evaluation eval14 = new Evaluation("communication", 17, elev3, prof4);
		Evaluation eval15 = new Evaluation("finance", 13, elev3, prof5);
		
		Evaluation eval16 = new Evaluation("maths", 20, elev4, prof1);
		Evaluation eval17 = new Evaluation("physique", 11, elev4, prof2);
		Evaluation eval18 = new Evaluation("informatique", 19, elev4, prof3);
		Evaluation eval19 = new Evaluation("communication", 17, elev4, prof4);
		Evaluation eval20 = new Evaluation("finance", 13, elev4, prof5);
		
		
		/**System.out.print("Affichage des �valuations");
		System.out.print(eval1);
		System.out.print(eval2);
		System.out.print(eval3);
		System.out.print(eval4);
		System.out.print(eval5);*/
		
		
		/**On rentre les eval dans elev1*/
		elev1.setEvaluation(eval1);
		elev1.setEvaluation(eval2);
		elev1.setEvaluation(eval3);
		elev1.setEvaluation(eval4);
		elev1.setEvaluation(eval5);
		
		elev2.setEvaluation(eval6);
		elev2.setEvaluation(eval7);
		elev2.setEvaluation(eval8);
		elev2.setEvaluation(eval9);
		elev2.setEvaluation(eval10);

		
		 for(Eleve eleve : eleves) {
			 System.out.print(eleve);
			 System.out.print("\n-------------------------------------------------------------\n");
		 }
		 
		/**RECHERCHER ELEVE*/
		System.out.println("\n----------Rechercher un eleve avec son identifiant :----------");
		System.out.printf("Quel est l'identifiant ?  ");
		try {
			Scanner sc = new Scanner(System.in);
			int numid = sc.nextInt();
		
			Professeur.rechercheEleve(numid, promotion);
		} catch (InputMismatchException e) {
			System.out.println("Entrer un entier");
		}
		
		/**AJOUTER NOTES*/
		System.out.println("\n----------Ajouter une note a un eleve----------");
		System.out.printf("Vous etes profs, mais qui etes-vous ? Entrer votre nom : ");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		
		for(Professeur prof : profs) {
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
		
		

		//System.out.println(P2021.classementOrdreCroissantMoyenne());

	

	}
}
