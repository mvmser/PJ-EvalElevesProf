package readCSV;

import java.io.File;
import java.io.FileReader;

public class ReadCSV {

	private final static String RESOURCES_PATH = "src/main/resources/";
	private final static String ELEVES_FILE_NAME = "eleves.csv";
	 
	public ReadCSV() {

	}

	public static void main(String[] args) {
		File file = new File(RESOURCES_PATH + ELEVES_FILE_NAME);
        //FileReader fr = new FileReader(file);
        
	}

}
