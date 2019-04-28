/**
 * 
 */
package writeCSV;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import readCSV.ReadCSV;

/**
 * @author SERHIR
 * @author ZARGA
 * @version 1.0
 */
public interface WriteCSV{

	/** Attributs */
	public final static String RESOURCES_PATH = "files/";
	public final static String ELEVES_FILE_NAME = "eleves.csv";
	public final static String PROFESSEURS_FILE_NAME = "professeurs.csv";

	
	/**
	 * Permet d'ecrire un nouvel eleve dans le fichier CSV
	 * On verifie d'abord que cet eleve n'existe deja pas
	 * @since 1.0
	 */
	public static boolean writeEleveToCSV(Eleve eleve){
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		
		if(!isEleveExist(eleves, eleve)) {
			BufferedWriter bufWriter = null;
	        FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter(RESOURCES_PATH + ELEVES_FILE_NAME, true);
	            bufWriter = new BufferedWriter(fileWriter);
	            //Insérer un saut de ligne
	            bufWriter.newLine();
	            bufWriter.write(eleve.getNom() + "," + eleve.getPrenom() + "," 
	            		+ eleve.getDateNaissance().getJour() + "," 
	            		+ eleve.getDateNaissance().getMois() + ","  
	            		+ eleve.getDateNaissance().getAnnee() + ",");
	            bufWriter.close();
				fileWriter.close();
	    		return true;
	        } catch (FileNotFoundException e) {
				System.out.println("ERROR: " + e.getMessage());
	        } catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false; 
	}
	
	/**
	 * Permet d'ecrire un prof dans le fichier CSV
	 * sans supprimer les autres prof
	 * si le prof existe deja, il nest pas ajouté
	 * @param prof
	 * @return vrai si le prof a ete ajoute faux sinon
	 */
	public static boolean writeProfToCSV(Professeur prof){
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		if(!isProfExist(profs, prof)) {
			BufferedWriter bufWriter = null;
	        FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter(RESOURCES_PATH + PROFESSEURS_FILE_NAME, true);
	            bufWriter = new BufferedWriter(fileWriter);
	            //Insérer un saut de ligne
	            bufWriter.newLine();
	            bufWriter.write(prof.getNom() + "," + prof.getPrenom() + "," );
	            bufWriter.close();
				fileWriter.close();
	    		return true;
	        } catch (FileNotFoundException e) {
				System.out.println("ERROR: " + e.getMessage());
	        } catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false; 
	}
	
	/**
	 * Permet de savoir si un eleve existe deja dans le fichier
	 * @param eleves
	 * @param addedEleve
	 * @return vrai s'il existe faux sinon
	 */
	public static boolean isEleveExist (List<Eleve> eleves, Eleve addedEleve) {
		for (Eleve eleve : eleves) {
			if(addedEleve.getNom().equalsIgnoreCase(eleve.getNom()) 
					&& addedEleve.getPrenom().equalsIgnoreCase(eleve.getPrenom())) {
				System.out.println("L'eleve existe deja dans le fichier..");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Permet de savoir si un prof existe dans le fichier
	 * @param profs
	 * @param addedProf
	 * @return vrai s'il existe faux sinon
	 */
	public static boolean isProfExist (List<Professeur> profs, Professeur addedProf) {
		for (Professeur prof : profs) {
			if(addedProf.getNom().equalsIgnoreCase(prof.getNom()) 
					&& addedProf.getPrenom().equalsIgnoreCase(prof.getPrenom())) {
				System.out.println("Le prof existe deja dans le fichier..");
				return true;
			}
		}
		return false;
	}

}
