package SpotifyPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * fileWriter is a helper class used to make a file to store the current playlist when exiting the program. <br>
 * Has methods: <br>
 * {@link #fileWriter(String, ArrayList)} is a constructor. <br>
 * {@link #fileMaker()} makes a new file. <br>
 * {@link #writer()} writes {@link #songlist} to {@link #fileName}. <br>
 * Has attributes: <br>
 * {@link #fileName} name of the file to write {@link #songlist} to. <br>
 * {@link #songlist} is the current playlist.
 */
public class fileWriter {
    /**
     * fileName is a String containing the name of the .csv file to store the current playlist in.
     */
    String fileName;
    /**
     * songlist is an {@link ArrayList} containing the current playlist.
     */
    ArrayList<Song> songlist;

    /**
     * constructor
     * @param fileName fileName is the name of the file to store the playlist in.
     * @param songlist songlist is an {@link ArrayList} containing the current playlist.
     */
    public fileWriter(String fileName, ArrayList<Song> songlist){
        this.fileName = fileName;
        this.songlist = songlist;
    }

    /**
     * fileMaker trys to make a file at {@link #fileName}. If such a file already exists, it does nothing.
     */
    public void fileMaker() {
        try {
            File file = new File(this.fileName);
            if (file.createNewFile()){
                System.out.println("New file for song storage: " + file.getName());
            }else {
                System.out.println("Songs stored at: " + this.fileName);
            }
        }catch (IOException e) {
            System.out.println("An error has occurred. ");
        }
    }

    /**
     * writer writes {@link #songlist} to the file at {@link #fileName} in a format that {@link fileReader} can parse.
     */
    public void writer() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName))){
            for (Song song : songlist) {
                bw.write(song.getTitle() + "," + song.getGenre());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println();
        }
    }


}
