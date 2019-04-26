/**
 * 
 */
package writeCSV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import readCSV.ReadCSV;

/**
 * @author SERHIR, ZARGA
 * @version 1.0
 */
public class WriteCSV {

	/** Attributs */
	private final static String RESOURCES_PATH = "files/";
	private final static String ELEVES_FILE_NAME = "eleves.csv";
	private final static String PROFESSEURS_FILE_NAME = "professeurs.csv";

	
	/**
	 * Permet d'ecrire un nouvel eleve dans le fichier CSV
	 * On verifie d'abord que cet eleve n'existe deja pas
	 * @since 1.0
	 */
	public static boolean writeEleveToCSV(Eleve eleve){
		List<Eleve> eleves = ReadCSV.readElevesFromCSV();
		if(eleves.equals(eleve)) System.out.println("OKKKKKK");
		System.out.println(" PAS OKKKKKK");
		if(!eleves.contains(eleve)) {
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
	
	public static boolean writeProfToCSV(Professeur prof){
		List<Professeur> profs = ReadCSV.readProfesseursFromCSV();
		if(!profs.contains(prof)) {
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
	

}
