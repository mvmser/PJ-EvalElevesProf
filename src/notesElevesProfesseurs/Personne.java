package notesElevesProfesseurs;

//Eleve et Professeur hérite de Personne car ils ont des propriétés communes (prenom et nom)
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
