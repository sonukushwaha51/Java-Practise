package cricketScoreboard;

public class StartMatch {

    public static void main(String[] args) {

        Team team1 = new Team("India");
        Team team2 = new Team("Australia");
        for (int i = 0; i <= 10; i++) {
            team1.getPlayers().add(new Player(team1.getName() + " Player_"+ i ));
            team2.getPlayers().add(new Player(team2.getName() + " Player_"+ i ));
        }
        int overs = 20;

        Match match = new Match(team1, team2, overs);
        match.startMatch();
        String result = match.declareWinner();
        System.out.println(result);
    }
}
