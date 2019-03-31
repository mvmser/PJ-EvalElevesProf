package notesElevesProfesseurs;

/**
 * 
 * @author SERHIR, ZARGA
 * @version 1.0
 */
public class Evaluation implements Comparable<Evaluation>{
	
	/**Attributs*/
	private String matiere; 
	private double note;
	private Eleve eleveCorrige;
	private Professeur professeurCorrecteur;
	//private ArrayList<Professeur> professeursCorrecteurs = new ArrayList<>();
	//private ArrayList<Double> notes = new ArrayList<>();

	/**Constructeurs*/
	public Evaluation(String matiere, double note, Eleve eleveCorrige, Professeur professeurCorrecteur ) {
		this.matiere = matiere;
		this.note = note; 
		this.eleveCorrige = eleveCorrige;
		this.professeurCorrecteur = professeurCorrecteur;
	}
	
	/**Getters */
	public String getMatiere() {
		return matiere;
	}

	public double getNote() {
		return note;
	}

	public Eleve getEleveCorrige() {
		return eleveCorrige;
	}

	public Professeur getProfesseurCorrecteur() {
		return professeurCorrecteur;
	}

	/**
	 * Methode to String
	 * @return toutes les informations d'une evaluation
	 * @since 1.0
	 */
	@Override
	public String toString() {
		return "((" + eleveCorrige.getPrenom() + ", "+ eleveCorrige.getNom() +") " 
				+ professeurCorrecteur
				+ this.matiere + " " + this.note + ")\n";
	}
	
	/*
	 * compareTo
	 * 
	 */
	public int compareTo(Evaluation evaluation){
		if(evaluation.note < this.note)
	          return -1;
	    else if(this.note < evaluation.note)
	          return 1;
	    return 0;
	}

}
