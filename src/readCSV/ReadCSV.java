package readCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static Eleve readElevesFromCSV(){
		try {
			Scanner inFile = new Scanner(new File(RESOURCES_PATH + ELEVES_FILE_NAME), "utf8");
			
			List<Eleve> eleves = new ArrayList<Eleve>();
			while (inFile.hasNext()) {
				String value = inFile.nextLine();
				
				if(value.charAt(0) != '#') {
					String[] array = value.split(",");
					eleves.add(new Eleve(array[0], array[1], Integer.parseInt(array[2]), 
								Integer.parseInt(array[3]), Integer.parseInt(array[4]) ));
				}
			}
			inFile.close();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
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
