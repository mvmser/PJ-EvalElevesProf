/**
 * 
 */
package writeCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import notesElevesProfesseurs.Professeur;

/**
 * @author SERHIR, ZARGA
 * @version 1.0
 */
public class WriteCSV {

	/** Attributs */
	private final static String RESOURCES_PATH = "files/";
	private final static String ELEVES_FILE_NAME = "eleves.csv";
	private final static String PROFESSEURS_FILE_NAME = "professeurs.csv";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @since 1.0
	 */
	public static boolean writeEleveToCSV(){
		try {
			Scanner inFile = new Scanner(new File(RESOURCES_PATH + PROFESSEURS_FILE_NAME), "utf8");
			
			List<Professeur> professeurs = new ArrayList<Professeur>();
			while (inFile.hasNext()) {
				String value = inFile.nextLine();
				
				if(value.charAt(0) != '#') {
					String[] array = value.split(",");
					try {
						professeurs.add(new Professeur(array[0], array[1]));
					}catch (NumberFormatException nfe) {
						System.out.println("NumberFormatException: " + nfe.getMessage());
					}
				}
			}
			inFile.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return false;
	}
	

}
