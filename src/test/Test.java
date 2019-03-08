package test;
import notesElevesProfesseurs.*;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Eleve elev1 = new Eleve("SERHIR", "Mohamed", 1);
		Professeur prof1 = new Professeur("Teller", "Patrick");
		
		Evaluation eval1 = new Evaluation("Maths", 19, elev1, prof1);
		System.out.print("test");

	}

}
