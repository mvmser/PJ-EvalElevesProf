package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.2
 *
 */
public class Professeur extends Personne {

	/** Un prof peut intervenir dans une ou plusieurs promotions
	 * ces promotion sont alors contenu dans une list*/
	List<Promotion> promotionsOfProf = new ArrayList<Promotion>();
	
	/**
	 * Constructeur de professeur sans promotion
	 * Il faudra utiliser la methode addPromotionToProf
	 * @param nom
	 * @param prenom
	 * @since 1.2
	 */
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}	
	
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
	 * Si un prof prof corrige une ou plusieurs promotions, on peut l'ajouter
	 * @param promotion
	 * @since 1.2
	 */
	public void addPromotionToProf(Promotion promotion) {
		promotionsOfProf.add(promotion);
	}
	
	/**
	 * Permet de retrouver un eleve s'il existe
	 * @param numId
	 * @return l'eleve recherché sinon null
	 * @since 1.2
	 */
	public Eleve rechercheEleve(int numId) {
		/** On va chercher l'eleve dans les promotions ou le professeur intervient*/
		for(Promotion promo : promotionsOfProf) {
			Eleve eleve = promo.rechercher(numId);
			if(eleve != null) return eleve;
		}
		return null;
	}
	
	/**
	 * Permet de retrouver un eleve s'il existe DANS une promotion donnee
	 * @param numId
	 * @return l'eleve recherché sinon null
	 * @since 1.2
	 */
	public Eleve rechercheEleve(int numId, Promotion promotion) {
			Eleve eleve = promotion.rechercher(numId);
			if(eleve != null) return eleve;
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
	public void setNote(Promotion promotion, int numId, int note, int indice) {
		try {
			Eleve eleve = rechercheEleve(numId, promotion);
			//Si la note d'indice i existe alors elle est modifier

			//Object[] notesEleve = eleve.getNotes().toArray();
			

			
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
