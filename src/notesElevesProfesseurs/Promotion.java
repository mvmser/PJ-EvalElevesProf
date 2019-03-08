package notesElevesProfesseurs;

import java.util.ArrayList;

public class Promotion extends Eleve {

	private String nom;
	private ArrayList<Eleve> eleves;
	
	/* constructeur a 1 parametre*/
	public Promotion(String nom) {
		this.nom = nom;
		
		//A chaque creation deleve, on l'ajoute � l'arrayList eleves
		eleves.add(this);
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Eleve> getEleves() {
		return eleves;
	}
	
	//rechercher
	public Eleve rechercher(int numId) {
		for(int i = 0; i < eleves.size(); i++) {
			if(this.eleves.get(i).getNumIdentifiant() == numId) {
				return this.eleves.get(i);
			}
		}	
		return null;
	}
}
