package notesElevesProfesseurs;

public abstract class Personne {

	protected  String nom;
	protected String prenom;
	
	public Personne(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;
	}
	public Personne() {
	
		
	}
	
	
	//Acceseur : getteur
	public String getNom(){
		return nom;
	}
	public String getPrenom(){
		return prenom; 
	}
	
}
