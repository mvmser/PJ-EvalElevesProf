package notesElevesProfesseurs;

public class Professeur extends Personne {

	
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}
	public Professeur() {
		super();
	}
	
	
	public void rechercheEleve(Eleve eleve) {
		
	}
	public void modifierNote(Eleve eleve){

	}

	@Override
	public String toString() {
		return "Professeur []" + "Nom : " + this.nom + "Prenom : " + this.prenom;
	}
	
	
}
