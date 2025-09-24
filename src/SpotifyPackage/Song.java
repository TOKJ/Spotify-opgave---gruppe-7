package SpotifyPackage;


import java.util.Scanner;

public class Song {
    private String title;
    final private String genre;
    private String artist;
    Scanner scanner = new Scanner(System.in);

    public Song(){
        this.title = scanner.nextLine();
        this.genre = validateGenre();
    }

    public String getTitle(){
        return this.title;
    }
    public String getGenre(){
        return this.genre;
    }
    public void setTitle(String title){
        this.title = title;
    }


    private boolean contains(String test) {
        for (Genres genre : Genres.values()) {
            if (genre.name().equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }

    private String validateGenre() {
        String input = scanner.nextLine().toUpperCase();
        boolean isDone = false;

        while (!isDone) {
            if (contains(input)) {
                isDone = true;

            } else {
                System.out.println("invalid");
                input = scanner.nextLine().toUpperCase();
            }
        }
        return input;
    }

    @Override
    public String toString(){
        return "Title: " + this.title + " Genre: " + this.genre;
    }

}
