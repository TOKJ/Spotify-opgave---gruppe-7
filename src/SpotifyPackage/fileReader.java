package SpotifyPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fileReader is a helper class used to load a saved list of songs from a .csv file.<br>
 * Has methods: <br>
 * {@link #fileReader(String)} is a constructor.<br>
 * {@link #reader()} reads a file returning a list.<br>
 * Has Attributes: <br>
 * {@link #COMMA_DELIMITER} defines the delimiter of the .csv file. <br>
 * {@link #fileName} is the path to the file to read from.
 */
public class fileReader {
    /**
     * COMMA_DELIMITER is the delimiter in the .csv file used to split the read String.
     */
    final String COMMA_DELIMITER = ",";
    /**
     * fileName is a String containing the path to the file to read.
     */
    String fileName;

    /**
     * constructor
     * @param fileName is a String containing the path to the file to read.
     */
    public fileReader(String fileName){
        this.fileName = fileName;
    }

    List<List<String>> records = new ArrayList<>();

    /**
     * reader uses {@link BufferedReader} to read the file found at {@link #fileName} then splits it into an ordered list using {@link #COMMA_DELIMITER}
     * @return List&ltList&ltString&gt&gt containing the names and genres found in read file.
     */
    public List<List<String>> reader(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }catch (IOException e){
            System.out.println("IOException.");
        }
        return records;
    }

}
