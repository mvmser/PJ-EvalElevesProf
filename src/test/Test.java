package test;

import notesElevesProfesseurs.*;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Eleve elev1 = new Eleve("SERHIR", "Mohamed", 1);
		Eleve elev2 = new Eleve("ZARGA", "Ines", 2);
		Eleve elev3 = new Eleve("AZZAOUI", "Youssef", 3);
		Eleve elev4 = new Eleve("TAREK", "Alan", 4);
		
		Professeur prof1 = new Professeur("TELLER", "Patrick");
		Professeur prof2 = new Professeur("CONTEVILLE", "Laurie");
		Professeur prof3 = new Professeur("SIROT", "Isabelle");
		Professeur prof4 = new Professeur("SOMA", "Jean");
		Professeur prof5 = new Professeur("FERRANDIS", "Philippe");
		
		Evaluation eval1 = new Evaluation("maths", 20, elev1, prof1);
		Evaluation eval2 = new Evaluation("physique", 11, elev1, prof2);
		Evaluation eval3 = new Evaluation("informatique", 19, elev1, prof3);
		Evaluation eval4 = new Evaluation("communication", 17, elev1, prof4);
		Evaluation eval5 = new Evaluation("finance", 13, elev1, prof5);
		
		System.out.print(eval1);
		System.out.print(eval2);
		System.out.print(eval3);
		System.out.print(eval4);
		System.out.print(eval5);
		
		//On rentre les eval dans elev1
		elev1.setEvaluation(eval1);
		System.out.print(elev1);


	}
}
