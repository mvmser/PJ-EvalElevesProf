package notesElevesProfesseurs;

import java.util.ArrayList;

public class Promotion {

	private String nom;
	private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
	
	/* constructeur a 1 parametre*/
	public Promotion(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * un accesseur en lecture getEleves. Justifier sa signature en commentaires dans le
	 * code. Attention à ne pas violer le principe d’encapsulation.
	 */
	public ArrayList<Eleve> getEleves() {
		return eleves;
	}
	
	
	public void setEleves(Eleve eleve) {
		eleves.add(eleve);
	}

	//rechercher
	public Eleve rechercher(int numId) {
		for(Eleve eleve: this.eleves) {
			if(eleve.getNumIdentifiant() == numId)
				return eleve;
		}	
		return null;
	}
}
