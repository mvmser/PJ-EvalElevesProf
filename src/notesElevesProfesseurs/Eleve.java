package notesElevesProfesseurs;

public class Eleve extends Personne {
	
	public Eleve(String nom, String prenom) {
		super(nom, prenom);
	}
	public Eleve() {
		super();
	}
	
	private int NumIdentifiant;
	private Date dateNaissance; 
	
	private Evaluation eval; 
	private double moyenneEval;
	private double medianeEval;
	
	//Accesseur : Getteur 
	public int getNumIdentification() {
		return NumIdentifiant;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public Evaluation getEval(){
		return eval;
	}
	public double getMoyenneEval(){
		return moyenneEval;
	}
	public double getMedianeEval(){
		return medianeEval;
	}
	@Override
	public String toString() {
		return "Eleve [NumIdentifiant=" + NumIdentifiant + ", dateNaissance=" + dateNaissance + ", eval=" + eval
				+ ", moyenneEval=" + moyenneEval + ", medianeEval=" + medianeEval + "]" + "Nom : " + this.nom + "Prenom : " + this.prenom;
	}
	
	
}
