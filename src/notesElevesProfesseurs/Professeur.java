package notesElevesProfesseurs;
im

public class Professeur extends Personne {

	//---CONSTRUCTEURS---
	public Professeur(String nom, String prenom) {
		super(nom, prenom);
	}
	public Professeur() {
		super();
	}
	
	
	public double setNote(Promotion promo, int numId, double note, int indice) {
		//for(Eleve evaluation : evaluations)
		
		return 1.0; 
	}
	
	
	
	//---RECHERCHER ELEVE---\\
	public Eleve rechercheEleve(int numId) {
		Promotion promo = new Promotion(nom);
		Eleve eleve = new Eleve();
		try{
			for(int i = 0; i < promo.getEleves().size(); i++) {
				if(this.eleve.get(i).getNumIdentifiant() == numId) {
					return this.eleve.get(i);
				}
			}	
			
			
			
			
			for(int i = 0; i < promo.getEleves().size(); i++) {
				if(eleve.getNumIdentifiant() == numId) {
					return eleve;
				}
			}	
		}
		catch(IllegalStateException e) {
			System.out.println(promo + " n'existe pas");
		}
		return null;
		
	}

	
	//---TOSTRING---
	@Override
	public String toString() {
		return "(" + this.prenom + ", " + this.nom + ") ";
	}
	
	
}
