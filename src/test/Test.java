package test;

import java.util.ArrayList;
import java.util.List;

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
		Promotion P2021 = new Promotion("2021");
		Promotion P2022 = new Promotion("2022");
		
		//Initialisation de plusieur eleves
//		Eleve elev1 = new Eleve("SERHIR", "Mohamed", 20160251, P2021);
//		Eleve elev2 = new Eleve("RIKA", "Saed", 20160375, P2021);
//		Eleve elev3 = new Eleve("YAI", "Yous", 20170294, P2022);
//		Eleve elev4 = new Eleve("TAREK", "Alan", 20170403, P2022);
		
		Eleve elev1 = new Eleve("Serhir", "Mohamed", 16, 01, 1998);
		Eleve elev2 = new Eleve("Zarga", "Ines", 25, 07, 1998);
		Eleve elev3 = new Eleve("TAREK", "Alan", 06, 03, 1998);
		Eleve elev4 = new Eleve("YAI", "Yous", 19, 02, 1998);
		
		
		
		//initialisation de plusieur professeurs
		Professeur prof1 = new Professeur("TELLER", "Patrick");
		Professeur prof2 = new Professeur("CONTEVILLE", "Laurie");
		Professeur prof3 = new Professeur("SIROT", "Isabelle");
		Professeur prof4 = new Professeur("SOMA", "Jean");
		Professeur prof5 = new Professeur("FERRANDIS", "Philippe");
		
		
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
		
		Evaluation eval16 = new Evaluation("maths", 20, elev1, prof1);
		Evaluation eval17 = new Evaluation("physique", 11, elev1, prof2);
		Evaluation eval18 = new Evaluation("informatique", 19, elev1, prof3);
		Evaluation eval19 = new Evaluation("communication", 17, elev1, prof4);
		Evaluation eval20 = new Evaluation("finance", 13, elev1, prof5);
		
		/*
		System.out.print("Affichage des �valuations");
		System.out.print(eval1);
		System.out.print(eval2);
		System.out.print(eval3);
		System.out.print(eval4);
		System.out.print(eval5);
		*/
		
		//On rentre les eval dans elev1
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

		/**
		 
		 System.out.print(elev1);
		System.out.print("\n-------------------------------------------------------------\n");
		System.out.print(elev2);
		System.out.print("\n-------------------------------------------------------------\n");
		 */
		

		//System.out.println(P2021.classementOrdreCroissantMoyenne());

	

	}
}
