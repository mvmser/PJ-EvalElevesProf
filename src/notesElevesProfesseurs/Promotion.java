package notesElevesProfesseurs;

import java.util.ArrayList;

/**
 * @author SERHIR, ZARGA
 * @version 1.0
 * + histoire de mutateur pour get eleves 
 */
public class Promotion {
	
	/**Attributs*/
	private String nom;
	private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
	
	/**
	 * Constructeur d'une promotion
	 * @param nom
	 * @since 1.0
	 */
	public Promotion(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Permet de connaitre le nom de la promotion
	 * @return le nom de la promotion
	 * @since 1.0
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Permet de modifier le nom de la promotion
	 * @param nom
	 * @since 1.0
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * un accesseur en lecture getEleves. Justifier sa signature en commentaires dans le
	 * code. Attention � ne pas violer le principe d�encapsulation : � justifier
	 * @since 1.0
	 */
	public ArrayList<Eleve> getEleves() {
		return eleves;
	}
	
	/**
	 * Permet d'ajouter un eleve � la promo
	 * @param eleve
	 * @since 1.0
	 */
	public void setEleves(Eleve eleve) {
		eleves.add(eleve);
	}

	/**
	 * Permet de savoir si un eleve fait parti de la promotion
	 * @param numId
	 * @return L'eleve recherch�, si pas trouv� retourne null
	 * @since 1.0
	 */
	public Eleve rechercher(int numId) {
		for(Eleve eleve: this.eleves) {
			if(eleve.getNumIdentifiant() == numId)
				return eleve;
		}	
		return null;
	}
}
