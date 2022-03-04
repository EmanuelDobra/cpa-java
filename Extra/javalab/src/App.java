import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    // Add ArrayList of Player objects here
    public static void main(String[] args) throws Exception {
        loadPlayerFile();
    }

    private static void loadPlayerFile() 
    {
        File file = new File("res/players.txt");

        try
        {
            ArrayList<Player> players = new ArrayList<Player>();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
                // Use data from this line to initialize a player
                Player player = new Player("test");
                players.add(player);
            }
            bufferedReader.close();
        } 
        catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
