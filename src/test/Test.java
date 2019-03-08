package test;
import java.util.ArrayList;

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
		
		ArrayList<String> matieres = new ArrayList<String>();
		matieres.add("maths");
		matieres.add("physique");
		matieres.add("informatique");
		matieres.add("communication");
		matieres.add("finance");
		
		Evaluation eval1 = new Evaluation();
		elev1.setEvaluation(evaluation1);
		
		Evaluation eval1 = new Evaluation("Mathématiques", 19, elev1, prof1);

		
		System.out.print(eval1);
	}
}
