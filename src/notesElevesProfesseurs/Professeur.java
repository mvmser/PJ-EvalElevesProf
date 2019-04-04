package notesElevesProfesseurs;

/**
 * 
 * @author SERHIR, ZARGA
 * @version 1.1
 *
 */
public class Professeur extends Personne {

	/**
	 * Constructeur de professeur
	 * @param nom
	 * @param prenom
	 * @since 1.0
	 */
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}	
	
	/**
	 * Permet de retrouver un eleve s'il existe
	 * avec l'identifiant on peut retrouver la promotion car chque leve connait sa promotion
	 * la methode rechercher de promotion permet de savoir si un eleve est dans cette promo
	 * @param numId
	 * @return l'eleve recherché sinon null
	 * @since 1.1
	 */
	public Eleve rechercheEleve(int numId) {
		
		return null;
	}
	
	/**
	 * NEED TO UP
	 * @param promo
	 * @param numId
	 * @param note
	 * @param indice
	 * @since 1.0
	 */
	public void setNote(Promotion promo, int numId, int note, int indice) {
		try {
			//Eleve eleve = rechercheEleve(numId);
			//Si la note d'indice i existe alors elle est modifier
			//eleve.getNotes().get(indice);
			
		}catch(IllegalStateException e) {
			System.out.println("L'eleve numero: " + numId + " n'existe pas");
		}
	}

	/**
	 *  Methode toString
	 *  @return Un string, le nom le prenom d'un prof
	 *  @since 1.0
	 */
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") ";
	}
}
