package SpotifyPackage;

public class fileTest {
    public static void main(String[] args){
        fileReader r = new fileReader("src/SpotifyPackage/songlist.csv");
        Song song = new Song(r.reader().getFirst().getFirst(), r.reader().getFirst().getFirst());
        System.out.println(song);
    }
}
