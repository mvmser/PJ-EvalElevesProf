package notesElevesProfesseurs;

import java.util.ArrayList;

public class Evaluation {
	
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
		return "(" + eleveCorrige.toString() + professeurCorrecteur.toString() 
		+ this.matiere + this.note + ")";
	}

}
