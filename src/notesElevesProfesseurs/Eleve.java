package notesElevesProfesseurs;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author SERHIR, ZARGA
 * @version 1.2
 * 
 * pivot table (tableau croisé dynamique) ?
 */
public class Eleve extends Personne {
	
	/**VARIABLE DE CLASSE qui s'inscremente a chaque creation d'eleve, pour connaitre le nombre d'eleve */
	static private int registre = 1;
	
	/**CONSTANTE fixant le nombre maxiaml d'evaluation possible**/
	final int NB_EVALUATIONS = 10; 

	/**ATTRIBUTS*/
	private int numIdentifiant;
	private Date dateNaissance;
	private ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();
	private Promotion promotion;

	/**CONSTRUCTEURS*/
	/** 
	 * @deprecated Utiliser le dernier constructeur Eleve
	 * @since 1.0
	 */
	public Eleve() {
		super();
	}
	
	/** 
	 * @deprecated Utiliser le dernier constructeur Eleve
	 * @since 1.0
	 */
	public Eleve(String nom, String prenom) {
		super(nom, prenom);
		this.numIdentifiant = registre;
		registre++;
	}
	
	/** 
	 * @deprecated Utiliser le dernier constructeur Eleve
	 * @since 1.0
	 */
	public Eleve(String nom, String prenom, int numIdentifiant) {
		super(nom, prenom);
		this.numIdentifiant = numIdentifiant;
		registre++;
	}
	
	/**
	 * Contructeur Eleve
	 * Chaque eleve un un ID different ex: 20160251 (9999 eleve max par promo)
	 * @param nom
	 * @param prenom
	 * @param numIdentifiant
	 * @param promotion
	 * @deprecated Utiliser le dernier constructeur à 5 parametres
	 * @since 1.1
	 */
	public Eleve(String nom, String prenom, int numIdentifiant, Promotion promotion) {
		super(nom, prenom);
		this.numIdentifiant = numIdentifiant;
		this.promotion = promotion;
		registre++;
	}
	
	/**
	 * Constructeur eleve tel demandé à la question 4
	 * Chaque identifiant est unique, pour le calculer : variable de classe
	 * qui s'increment à chaque creation d'eleve, puis on concatene avec la date de creation
	 * (date de l'inscription) pour obtenir un id sous la forme : 20160251
	 * --> penser à verifier que ce maximum n'est pas atteint par promo ?
	 * @param nom
	 * @param prenom
	 * @param jour
	 * @param mois
	 * @param annee
	 * 
	 * @since 1.2
	 */
	public Eleve(String nom, String prenom, int jour, int mois, int annee) {
		super(nom, prenom);
		this.dateNaissance = new Date(jour, mois, annee);
		this.numIdentifiant = createID();
		registre++;
	}
	
	/**
	 * Permet de creer un ID unique par eleve
	 * chaque ID est composé de la date d'inscription
	 * + un numero unique (registre qui s'increment à chaque creation)
	 * @return numIdentifiant unique
	 * @throw NumberFormatException s'il n'arrive pas a parser un int en string
	 * @since 1.2
	 */
	private int createID() {
		/**On recupere l'annee d'inscription (annee en cours)*/
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		
		/** Notre registre doit etre sous la forme 0251 par exemple
		 * pour que notre identifiant soit toujours noté en 8 chiffres */
		DecimalFormat df = new DecimalFormat("0000");
		String numRegistre = df.format(Eleve.registre);
		
		/** On concatene notre annee et notre registre */
		String idString = Integer.toString(year) + numRegistre;
		int numIdentifiant = 0;
		
		try{
			numIdentifiant = Integer.parseInt(idString);
	    }
	    catch (NumberFormatException nfe){
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	      System.out.println("ERROR: innatendu lors de la creation d'un ID");
	    }
		
		return numIdentifiant;
	}
		
	/** GETTERS */
	public int getNumIdentifiant() {
		return numIdentifiant;
	}
	
	/**Utile ?*/
	public Date getDateNaissance() {
		return dateNaissance;
	}	

	/**Utile?*/
	public ArrayList<Evaluation> getEvaluations() {
		return evaluations;
	}
	/** End Getters*/
	
	/**
	 * Methode toString
	 * @return toutes les informations d'un eleve
	 * @since 1.2
	 */
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") " 
		+ "id : " + this.getNumIdentifiant()
		+"\nNotes : " + getMatieresAndNotes()
		+"\nMoyenne : " + this.moyenne()
		+"\nMediane : " + this.mediane()
		+"\nCorrecteur(s) : " + getCorrecteurs()
		//+"\nPromotion : " + this.promotion.getNom()
		;
	}

	/**
	 * Moyenne des notes d'un eleve
	 * 
	 * @return la moyenne calculee de l'eleve
	 * @throw IllegalStateException si l'eleve n'a aucune note
	 * @since 1.1
	 */
	public double moyenne() {
		double moyenne = 0;
		double total = 0;
		System.out.println(evaluations.size());

		try {
				for (Evaluation evaluation : evaluations) {
				    total += evaluation.getNote();
				}
				moyenne = total / evaluations.size();
			
		}catch(IllegalStateException e) {
			/** Apres test, lexeption n'apparait pas... : pas la bonne exception */
			System.out.println(this.toString() + " n'a pas de note");
		}
		
		/**Arrondir moyenne à 2 chiffres après la virgule*/
		double moy = (double) Math.round(moyenne * 100) / 100;
		return moy;
	}
	
	/**
	 * Mediane de l'eleve
	 * 
	 * @return la mediane de ses notes
	 * @throw IllegalStateException s'il na pas de notes
	 * @since 1.2
	 */
	public double mediane() {
		double mediane = 0;
				
		try {
			if(evaluations.size() > 0) {
				if(evaluations.size() %2 == 0) 
				{
					int milieu = (evaluations.size()/2);
					System.out.println(milieu);
					/**Notre arraylist debute a 0 et non pas a 1
					 * On soustrait alors 1 aux 2 operations suivantes */
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
			/** revoir lexception*/
			System.out.println(this.toString() + " n'a pas de note");
		}
		return mediane;
	}
	
	/**
	 * @param Une evaluation
	 * @throws IllegalStateException si il deja enregistre ses 10 eval
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