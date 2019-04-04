package test;

import java.util.List;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import readCSV.ReadCSV;

public class TestCSV {

	public static void main(String[] args) {
		/** Permet d'afficher tous les eleves du fichier csv*/
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		for(Eleve eleve : eleves) {
			System.out.println(eleve);
			System.out.println("---------------------");
		}
		
		/** Permet d'afficher tous les profs du fichier csv*/
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		for(Professeur prof : profs) {
			System.out.println(prof);
			System.out.println("---------------------");
		}
	}

}
