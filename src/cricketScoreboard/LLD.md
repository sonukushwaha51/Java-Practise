                 +----------------+
                 |     Match      |
                 +----------------+
                 | Team teamA     |
                 | Team teamB     |
                 | int overs      |
                 +----------------+
                 | startMatch()   |
                 | declareWinner()|
                 +--------+-------+
                          |
                          v
                +-------------------+
                |      Innings      |
                +-------------------+
                | Team battingTeam  |
                | Team bowlingTeam  |
                | int ballsFaced    |
                | int strikerIndex  |
                | int nonStrikerIdx |
                | int fallenWickets |
                | Random random     |
                +-------------------+
                | playInnings(overs,|
                |        target)    |
                +---------+---------+
                          |
                          v
                    +---------------+
                    |   Team        |
                    +---------------+
                    | String name   |
                    | List<Player>  |
                    | int totalRuns |
                    | int wickets   |
                    +-----------+

                    +-----------+
                    |  Player   |
                    +-----------+
                    | String name
                    | int runs
                    | int balls
                    | boolean isOut
                    +-----------+