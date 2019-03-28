package notesElevesProfesseurs;

import java.util.*;

/*
 * @author SERHIR ZARGA
 * @version 1.0
 * 
 * Manque: promotion, chaque eleve connait sa promotion.
 */
public class Eleve extends Personne {
	
	//---Variable de classe qui s'inscremente a chaque creation d'eleve---\\
	static private int registre = 0;
	
	//---CONSTANTE---\\
	final int NB_EVALUATIONS = 10; 

	//---ATTRIBUTS---\\
	private int numIdentifiant;
	private Date dateNaissance;
	private ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();
	//private Promotion promotion;

	//---CONSTRUCTEURS---\\
	public Eleve(String nom, String prenom) {
		super(nom, prenom);
		this.numIdentifiant = registre;
		registre++;
	}
	
	//---CONSTRUCTEURS---
	public Eleve(String nom, String prenom, int numIdentifiant) {
		super(nom, prenom);
		this.numIdentifiant = numIdentifiant;
		registre++;
	}
	
	public Eleve() {
		super();
	}
	
	
	//---ACCESSEURS : Getters--- 
	public int getNumIdentifiant() {
		return numIdentifiant;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}	

	public ArrayList<Evaluation> getEvaluations() {
		return evaluations;
	}
	

	/*
	 * @param Une evaluation
	 * 
	 * @throws IllegalStateException si il deja enregistre ses 10 eval
	 * 
	 */
	public void setEvaluation(Evaluation evaluation) {
		try {
			if(evaluations.size() < NB_EVALUATIONS) {
				if(evaluation.getEleveCorrige() == this)
					this.evaluations.add(evaluation);
			}
		}catch(IllegalStateException e) {
			System.out.println(this.toString() + " a deja 10 evaluations!");
		}
	}

	//---MOYENNE---\\
	/*
	 * @return la moyenne calculee de l'eleve
	 * 
	 * @throw IllegalStateException si l'eleve n'a aucune note
	 */
	public double moyenne() {
		double moyenne = 0;
		double total = 0;
	
		//System.out.println("Calcul moyenne de " +  this.getPrenom() + " "+ this.getNom());
		
		try {
			if(evaluations.size() > 0) {
				for (Evaluation evaluation : evaluations) {
				    total += evaluation.getNote();
				}
				moyenne = total / evaluations.size();
			}
		}catch(IllegalStateException e) {
			System.out.println(this.toString() + " n'a pas de note");
		}
		
		//Arrondir moyenne, DecimalFormat ?
		return moyenne;
	}
	
	//---MEDIANE---\\
	/*
	 * @return la mediane de ses notes
	 * @throw IllegalStateException s'il na pas de notes
	 * fausse
	 */
	public double mediane() {
		double mediane = 0;
		Eleve eleve = new Eleve();
		
		//System.out.println("Calcul mediane de " +  eleve.getPrenom() + " "+ eleve.getNom());
		
		try {
			if(evaluations.size() > 0) {
				//Collections.sort(evaluations); //trier les notes : deja trié dans getMatieresAndNotes
				//System.out.println("evals: "+ evaluations);

					if(evaluations.size() %2 == 0) 
					{
						int milieu = (evaluations.size()/2);
						System.out.println(milieu);
						//Notre arraylist debute a 0 et non pas a 1
						//On soustrait alors 1 aux 2 operations suivantes
						double termeMilieu1 = evaluations.get(milieu - 1).getNote();
						double termeMilieu2 = evaluations.get((milieu + 1) - 1).getNote();
						mediane = (termeMilieu1 + termeMilieu2)/2;
					}
					else {
						int milieu = (evaluations.size()/2);
						mediane = evaluations.get(milieu).getNote();
					}
			}
		}catch(IllegalStateException e) {
			System.out.println(eleve.toString() + " n'a pas de note");
		}
		return mediane;
	}
	
	
	//---LISTE CORRECTEUR---\\
	public Set<Professeur> getCorrecteurs() {
		HashSet<Professeur> correcteurs = new HashSet<Professeur>();
			
		for (Evaluation evaluation : evaluations) {
			Professeur correcteur = evaluation.getProfesseurCorrecteur();
			correcteurs.add(correcteur);
		}
		
		return correcteurs;
	}
	
	//---LISTE MATIERE PAR EVALUATION---\\
	/*
	 * 
	 * @return les matieres d'une evaluation
	 */
	public HashSet<String> getMatieres() {
		HashSet<String> matieres = new HashSet<String>();
			
		for (Evaluation evaluation : evaluations) {
			String matiere = evaluation.getMatiere();
			matieres.add(matiere);
		}
		return matieres;
	}
	
	//---LISTE NOTES PAR EVALUATION---\\
	/*
	 * 
	 * @return les notes d'une evaluation
	 */
	public HashSet<Double> getNotes() {
		HashSet<Double> notes = new HashSet<Double>();
			
		for (Evaluation evaluation : evaluations) {
			Double note = evaluation.getNote();
			notes.add(note);
		}
		return notes;
	}
	/*
	 * permet de retouver les matiere et notes de l'eleve
	 * sous la forme : (ex) maths 20.0 physique 11.0 ...
	 * 
	 * @param
	 * @return String avec toutes les notes par matiere
	 */
	public String getMatieresAndNotes(){
		Collections.sort(evaluations); //trier les notes

		String MatieresAndNotes = "";
		
		for(Evaluation evaluation: evaluations) {
			MatieresAndNotes += evaluation.getMatiere();
			MatieresAndNotes += " ";
			MatieresAndNotes += evaluation.getNote();
			MatieresAndNotes += " ";
		}
		return MatieresAndNotes;
	}
	
	//---TOSTRING---\\
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") " 
		+ "id : " + this.getNumIdentifiant()
		+"\nNotes : " + getMatieresAndNotes()
		+"\nMoyenne : " + this.moyenne()
		+"\nMediane : " + this.mediane()
		+"\nCorrecteur(s) : " + getCorrecteurs()
		+"\nPromotion : " //+ this.promotion.getNom()
		;
	}
	
	//---HASHCODE---
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NB_EVALUATIONS;
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((evaluations == null) ? 0 : evaluations.hashCode());
		return result;
	}
	
	//---EQUALS---
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleve other = (Eleve) obj;
		if (NB_EVALUATIONS != other.NB_EVALUATIONS)
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (evaluations == null) {
			if (other.evaluations != null)
				return false;
		} else if (!evaluations.equals(other.evaluations))
			return false;
		return true;
	}
}