package cricketScoreboard;

public class Match {

    Team teamA;

    Team teamB;

    int overs;

    public Match(Team teamA, Team teamB, int overs) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.overs = overs;
    }

    public void startMatch() {

        System.out.println("Starting first Inning");
        Innings firstInnings = new Innings(teamA, teamB);
        teamA.setTotalRuns(firstInnings.playInnings(overs, 0));
        System.out.println("Team " + teamA.getName() + " scored "+ teamA.getTotalRuns());
        System.out.println("Team " + teamB.getName() + " need "+ (teamA.getTotalRuns() + 1) + " to win");

        Innings secondInnings = new Innings(teamB, teamA);
        teamB.setTotalRuns(secondInnings.playInnings(overs, teamA.getTotalRuns() + 1));
        System.out.println("Team " + teamB.getName() + " scored "+ teamB.getTotalRuns());

    }

    public String declareWinner() {
        if (teamB.getTotalRuns() > teamA.getTotalRuns()) {
            return "Team " + teamB.getName() + " won by " + (10 - teamB.getFallenWickets()) + " wickets.";
        } else if (teamB.getTotalRuns() == teamA.getTotalRuns()) {
            return "Match tied";
        } else {
            return "Team " + teamA.getName() + " won by " + (teamA.getTotalRuns() - teamB.getTotalRuns()) + " runs";
        }
    }

}
