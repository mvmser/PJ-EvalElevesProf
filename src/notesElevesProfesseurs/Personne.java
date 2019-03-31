package notesElevesProfesseurs;

/**
 * Eleve et Professeur heritent de Personne car ils ont des proprietes communes (prenom et nom)
 * On utilise alors la fonctionnalite d'heritage.
 * 
 * @author SERHIR, ZARGA
 * @version 1.0
 */
public abstract class Personne {

	//---ATTRIBUTS---\\
	protected  String nom;
	protected String prenom;
	
	
	//---CONSTRUCTEURS---\\
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personne() {
		
	}
	
	/**
	* Accesseur permettant de recuperer
	* le nom de la personne
	* @return le nom
	* @since 1.0
	*/
	public String getNom(){
		return nom;
	}
	
	/**
	* Accesseur permettant de recuperer
	* le prenom de la personne
	* @return le prenom
	* @since 1.0
	*/
	public String getPrenom(){
		return prenom; 
	}
	
}
