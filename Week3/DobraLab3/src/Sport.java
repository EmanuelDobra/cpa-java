import java.util.ArrayList;

public class Sport {
    String sportName;
    ArrayList<String> players = new ArrayList<>();

    public Sport(String sportName) {
        this.sportName = sportName;
    }

    public void addPlayer(String player) {
        players.add(player);
    }

    public String getSportName() {
        return sportName;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "\n[Sport: " + sportName + ", Players: " + players + "]";
    }

}
