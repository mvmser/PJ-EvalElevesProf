 package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @version 1.1
 * 
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
	
	
	public static ArrayList<Promotion> getPromotions() {
		return promotions;
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
	public void addEleve(Eleve eleve) {
		eleves.add(eleve);
	}

	/**
	 * Permet de savoir si un eleve fait parti de la promotion
	 * @param numId
	 * @return L'eleve recherch�, si pas trouv� retourne null
	 * @since 1.0
	 */
	public Eleve rechercher(int numId) {
		for(Eleve eleve: eleves) {
			if(eleve.getNumIdentifiant() == numId) {
				System.out.println(eleve);
				return eleve;
			}	
		}	
		System.out.println("Pas d'eleve trouv� avec cet identifiant");
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
	
	public double moyenne() {
		double moyenne = 0;
		double total = 0;

		for (Eleve eleve : eleves) {
		    total += eleve.moyenne();
		}
		moyenne = total / eleves.size();

		return (double) Math.round(moyenne * 100) / 100;
	}
	
	public double mediane() {
		double mediane = 0;
		ArrayList<Eleve> elevesOrdreCroissantMediane = classementOrdreCroissantMediane();
		
		try {
			if(elevesOrdreCroissantMediane.size() > 0) {
				if(elevesOrdreCroissantMediane.size() %2 == 0)
				{
					int milieu = (elevesOrdreCroissantMediane.size()/2);

					double termeMilieu1 = elevesOrdreCroissantMediane.get(milieu - 1).mediane();
					double termeMilieu2 = elevesOrdreCroissantMediane.get((milieu + 1) - 1).mediane();
					mediane = (termeMilieu1 + termeMilieu2)/2;
				}
				else {
					int milieu = (elevesOrdreCroissantMediane.size()/2);
					mediane = elevesOrdreCroissantMediane.get(milieu).mediane();
				}
			}
		}catch(IllegalStateException e) {
			System.out.println(this.toString() + " n'a pas de note");
		}
		return (double) Math.round(mediane * 100) / 100;
	}
}
