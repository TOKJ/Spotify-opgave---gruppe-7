package SpotifyPackage;

import java.util.Scanner;

/**
 * Song is a class used to make songs with title and genre.<br>
 * Has methods: <br>
 * {@link #Song} is a constructor. <br>
 * {@link #Song(String, String)} is the constructor used when loading songs from file. <br>
 * {@link #getTitle()} returns {@link #title}. <br>
 * {@link #getGenre()} returns {@link #genre}. <br>
 * {@link #setTitle(String)} sets {@link #title}. <br>
 * {@link #contains(String)} checks if a String exists in {@link Genres}. <br>
 * {@link #validateGenre()} validates a user input using {@link #contains(String)}. <br>
 * {@link #toString()} overrides toString with a more appropriate format.<br>
 * Has attributes: <br>
 * {@link #title} is the title of the song. <br>
 * {@link #genre} is the genre of the song, genres are found in {@link Genres}. <br>
 * {@link #artist} currently not used. <br>
 * {@link #scanner} is used for handling user inputs.
 */

public class Song {
    /**
     * title is a String containing the title of the song.
     */
    private String title;
    /**
     * genre is a string containing the genre of the song matching the {@link Genres} ENUM.
     */
    final private String genre;
    /**
     * artists is not currently used.
     */
    private String artist;
    /**
     * scanner is a object of the {@link Scanner} class used for handling user inputs.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Song is a constuctor. uses {@link #scanner} and {@link #validateGenre()} to construct an object from user inputs.
     */
    public Song(){
        System.out.println("Please input the title of the song you wish to add.");
        this.title = scanner.nextLine();
        System.out.println("Please input a valid genre for the song you are trying to add. ");
        this.genre = validateGenre();
    }

    /**
     * constructor used when generating songs from a file using {@link fileReader}
     * @param title String containing title of the song
     * @param genre String containing genre of the song
     */
    public Song(String title, String genre){
        this.title = title;
        this.genre = genre;
    }

    /**
     * getTitle returns the {@link #title} as a string.
     * @return {@link #title} as string.
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * getGenre returns the {@link #genre} as a string.
     * @return {@link #genre} as string.
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * setTitle changes the {@link #title} to the input string.
     * @param title String of new title.
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * contains checks if a string exists in the ENUM {@link Genres}.
     * @param test is the string to check.
     * @return true if test exists in {@link Genres} otherwise false.
     */
    private boolean contains(String test) {
        for (Genres genre : Genres.values()) {
            if (genre.name().equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }

    /**
     * validateGenre gets a user input with {@link #scanner} and uses {@link #contains(String)} to validate if the user input exists in {@link Genres}.
     * @return returns the validated user in put as String.
     */
    private String validateGenre() {
        String input = scanner.nextLine().toUpperCase();
        boolean isDone = false;

        while (!isDone) {
            if (contains(input)) {
                isDone = true;

            } else {
                System.out.println("You've input an invalid genre. ");
                input = scanner.nextLine().toUpperCase();
            }
        }
        return input;
    }

    /**
     * toString overrides toString with a more appropriately formatted String.
     * @return String of format Title: {@link #title} Genre: {@link #genre}.
     */
    @Override
    public String toString(){
        return "Title: " + this.title + " Genre: " + this.genre;
    }

}
