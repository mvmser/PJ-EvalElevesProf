package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author SERHIR, ZARGA
 * @version 1.1
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
	 * code. Attention à ne pas violer le principe d’encapsulation : à justifier
	 * @since 1.0
	 */
	public ArrayList<Eleve> getEleves() {
		return eleves;
	}
	
	/**
	 * Permet d'ajouter un eleve à la promo
	 * @param eleve
	 * @since 1.0
	 */
	public void setEleves(Eleve eleve) {
		eleves.add(eleve);
	}

	/**
	 * Permet de savoir si un eleve fait parti de la promotion
	 * @param numId
	 * @return L'eleve recherché, si pas trouvé retourne null
	 * @since 1.0
	 */
	public Eleve rechercher(int numId) {
		for(Eleve eleve: this.eleves) {
			if(eleve.getNumIdentifiant() == numId)
				return eleve;
		}	
		return null;
	}
	
	/**
	 * Permet de classer par ordre croissant en fonction des moyennes des eleves
	 * @return Collection d'eleves
	 * @since 1.1
	 */
	public ArrayList<Eleve> classementOrdreCroissantMoyenne(){
		ArrayList<Eleve> eleveOrdreCroissantMoyenne = eleves;

		Collections.sort(eleveOrdreCroissantMoyenne, Eleve.MOYENNE_ORDER);
		
		return eleveOrdreCroissantMoyenne;
	}
	
	/**
	 * Permet de classer par ordre decroissant en fonction des moyennes des eleves
	 * @return Collection d'eleves
	 * @since 1.1
	 */
	public ArrayList<Eleve> classementOrdreDecroissantMoyenne(){
		ArrayList<Eleve> eleveOrdreDecroissantMoyenne = new ArrayList<Eleve>();
		
		Collections.sort(eleveOrdreDecroissantMoyenne, Eleve.MOYENNE_REVERSE_ORDER);

		return eleveOrdreDecroissantMoyenne;
	}
	
	/**
	 * Permet de classer par ordre croissant en fonction des mediane des eleves
	 * @return Collection d'eleves
	 * @since 1.1
	 */
	public ArrayList<Eleve> classementOrdreCroissantMediane(){
		ArrayList<Eleve> eleveOrdreCroissantMediane = new ArrayList<Eleve>();
		
		Collections.sort(eleveOrdreCroissantMediane, Eleve.MEDIANE_ORDER);

		return eleveOrdreCroissantMediane;
	}
	
	/**
	 * Permet de classer par ordre decroissant en fonction des medianes des eleves
	 * @return Collection d'eleves
	 * @since 1.1
	 */
	public ArrayList<Eleve> classementOrdreDecroissantMediane(){
		ArrayList<Eleve> eleveOrdreDecroissantMediane = new ArrayList<Eleve>();
		
		Collections.sort(eleveOrdreDecroissantMediane, Eleve.MEDIANE_REVERSE_ORDER);

		return eleveOrdreDecroissantMediane;
	}
}
