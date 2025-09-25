package SpotifyPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Spotify is a class that contains and modifies an {@link ArrayList} of {@link Song} objects. <br>
 * Has methods:<br>
 * {@link #Spotify(boolean, String)} is the constructor.<br>
 * {@link #menu()} is the main body of the class, all other methods are run from here. <br>
 * Has attributes: <br>
 * {@link #songList} is an {@link ArrayList} that contains {@link Song} objects.<br>
 * {@link #freeUser} determines whether to use {@link #add()} method in {@link #menu} or not.<br>
 * {@link #scanner} is an object of the {@link Scanner} class used to get user inputs.<br>
 * {@link #fileName} File path containing current list of songs
 */

public class Spotify {
    /**
     * songList is an ArrayList of objects of the {@link Song} class.
     */
    ArrayList<Song> songList = new ArrayList<Song>();
    /**
     * freeUser is a boolean that determines add usage.
     */
    boolean freeUser;
    /**
     * scanner is an object of the {@link Scanner} class.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * fileName is the String name of the file containing current list of songs
     */
    String fileName;

    /**
     * constructor uses the fileName to run {@link #booter()} which loads a saved song list from a file.
     * @param freeUser freeUser determines whether to play adds or not.
     * @param fileName fileName is the path to a file containing the current list of songs as a String.
     */
    public Spotify(boolean freeUser, String fileName){
        this.freeUser = freeUser;
        this.fileName = fileName;
        booter();
    }

    /**
     * booter adds songs from {@link #fileName} to {@link #songList} using {@link fileReader}
     */
    public void booter(){
        fileReader r = new fileReader(this.fileName);

        List<List<String>> storedFile = r.reader();
        for (List<String> strings : storedFile) {
            String title = strings.getFirst();
            String genre = strings.getLast();
            Song song = new Song(title, genre);
            songList.add(song);
        }
    }

    /**
     * closer saves the {@link #songList} to the file at {@link #fileName} using {@link fileReader}.
     */
    public void closer(){
        fileWriter w = new fileWriter(this.fileName, this.songList);
        w.fileMaker();
        w.writer();
    }

    /**
     * Main body of the class which allows the user to pick different methods: <br>
     * {@link #addSong()} to add a song.<br>
     * {@link #removeSong()} to remove a song.<br>
     * {@link #showSongList()} to show {@link #songList} using toString overrides.<br>
     * {@link #search()} to search for a song by title.<br>
     * {@link #showMenu()} show the menu options. <br>
     * or a method to end the program using {@link #closer()} to save the current {@link #songList}.
     */
    public void menu(){
        boolean isDone = false;

        System.out.println("Welcome to totally not a trademark issue!");

        while(!isDone){
            showMenu();
            String input = scanner.nextLine();

            if(freeUser){
                add();
            }
            if(input.equalsIgnoreCase("add") || input.equalsIgnoreCase("1")){
                addSong();
                continue;
            }
            if(input.equalsIgnoreCase("remove") || input.equalsIgnoreCase("2")){
                removeSong();
                continue;
            }if(input.equalsIgnoreCase("show") || input.equalsIgnoreCase("3")){
                showSongList();
                continue;
            }if(input.equalsIgnoreCase("Search") || input.equalsIgnoreCase("4")){
                search();
                continue;
            }if(input.equalsIgnoreCase("edit") || input.equalsIgnoreCase("5")){
                editSong();
                continue;
            }if(input.equalsIgnoreCase("exit")){
                closer();
                isDone = true;
                break;
            }else{
                System.out.println("that is not a valid option. ");
            }
            }
    }

    /**
     * addSong adds a {@link Song} to {@link #songList}.
     */
    private void addSong(){
        Song newSong = new Song();
        this.songList.add(newSong);
        System.out.println("You've added " + newSong + " to your playlist.");
    }

    //1.	Tilføj ny sang

    /**
     * removeSong removes a {@link Song} from {@link #songList}.
     */
    private void removeSong(){
        System.out.println("Please enter the title of the song you wish to remove.");
        String input = scanner.nextLine();
        if (songList.removeIf(song -> song.getTitle().equalsIgnoreCase(input))
        ) {
            System.out.println(input + " has been removed.");
        }else{
            System.out.println(input + " does not exist.");

        }
        }
    //2.	Fjern en sang
    //maybe remove by index too

    /**
     * showSongList shows {@link #songList} using toString for {@link Song}.
     */
    private void showSongList(){
        System.out.println("Songs currently in list:");
        for (int i = 0; i < songList.size(); i++) {
            System.out.println((i+1) + ": " +  songList.get(i));
        }
        System.out.println("-------------------------");
    }
    //3.	Vis alle sang

    /**
     * Gets a String input with {@link #scanner} and searches for it in {@link #songList} then displays it using toString if found.
     */
    private void search(){
        System.out.println("Please write the title of the song you wish to find: ");
        String input = this.scanner.nextLine();
        int found = 0;
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getTitle().equalsIgnoreCase(input)){
                System.out.println((i+1) + ": " + songList.get(i));
                found++;
            }
        }
        if(found == 0){
            System.out.println("Title not found.");
    }else{
            System.out.println(found + " songs with matching title were found.");
        }
    }
    //4.	 Søg efter en sang

    /**
     * Searches for song like {@link #search()} the sets a new title for the found {@link Song}.
     */

    private void editSong(){
        System.out.println("Please write the current title of the song you wish to edit. ");
        String input = this.scanner.nextLine();
        int found = 0;
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getTitle().equalsIgnoreCase(input)){
                System.out.println((i+1) + ": " + songList.get(i));
                System.out.println("Please write the new title you wish to name the song. ");
                String newtitle = scanner.nextLine();
                songList.get(i).setTitle(newtitle);
                found++;
            }
        }
        if(found == 0){
            System.out.println("Title not found.");
        }else{
            System.out.println(found + " songs with matching title were found.");
        }
    }

    /**
     * showMenu shows the options in {@link #menu()}
     */

    private void showMenu(){
        System.out.println("\n\nvalid options:\n" +
                "1. add a song 'add'\n" +
                "2. remove a song 'remove \n" +
                "3. show song list 'show'\n" +
                "4. search for and display a song 'search'\n" +
                "5. edit the title of a song 'edit'\n" +
                "Exit the program 'exit'\n");
    }

    /**
     * add plays adds in every iteration of {@link #menu} if {@link #freeUser} is true.
     */
    private void add(){
        System.out.println("AAAAADS!!");
    }
}
