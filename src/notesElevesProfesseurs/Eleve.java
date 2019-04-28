package notesElevesProfesseurs;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Classe eleve
 * @version 1.4
 * @author SERHIR
 * @author ZARGA
 */
public class Eleve extends Personne implements Comparable<Eleve>{

	/**VARIABLE DE CLASSE qui s'inscremente a chaque creation d'eleve, pour connaitre le nombre d'eleve */
	static private int registre = 1;

	/**CONSTANTE fixant le nombre maxiaml d'evaluation possible**/
	final int NB_EVALUATIONS = 10;

	/**ATTRIBUTS*/
	private int numIdentifiant;
	private Date dateNaissance;
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

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
	 * @deprecated Utiliser le dernier constructeur ï¿½ 5 parametres
	 * @since 1.1
	 */
	public Eleve(String nom, String prenom, int numIdentifiant, Promotion promotion) {
		super(nom, prenom);
		this.numIdentifiant = numIdentifiant;
		//this.promotion = promotion;
		registre++;
	}

	/**
	 * Constructeur eleve tel demandï¿½ ï¿½ la question 4
	 * Chaque identifiant est unique, pour le calculer : variable de classe
	 * qui s'increment ï¿½ chaque creation d'eleve, puis on concatene avec la date de creation
	 * (date de l'inscription) pour obtenir un id sous la forme : 20160251
	 * @param nom
	 * @param prenom
	 * @param jour
	 * @param mois
	 * @param annee
	 *
	 * @since 1.4
	 */
	public Eleve(String nom, String prenom, int jour, int mois, int annee) {
		super(nom, prenom);
		this.dateNaissance = new Date(jour, mois, annee);

		/** Il est possible de creer 9999 id differents,
		 * 0000 indique que l'eleve n'est pas censï¿½ exister*/
		if(registre <= 9999) {
			this.numIdentifiant = createID();
		} else { this.numIdentifiant = 0000;}

		/** On ajoute l'eleve ï¿½ sa promo */
		if(!Promotion.getPromotions().isEmpty()) {
			promotion = Promotion.getPromotions().get(0);
			promotion.addEleve(this);
		}
		
		registre++;
	}


	/**
	 * Permet de creer un ID unique par eleve
	 * chaque ID est composï¿½ de la date d'inscription
	 * + un numero unique (registre qui s'increment ï¿½ chaque creation)
	 * @return numIdentifiant unique
	 * @throw NumberFormatException s'il n'arrive pas a parser un int en string
	 * @since 1.2
	 */
	private int createID() {
		/**On recupere l'annee d'inscription (annee en cours)*/
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);

		/** Notre registre doit etre sous la forme 0251 par exemple
		 * pour que notre identifiant soit toujours notï¿½ en 8 chiffres */
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
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	/**
	 * Permet de connaitre la promotion de l'eleve
	 * @return la promotion de l'eleve
	 * @since 1.4
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * @param Une evaluation
	 *
	 * @throws IllegalStateException si il deja enregistre ses 10 eval
	 *
	 * Par defaut, la promotion est la promo 2021
	 * si l'eleve appartient a une autre promo, on modifie alors sa promo
	 * @param promotion
	 * @since 1.4
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
		promotion.addEleve(this);
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
		+"\nPromotion : " + this.promotion.getNom()
		+ "\n\n"
		;
	}

	/**
	 * Moyenne des notes d'un eleve
	 *
	 * need v1.3
	 * @return la moyenne calculee de l'eleve
	 * @throw IllegalStateException si l'eleve n'a aucune note
	 * @since 1.1
	 */
	public double moyenne() {
		double moyenne = 0;
		double total = 0;

		try {
				for (Evaluation evaluation : evaluations) {
				    total += evaluation.getNote();
				}
				moyenne = total / evaluations.size();

		}catch(IllegalStateException e) {
			/** Apres test, lexeption n'apparait pas... : pas la bonne exception */
			System.out.println(this.toString() + " n'a pas de note");
		}

		/**Arrondir moyenne ï¿½ 2 chiffres aprï¿½s la virgule*/
		double moy = (double) Math.round(moyenne * 100) / 100;
		return moy;
	}

	/**
	 * Mediane de l'eleve
	 *
	 * need v1.3
	 * @return la mediane de ses notes
	 * @throw IllegalStateException s'il na pas de notes
	 * @since 1.2
	 */
	public double mediane() {
		double mediane = 0;

		try {
			if(evaluations.size() > 0) {

				Collections.sort(evaluations); //trier les notes : deja triï¿½ dans getMatieresAndNotes
				//System.out.println("evals: "+ evaluations);

					if(evaluations.size() %2 == 0)
					{
						int milieu = (evaluations.size()/2);
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

				if(evaluations.size() %2 == 0)
				{
					int milieu = (evaluations.size()/2);
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
		return (double) Math.round(mediane * 100) / 100;
	}

	/**
	 * Permet de modifier une evaluation
	 * attention: verifier si cette methode doit etre dans cette classe (besoin dans classe prof)
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

	/**
	 * Permet de connaitre tous les profs
	 * ayant corrigï¿½s cet eleve
	 * @return Collection de professeurs
	 */
	public Set<Professeur> getCorrecteurs() {
		HashSet<Professeur> correcteurs = new HashSet<Professeur>();

		for (Evaluation evaluation : evaluations) {
			Professeur correcteur = evaluation.getProfesseurCorrecteur();
			correcteurs.add(correcteur);
		}

		return correcteurs;
	}

	/**
	 * LISTE MATIERE PAR EVALUATION
	 * @return les matieres d'une evaluation
	 * @since 1.0
	 */
	public HashSet<String> getMatieres() {
		HashSet<String> matieres = new HashSet<String>();

		for (Evaluation evaluation : evaluations) {
			String matiere = evaluation.getMatiere();
			matieres.add(matiere);
		}
		return matieres;
	}

	/**
	 * LISTE NOTES PAR EVALUATION
	 * @return les notes d'une evaluation
	 * @since 1.0
	 */
	public HashSet<Double> getNotes() {
		HashSet<Double> notes = new HashSet<Double>();

		for (Evaluation evaluation : evaluations) {
			Double note = evaluation.getNote();
			notes.add(note);
		}
		return notes;
	}

	/**
	 * Permet de retouver les matiere et notes de l'eleve
	 * sous la forme : (ex) maths 20.0 physique 11.0 ...
	 *
	 * @return String avec toutes les notes par matiere
	 * @since 1.0
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

	/**
	 * Permet d'avoir une note aléatoire
	 * 1 chance sur deux davoir une note comprise entre 8 et 16
	 * @return
	 */
	public double randomMark() {
		Random random = new Random();
		if(random.nextBoolean())
			return (double) Math.round( (random.nextDouble() * 20) * 100) / 100;
		else
			return (double) Math.round( (8 + random.nextInt(16 - 8)) * 100) / 100;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NB_EVALUATIONS;
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((evaluations == null) ? 0 : evaluations.hashCode());
		result = prime * result + numIdentifiant;
		result = prime * result + ((promotion == null) ? 0 : promotion.hashCode());
		return result;
	}

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
		if (numIdentifiant != other.numIdentifiant)
			return false;
		if (promotion == null) {
			if (other.promotion != null)
				return false;
		} else if (!promotion.equals(other.promotion))
			return false;
		return true;
	}
	
	

	/**
	 * Override implements methode
	 * Permet de comparer deux eleves par rapport ï¿½ leur moyenne
	 * @param eleve
	 * @return entier 0 pour egalitï¿½, 1 si cet eleve a une meilleure moyenne que l'eleve en param ou -1
	 * @since 1.3
	 */
	@Override
	public int compareTo(Eleve eleve) {
		if(eleve.moyenne() < this.moyenne())
	          return -1;
	    else if(this.moyenne() < eleve.moyenne())
	          return 1;
	    return 0;
	}

	static final Comparator<Eleve> MOYENNE_ORDER = new Comparator<Eleve> (){
		@Override
		public int compare(Eleve eleve1, Eleve eleve2){
			if(eleve1.moyenne() < eleve2.moyenne())
		          return -1;
		    else if(eleve2.moyenne() < eleve1.moyenne())
		          return 1;
		    return 0;
		}
	};

	static final Comparator<Eleve> MEDIANE_ORDER = new Comparator<Eleve> (){
		@Override
		public int compare(Eleve eleve1, Eleve eleve2){
			if(eleve1.mediane() < eleve2.mediane())
		          return -1;
		    else if(eleve2.mediane() < eleve1.mediane())
		          return 1;
		    return 0;
		}
	};

	static final Comparator<Eleve> MOYENNE_REVERSE_ORDER = new Comparator<Eleve> (){
		@Override
		public int compare(Eleve eleve1, Eleve eleve2){
			if(eleve2.moyenne() < eleve1.moyenne())
		          return -1;
		    else if(eleve1.moyenne() < eleve2.moyenne())
		          return 1;
		    return 0;
		}
	};

	static final Comparator<Eleve> MEDIANE_REVERSE_ORDER = new Comparator<Eleve> (){
		@Override
		public int compare(Eleve eleve1, Eleve eleve2){
			if(eleve2.mediane() < eleve1.mediane())
		          return -1;
		    else if(eleve1.mediane() < eleve2.mediane())
		          return 1;
		    return 0;
		}
	};


}
