package notesElevesProfesseurs;

/*
 * Eleve et Professeur herite de Personne car ils ont des proprietes communes (prenom et nom)
 * On utilise alors la fonctionnalite d'heritage.
 */
public abstract class Personne {

	//---ATTRIBUTS---
	protected  String nom;
	protected String prenom;
	
	
	//---CONSTRUCTEURS---
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personne() {
		
	}
	
	
	//---ACCESSEURS : Getteurs--- 
	public String getNom(){
		return nom;
	}
	public String getPrenom(){
		return prenom; 
	}
	
}
