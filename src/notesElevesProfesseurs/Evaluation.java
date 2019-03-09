package notesElevesProfesseurs;

public class Evaluation implements Comparable<Evaluation>{
	
	//ATTRIBUTS
	private String matiere; 
	//private ArrayList<Double> notes = new ArrayList<>();
	private double note;
	private Eleve eleveCorrige;
	//private ArrayList<Professeur> professeursCorrecteurs = new ArrayList<>();
	private Professeur professeurCorrecteur;

	
	//---CONSTRUCTEUR
	public Evaluation(String matiere, double note, Eleve eleveCorrige, Professeur professeurCorrecteur ) {
		this.matiere = matiere;
		this.note = note; 
		this.eleveCorrige = eleveCorrige;
		this.professeurCorrecteur = professeurCorrecteur;
	}
	
	/*
	 * a verifier
	 * 
	 */
	public int compareTo(Evaluation evaluation){
		if(evaluation.note < this.note)
	          return -1;
	    else if(this.note < evaluation.note)
	          return 1;
	    return 0;
	}
	
	
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

	@Override
	public String toString() {
		return "((" + eleveCorrige.getPrenom() + ", "+ eleveCorrige.getNom() +") " 
				+ professeurCorrecteur
				+ this.matiere + " " + this.note + ")\n";
	}

}
