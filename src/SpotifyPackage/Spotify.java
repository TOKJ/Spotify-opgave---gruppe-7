package SpotifyPackage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Spotify is a class that contains and modifies an {@link ArrayList} of {@link Song} objects. <br>
 * Has methods:<br>
 * {@link #Spotify(boolean)} is the constructor.<br>
 * {@link #menu()} is the main body of the class, all other methods are run from here. <br>
 * Has attributes: <br>
 * {@link #songList} is an {@link ArrayList} that contains {@link Song} objects.<br>
 * {@link #freeUser} determines whether to use {@link #add()} method in {@link #menu} or not.<br>
 * {@link #scanner} is an object of the {@link Scanner} class used to get user inputs.
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
     * constructor
     * @param freeUser determines whether to play adds or not.
     */
    public Spotify(boolean freeUser){
        this.freeUser = freeUser;
    }

    /**
     * Main body of the class which allows the user to pick different methods: <br>
     * {@link #addSong()} to add a song.<br>
     * {@link #removeSong()} to remove a song.<br>
     * {@link #showSongList()} to show {@link #songList} using toString overrides.<br>
     * {@link #search()} to search for a song by title.<br>
     * or a method to end the program.
     */
    public void menu(){
        boolean isDone = false;

        System.out.println("valid options");

        while(!isDone){
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
        try{
            songList.removeIf(song -> song.getTitle().equalsIgnoreCase(input));
            System.out.println(input + " has been removed.");
        }catch (Exception NullPointerException){
            System.out.println(input + " does not exist.");
        }
        }
    //2.	Fjern en sang
    //maybe remove by index too

    /**
     * showSongList shows {@link #songList} using toString for {@link Song}.
     */
    private void showSongList(){
        for (int i = 0; i < songList.size(); i++) {
            System.out.println((i+1) + ": " +  songList.get(i));
        }
    }
    //3.	Vis alle sang

    /**
     * Gets a String input with {@link #scanner} and searches for it in {@link #songList} then displays it using toString if found.
     */
    private void search(){
        String input = this.scanner.nextLine();
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getTitle().equalsIgnoreCase(input)){
                System.out.println((i+1) + ": " + songList.get(i));
            }else{
                System.out.println("Title not found.");
            }
        }
    }
    //4.	 Søg efter en sang

    /**
     * Searches for song like {@link #search()} the sets a new title for the found {@link Song}.
     */

    private void editSong(){
        String input = this.scanner.nextLine();
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getTitle().equalsIgnoreCase(input)){
                System.out.println((i+1) + ": " + songList.get(i));
                String newtitle = scanner.nextLine();
                songList.get(i).setTitle(newtitle);
            }else{
                System.out.println("Title not found.");
            }
        }
    }
    //5.	Rediger en sang


    //-	Afslut programmet
    //increment isDone boolean
    //playsong???
    //print add if freeuser

    /**
     * add plays adds in every iteration of {@link #menu} if {@link #freeUser} is true.
     */
    private void add(){
        System.out.println("AAAAADS!!");
    }
}
