package notesElevesProfesseurs;

public class Professeur extends Personne {

	//---CONSTRUCTEURS---
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}
	public Professeur() {
		super();
	}
	

	//---ACCESSEURS : Getteurs--- 
	public void rechercheEleve(Eleve eleve) {
		
	}
	public void modifierNote(Eleve eleve){

	}

	
	//---TOSTRING---
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") ";
	}
	
	
}
