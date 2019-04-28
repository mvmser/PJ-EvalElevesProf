 package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @version 1.2
 * @author SERHIR
 * @author ZARGA
 * Une promotion
 */

public class Promotion {
	/** Permet de connaitre les promotions existantes*/
	private static ArrayList<Promotion> promotions = new ArrayList<Promotion>();
	
	/**Attributs*/
	private String nom;
	private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
	private ArrayList<Professeur> professeurs = new ArrayList<Professeur>();
	
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
	
	/**
	 * Permet de connaitre toutes les promotions existantes
	 * @return
	 */
	public static ArrayList<Promotion> getPromotions() {
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
	 * Permet de connaitres les profs qui interviennent dans la promo
	 * @return
	 */
	public ArrayList<Professeur> getProfesseurs() {
		return professeurs;
	}

	/**
	 * Permet d'ajouter un intervenant à la promo
	 * @param professeur
	 */
	public void addProfesseur(Professeur professeur) {
		professeurs.add(professeur);
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
				//System.out.println(eleve);
				return eleve;
			}	
		}	
		System.out.println("Pas d'eleve trouve avec cet identifiant");
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
	
	/**
	 * Permet de connaitre la moyenne des moyennes des eleves d'une promotion
	 * @return la moyenne generale de la promotion
	 * @since 1.2
	 */
	public double moyenne() {
		double moyenne = 0;
		double total = 0;

		for (Eleve eleve : eleves) {
		    total += eleve.moyenne();
		}
		moyenne = total / eleves.size();

		return (double) Math.round(moyenne * 100) / 100;
	}
	
	/**
	 * Permet de connaitre la moyenne de la promotion sur une seule matiere donnee en parametre
	 * @param matiere
	 * @return la moyenne de la promotion pour une matiere
	 */
	public double moyenneParMatiere(String matiere) {
		double moyenne = 0;
		double total = 0;
		int nbNotes = 0;

		
		/** Une moyenne sur tous les eleves de la promo, on va recuperer les evaluations
		 * de chacun et ensuite comparer si c la matiere dont nous souhaitons connaitre
		 * la moyenne*/
		for (Eleve eleve : eleves) {
			for (Evaluation evaluation : eleve.getEvaluations()) {
				if(evaluation.getMatiere() == matiere){
					total += evaluation.getNote();
					nbNotes++;
				}
			}
		}
		if(nbNotes != 0)
			moyenne = total / nbNotes;
		else 
			moyenne = 0;

		return (double) Math.round(moyenne * 100) / 100;
	}
	
	/**
	 * Permet de connaitre la mediane des medianes des eleves de la promotion
	 * @return la mediane de la promotion
	 */
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
	
	/**
	 * Permet de connaitre la mediane de la promotion par matiere
	 * on enregistre tout dabord les notes de la matiere voulu
	 * @return la mediane de la promotion pour une matiere
	 * @param matiere dont ont veut la mediane
	 */
	public double medianeParMatiere(String matiere) {
		double mediane = 0;
		
		ArrayList<Double> notesMatiere = new ArrayList<Double>();
		
		for (Eleve eleve : eleves) {
			for (Evaluation evaluation : eleve.getEvaluations()) {
				if(evaluation.getMatiere() == matiere){
					notesMatiere.add(evaluation.getNote());
				}
			}
		}
		
		try {
			if(notesMatiere.size() > 0) {
				if(notesMatiere.size() %2 == 0)
				{
					int milieu = (notesMatiere.size()/2);

					double termeMilieu1 = notesMatiere.get(milieu - 1);
					double termeMilieu2 = notesMatiere.get((milieu + 1) - 1);
					mediane = (termeMilieu1 + termeMilieu2)/2;
				}
				else {
					int milieu = (notesMatiere.size()/2);
					mediane = notesMatiere.get(milieu);
				}
			}
		}catch(IllegalStateException e) {
			System.out.println(this.toString() + " n'a pas de note");
		}
		
		return (double) Math.round(mediane * 100) / 100;
	}
	
	/**
     * Permet de remplir les evaluations des eleves avec des notes aleatoires
     * a mettre dans promotion
     * @return vrai si on a rempli les eval faux sinon
     */
    public boolean remplirEvalEleves() {
    	//System.out.println(professeurs.size());
    	if(professeurs.size() > 9) {
    		for (Eleve eleve : eleves) {
    			eleve.setEvaluation(new Evaluation("Mathematiques", eleve.randomMark() , eleve, professeurs.get(0)));
    			eleve.setEvaluation(new Evaluation("Physique", eleve.randomMark(), eleve, professeurs.get(1)));
    			eleve.setEvaluation(new Evaluation("Anglais", eleve.randomMark(), eleve, professeurs.get(2)));
    			eleve.setEvaluation(new Evaluation("Finance", eleve.randomMark(), eleve, professeurs.get(3)));
    			eleve.setEvaluation(new Evaluation("Informatique", eleve.randomMark(), eleve, professeurs.get(4)));
    			eleve.setEvaluation(new Evaluation("Algorithmie", eleve.randomMark(), eleve, professeurs.get(5)));
    			eleve.setEvaluation(new Evaluation("Communication", eleve.randomMark(), eleve, professeurs.get(6)));
    			eleve.setEvaluation(new Evaluation("LV2", eleve.randomMark(), eleve, professeurs.get(7)));
    			eleve.setEvaluation(new Evaluation("Marketing", eleve.randomMark(), eleve, professeurs.get(8)));
    			eleve.setEvaluation(new Evaluation("Management", eleve.randomMark(), eleve, professeurs.get(9)));
    		}
    		return true;
    	}
    	return false;    	
    }
    
    /**
     * Pour afficher le nom de la promotion
     * @return Promotion: nomPromo
     */
    @Override
    public String toString() {
		return "Promotion: " + nom;
    }
}
