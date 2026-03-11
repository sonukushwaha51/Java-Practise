package cricketScoreboard;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players = new ArrayList<>();

    private int fallenWickets;

    private int totalRuns;

    private int ballsFaced;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getFallenWickets() {
        return fallenWickets;
    }

    public void setFallenWickets(int wickets) {
        this.fallenWickets = wickets;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }
}
