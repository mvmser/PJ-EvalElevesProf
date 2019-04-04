package test;

import java.util.List;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import readCSV.ReadCSV;

public class TestCSV {

	
	public static void main(String[] args) {
		/** On a besoin de la promotion pour un prof*/
		Promotion promotion = null;
		
		/** Permet d'afficher tous les eleves du fichier csv*/
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		
		/** Si le fichier contient au moins un eleve*/
		if(eleves.size() > 0) {
			/** On recupere la promo des eleves ajoutés (on part du principe qu'ils sont tous dans la meme promo*/
			promotion = eleves.get(0).getPromotion();
			for(Eleve eleve : eleves) {			
				System.out.println(eleve);
				System.out.println("---------------------");
			}
		} else {
			System.out.println("Il n'y a pas d'eleves dans ce fichier...");
		}
		
		/** Si le fichier contient au moins un prof*/
		if(eleves.size() > 0) {
			/** Permet d'afficher tous les profs du fichier csv*/
			List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
			
			for(Professeur prof : profs) {
				/** On ajoute a chaque prof la promotion de l'eleve */
				prof.addPromotionToProf(promotion);
				System.out.println(prof);
				System.out.println("---------------------");
			}
		} else {
			System.out.println("Il n'y a pas d'eleves dans ce fichier...");
		}		
	}

}
