 package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import readCSV.ReadCSV;

/**
 * @version 1.1
 * + histoire de mutateur pour get eleves 
 */

public class Promotion {
	/** Permet de connaitre les promotions existantes*/
	private static ArrayList<Promotion> promotions = new ArrayList<Promotion>();
	
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
		promotions.add(this);
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
	
	
	public ArrayList<Promotion> getPromotions() {
		return promotions;
	}

	/**
	 * un accesseur en lecture getEleves. Justifier sa signature en commentaires dans le
	 * code. Attention ï¿½ ne pas violer le principe dï¿½encapsulation : ï¿½ justifier
	 * @since 1.0
	 */
	public ArrayList<Eleve> getEleves() {
		return eleves;
	}
	
	/**
	 * Permet d'ajouter un eleve ï¿½ la promo
	 * @param eleve
	 * @since 1.0
	 */
	public void addEleve(Eleve eleve) {
		eleves.add(eleve);
	}

	/**
	 * Permet de savoir si un eleve fait parti de la promotion
	 * @param numId
	 * @return L'eleve recherchï¿½, si pas trouvï¿½ retourne null
	 * @since 1.0
	 */
	public Eleve rechercher(int numId) {
		for(Eleve eleve: eleves) {
			if(eleve.getNumIdentifiant() == numId) {
				System.out.println(eleve);
				return eleve;
			}	
		}	
		System.out.println("Pas d'eleve trouvé avec cet identifiant");
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
		ArrayList<Eleve> eleveOrdreDecroissantMoyenne = eleves;
		
		Collections.sort(eleveOrdreDecroissantMoyenne, Eleve.MOYENNE_REVERSE_ORDER);

		return eleveOrdreDecroissantMoyenne;
	}
	
	/**
	 * Permet de classer par ordre croissant en fonction des mediane des eleves
	 * @return Collection d'eleves
	 * @since 1.1
	 */
	public ArrayList<Eleve> classementOrdreCroissantMediane(){
		ArrayList<Eleve> eleveOrdreCroissantMediane = eleves;
		
		Collections.sort(eleveOrdreCroissantMediane, Eleve.MEDIANE_ORDER);

		return eleveOrdreCroissantMediane;
	}
	
	/**
	 * Permet de classer par ordre decroissant en fonction des medianes des eleves
	 * @return Collection d'eleves
	 * @since 1.1
	 */
	public ArrayList<Eleve> classementOrdreDecroissantMediane(){
		ArrayList<Eleve> eleveOrdreDecroissantMediane = eleves;
		
		Collections.sort(eleveOrdreDecroissantMediane, Eleve.MEDIANE_REVERSE_ORDER);

		return eleveOrdreDecroissantMediane;
	}
}
