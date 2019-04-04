package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author SERHIR, ZARGA
 * @version 1.2
 *
 */
public class Professeur extends Personne {

	/** Un prof peut intervenir dans une ou plusieurs promotions
	 * ces promotion sont alors contenu dans une list*/
	List<Promotion> promotionsOfProf = new ArrayList<Promotion>();
	
	/**
	 * Constructeur de professeur
	 * @param nom
	 * @param prenom
	 * @since 1.2
	 */
	public Professeur(String nom, String prenom, Promotion promotion) {
		super(nom, prenom);
		promotionsOfProf.add(promotion);
	}	
	
	/**
	 * Si un prof prof corrige plusieurs promotions, on peut l'ajouter
	 * @param promotion
	 * @since 1.2
	 */
	public void addPromotionToProf(Promotion promotion) {
		promotionsOfProf.add(promotion);
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
