package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.List;

public class Eleve extends Personne {
	
	//---CONSTANTE---
	final int NB_EVALUATIONS = 10; 

	
	//---ATTRIBUTS---
	static private int numIdentifiant;
	private Date dateNaissance;
	private Evaluation evaluation;


	//---CONSTRUCTEURS---
	public Eleve(String nom, String prenom, int numIdentifiant) {
		super(nom, prenom);
		this.numIdentifiant = numIdentifiant;
	}
	public Eleve() {
		super();
	}
	
	
	//---ACCESSEURS : Getteurs--- 
	public int getNumIdentifiant() {
		return numIdentifiant;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
//	public Evaluation getEval(){
//		return evaluation;
//	}
	
//	public double getMoyenneEval(){
//		return moyenneEval;
//	}
//	public double getMedianeEval(){
//		return medianeEval;
//	}
	

	
	public double moyenne() {
		double moyenne = 0;
		double total = 0;
		Eleve eleve = new Eleve();
	
		System.out.println("Calcul moyenne de " + eleve.toString());
		
		try {
			if(evaluation.getNote().size() > 0) {
				for (Double note : evaluation.getNote()) {
				    total += note;
				}
				moyenne = total / evaluation.getNote().size();
			}
		}catch(IllegalStateException e) {
			System.out.println(eleve.toString() + " n'a pas de note");
		
		}
		
		return moyenne;
	}
	
	
	//---TOSTRING---
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") ";
	}
	
}
