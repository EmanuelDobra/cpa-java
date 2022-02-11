import java.util.ArrayList;

public class Player {
    String playerName;
    ArrayList<String> sports;

    public Player(String playerName) {
        this.playerName = playerName;
        sports = new ArrayList<>();
    }

    public void addSport(String sport) {
        sports.add(sport);
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<String> getSports() {
        return sports;
    }

    @Override
    public String toString() {
        return "\nPlayer: [Name: " + playerName + ", Sports:" + sports + "]";
    }
}
