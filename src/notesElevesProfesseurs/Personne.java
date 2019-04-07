package notesElevesProfesseurs;

/**
 * Eleve et Professeur heritent de Personne car ils ont des proprietes communes (prenom et nom)
 * On utilise alors la fonctionnalite d'heritage.
 * 
 * @version 1.0
 */
public abstract class Personne {

	/** Attributs d'une personne */
	protected  String nom;
	protected String prenom;
	
	/**
	 * Constructeur d'une personne, avec un nom et un prenom
	 * Utilisé pour Professeur et eleves car le nom et prenom sont des propriétés communes
	 * @param nom
	 * @param prenom
	 * @since 1.0
	 */
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * @deprecated Utiliser le constructeur à deux parametres
	 */
	public Personne() {
	}
	
	/**
	* Accesseur permettant de recuperer le nom de la personne
	* @return le nom
	* @since 1.0
	*/
	public String getNom(){
		return nom;
	}
	
	/**
	* Accesseur permettant de recuperer le prenom de la personne
	* @return le prenom
	* @since 1.0
	*/
	public String getPrenom(){
		return prenom; 
	}
	
}
