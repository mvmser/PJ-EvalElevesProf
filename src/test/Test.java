package test;

import notesElevesProfesseurs.*;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//initialisation de plusieur eleves
		Eleve elev1 = new Eleve("SERHIR", "Mohamed", 1);
		Eleve elev2 = new Eleve("ZARGA", "Ines", 2);
		Eleve elev3 = new Eleve("AZZAOUI", "Youssef", 3);
		Eleve elev4 = new Eleve("TAREK", "Alan", 4);
		
		//initialisation de plusieur professeurs
		Professeur prof1 = new Professeur("TELLER", "Patrick");
		Professeur prof2 = new Professeur("CONTEVILLE", "Laurie");
		Professeur prof3 = new Professeur("SIROT", "Isabelle");
		Professeur prof4 = new Professeur("SOMA", "Jean");
		Professeur prof5 = new Professeur("FERRANDIS", "Philippe");
		
		
		//initialisation des evaluations\\
		Evaluation eval1 = new Evaluation("maths", 20, elev1, prof1);
		Evaluation eval2 = new Evaluation("physique", 11, elev1, prof2);
		Evaluation eval3 = new Evaluation("informatique", 19, elev1, prof3);
		Evaluation eval4 = new Evaluation("communication", 17, elev1, prof4);
		Evaluation eval5 = new Evaluation("finance", 13, elev1, prof5);
		
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
				
		
		System.out.print(eval1);
		System.out.print(eval2);
		System.out.print(eval3);
		System.out.print(eval4);
		System.out.print(eval5);
		
		//On rentre les eval dans elev1
		elev1.setEvaluation(eval1);
		elev1.setEvaluation(eval2);
		elev1.setEvaluation(eval4);
		elev1.setEvaluation(eval5);
		System.out.print(elev1);
		



	}
}
