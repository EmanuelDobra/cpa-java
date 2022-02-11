import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {    
    public static void main(String[] args) throws Exception {
        loadPlayerFile();
    }

    // Load file 
    private static void loadPlayerFile() 
    {
        // File with our data
        File file = new File("res/players.txt");

        try
        {
            // Array containing our players
            ArrayList<Player> players = new ArrayList<Player>();

            // Read from file
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // String to hold current line on file
            String line = bufferedReader.readLine();

            // Loop until eof
            while (line != null) {
                System.out.println(line);
                // Move to next line
                line = bufferedReader.readLine();
                // Store data if line isn't null
                if (line != null) {
                    // Split line data into info array
                    String[] info = line.split(", ");

                    // First element of info array is player name
                    // Initialize player object with that data 
                    Player playerX = new Player(info[0]);

                    // loop through the info array and store 
                    // and store the sports for that player
                    int idx = 1;
                    while (idx < info.length) {
                        playerX.addSport(info[idx]);
                        idx++;
                    }
                    // Appendd current player to the player arraylist
                    players.add(playerX);
                }
            }
            // close reader
            bufferedReader.close();
            System.out.println("\nPlayer List data: \n" + players);

            // Step4
            // Store all possible sports
            String[] allSports = {"soccer", "hockey",  "rugby", "basketball", "golf", "swimming"};
            // Create an arraylsit of sport objects
            ArrayList<Sport> sports = new ArrayList<Sport>();
            // Loop through the allsports array
            for (String sport : allSports) {
                // Create sport object and assign sportName
                Sport sportX = new Sport(sport);
                // Loop through players arraylist
                for (Player player : players) {
                    // Create new arraylist to hold the current sports of the player
                    ArrayList<String> playerSports = player.getSports();
                    // Append playerName if it contains the correct sport 
                    if (playerSports.contains(sport)) {
                        sportX.addPlayer(player.getPlayerName());
                    }
                }
                // add the current sport to sports arraylist
                sports.add(sportX);
            }
            // Print out sports array
            System.out.println("\n\nSports Player List: \n" + sports.toString());
        } 
        catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
