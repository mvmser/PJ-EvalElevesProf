package notesElevesProfesseurs;

public class Professeur extends Personne {

	//---CONSTRUCTEURS---
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}
	public Professeur() {
		super();
	}
	
	//---RECHERCHER ELEVE---
	public Eleve rechercheEleve(int numId) {
		Eleve eleve = new Eleve();
		Promotion promo = null;
		
		for(int i = 0; i < promo.getEleves().size(); i++) {
			if(eleve.getNumIdentifiant() == numId) {
				return eleve;
			}
		}	
		return null;
		
	}
	public void modifierNote(Eleve eleve){

	}

	
	//---TOSTRING---
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") ";
	}
	
	
}
