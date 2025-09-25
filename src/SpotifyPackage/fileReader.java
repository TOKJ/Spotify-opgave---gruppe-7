package SpotifyPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileReader {
    final String COMMA_DELIMITER = ",";
    String fileName;

    public fileReader(String fileName){
        this.fileName = fileName;
    }

    List<List<String>> records = new ArrayList<>();

    public List<List<String>> reader(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }catch (FileNotFoundException e) {
            System.out.println("goober");
        }catch (IOException e){
            System.out.println("oof");
        }
        return records;
    }

}
