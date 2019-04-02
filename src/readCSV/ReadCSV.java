package readCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import notesElevesProfesseurs.Eleve;

/**
 * @author SERHIR, ZARGA
 * @version 1.0
 */
public class ReadCSV {

	/** Attributs */
	private final static String RESOURCES_PATH = "files/";
	private final static String ELEVES_FILE_NAME = "eleves.csv";
	
	/**
	 * Permet de lire toutes les lignes d'un fichier eleves
	 * exclu les lignes commentées avec #
	 * Parcours les lignes et separe chaque ligne en 5 dans un tableau
	 * On retrouve alors le Nom, Prenom, jour, mois, et l'annee
	 * On cree alors un eleve avec ces infos et on l'ajout a notre arraylist
	 * @return Une list d'eleves
	 * @since 1.0
	 */
	public static List<Eleve> readElevesFromCSV(){
		try {
			Scanner inFile = new Scanner(new File(RESOURCES_PATH + ELEVES_FILE_NAME), "utf8");
			
			List<Eleve> eleves = new ArrayList<Eleve>();
			while (inFile.hasNext()) {
				String value = inFile.nextLine();
				
				if(value.charAt(0) != '#') {
					String[] array = value.split(",");
					try {
						eleves.add(new Eleve(array[0], array[1], Integer.parseInt(array[2]), 
								Integer.parseInt(array[3]), Integer.parseInt(array[4]) ));
					}catch (NumberFormatException nfe) {
						System.out.println("NumberFormatException: " + nfe.getMessage());
					}
					
				}
			}
			inFile.close();
			return eleves;
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Permet de lire toutes les lignes d'un fichier notes
	 * exclu les lignes commentés avec #
	 * @return Une list d'evaluations 
	 * @since 1.0
	 */
	public static List<Eleve> readEvaluationsFromCSV(){
		return null;
	}
	
	
	
	
	
	/**
	 * BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
		   // process the line.
		}
		br.close();
	 */


}
