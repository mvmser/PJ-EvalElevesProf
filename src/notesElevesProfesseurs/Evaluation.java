package notesElevesProfesseurs;

/**
 * @version 1.0
 */
public class Evaluation implements Comparable<Evaluation>{
	
	/**Attributs*/
	private String matiere; 
	private double note;
	private Eleve eleveCorrige;
	private Professeur professeurCorrecteur;

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

	public void setNote(double note) {
		this.note = note;
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
	
	public int compareTo(Evaluation evaluation){
		if(evaluation.note < this.note)
	          return -1;
	    else if(this.note < evaluation.note)
	          return 1;
	    return 0;
	}

}
