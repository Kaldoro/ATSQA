package file;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


/**https://www.w3schools.com/java/java_files_read.asp**/

public class FileFuncs {
    FileFuncs() {

    }
    public static String[] readFile(String filePath) {
        ArrayList<String> content = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Could not read the file or failed when reading the file, see stacktrace below");
            e.printStackTrace();
        }
        String[] finalOutput = new String[content.size()];
        content.toArray(finalOutput);
        return finalOutput;
    }
}