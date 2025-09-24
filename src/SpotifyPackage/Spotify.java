package SpotifyPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Spotify {
    ArrayList<Song> songList = new ArrayList<Song>();
    boolean freeUser;
    Scanner scanner = new Scanner(System.in);

    public Spotify(boolean freeUser){
        this.freeUser = freeUser;
    }

    //THE While loop
    public void menu(){
        boolean isDone = false;

        System.out.println("valid options");

        while(!isDone){
            String input = scanner.nextLine();
            //if input == valid option, do valid option
            //maybe change to switch with numerated list?
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

    private void addSong(){
        Song newSong = new Song();
        this.songList.add(newSong);
        System.out.println("You've added " + newSong + " to your playlist.");
    }

    //1.	Tilføj ny sang

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

    private void showSongList(){
        for (int i = 0; i < songList.size(); i++) {
            System.out.println((i+1) + ": " +  songList.get(i));
        }
    }
    //3.	Vis alle sang

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
    private void add(){
        System.out.println("AAAAADS!!");
    }
}
