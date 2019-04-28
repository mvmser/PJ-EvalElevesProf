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
	
	/**
	 * Permet de construire une date
	 * @param jour
	 * @param mois
	 * @param annee
	 * @since 1.0
	 */
	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/**
	 * Getter annee
	 * @return une annee
	 * @since 1.0
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * Setter annee
	 * @param annee
	 * @since 1.0
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * Getter Mois
	 * @return un mois
	 * @since 1.0
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * Setter Mois
	 * @param mois
	 * @since 1.0
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * Getter jour
	 * @return le jour
	 * @since 1.0
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * Setter jour
	 * @param jour
	 * @since 1.0
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}
	
	/**
	 * toString, pour afficher dans un sysout
	 * @since 1.0
	 */
	@Override
	public String toString() {
		return this.jour + "/" + this.mois + "/" + this.annee;
	}

}
