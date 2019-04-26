package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.4
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
	
	public String getNom() {
		return nom;
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
	 * @return l'eleve recherch� sinon null
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
	 * @return l'eleve recherch� sinon null
	 * @since 1.2
	 */
	public static Eleve rechercheEleve(int numId, Promotion promotion) {
			Eleve eleve = promotion.rechercher(numId);
			if(eleve != null) return eleve;
		return null;
	}
	
	/**
	 * Permet de modifier une note si elle existe/ de la creer
	 * @param promo
	 * @param numId
	 * @param note
	 * @param indice
	 * @since 1.4
	 */
	public boolean setNote(Promotion promotion, int numId, int note, int indice) {
		try {
			Eleve eleve = rechercheEleve(numId, promotion);
			if(indice <= eleve.getEvaluations().size() && eleve.getEvaluations() != null) {
				Evaluation eval = eleve.getEvaluations().get(indice);
				eval.setNote(note);
			}else if(indice <= eleve.getEvaluations().size() + 1){
				System.out.println("Pour quelle matiere ?");
				Scanner sc = new Scanner(System.in);
				String matiere = sc.nextLine();
				
				Evaluation newEval = new Evaluation(matiere, note, eleve, this);
				eleve.setEvaluation(newEval);
				sc.close();
			}else {
				System.out.println("Indice incorrect.");
				return false;
			}
		}catch(IllegalStateException e) {
			System.out.println("L'eleve numero: " + numId + " n'existe pas");
			return false;
		}
		return true;
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
