package cricketScoreboard;

import java.util.Random;

public class Innings {

    Team battingTeam;

    Team bowlingTeam;

    int ballsFaced;

    int strikerIndex = 0;

    int nonStrikerIndex = 1;

    int nextBatsmanIndex = 2;

    int fallenWicket = 0;

    Random random = new Random();

    public Innings(Team battingTeam, Team bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    public int playInnings(int overs, int target) {
        int totalBalls = overs * 6;
        int totalRuns = 0;

        Player striker = battingTeam.getPlayers().get(strikerIndex);
        Player nonStriker = battingTeam.getPlayers().get(nonStrikerIndex);

        while (totalBalls > 0 && nextBatsmanIndex < 11 && (target == 0 || target > battingTeam.getTotalRuns())) {
            int run = random.nextInt(0, 7);

            // rotate strike
            if (run % 2 != 0 && run != 5) {
                nonStriker.setRunsScored(nonStriker.getRunsScored() + run);
                nonStriker.setBallsFaced(nonStriker.getBallsFaced() + 1);
            } else if (run % 2 == 0){
                striker.setRunsScored(striker.getRunsScored() + run);
                striker.setBallsFaced(striker.getBallsFaced() + 1);
            }

            if (run == 5) {
                battingTeam.setFallenWickets(++fallenWicket);
                striker.setOut(true);
                System.out.println("Player: " + striker.getName() + " got out on " + striker.getRunsScored() + " in " + (striker.getBallsFaced() + 1) + " balls.");
                strikerIndex = nextBatsmanIndex;
                striker = battingTeam.getPlayers().get(strikerIndex);
                nextBatsmanIndex++;
            } else {
                totalRuns = totalRuns + run;
                battingTeam.setTotalRuns(totalRuns);
            }
            ballsFaced++;
            totalBalls--;
            if (ballsFaced % 6 == 0) {
                System.out.println("End of over:");
                System.out.println(battingTeam.getName() + " score is: "+ battingTeam.getTotalRuns() + "/" + battingTeam.getFallenWickets());
                System.out.println(striker.getName() + " - " + striker.getRunsScored());
                System.out.println(nonStriker.getName() + " - " + nonStriker.getRunsScored());
            }
        }
        System.out.println("Final Score: " + battingTeam.getTotalRuns() + "/"+ battingTeam.getFallenWickets());
        return totalRuns;
    }
}
