package notesElevesProfesseurs;

/**
 * Classe date avec getters et setters
 * @author SERHIR
 * @author ZARGA
 * @version 1.0
 */
public class Date {
	private int annee;
	private int mois;
	private int jour;
	
	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}
	
	@Override
	public String toString() {
		return this.jour + "/" + this.mois + "/" + this.annee;
	}

}
