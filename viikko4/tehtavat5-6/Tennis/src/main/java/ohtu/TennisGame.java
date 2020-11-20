package ohtu;

public class TennisGame {
    
    private int player1_score = 0;
    private int player2_score = 0;
    private final int four = 4;
    private final String[] gameSituation;
    
    public TennisGame(String player1Name, String player2Name) {
        gameSituation = new String[4];
        gameSituation[0] = "Love";
        gameSituation[1] = "Fifteen";
        gameSituation[2] = "Thirty";
        gameSituation[3] = "Forty";
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1_score++;
        else
            player2_score++;
    }

    public String getScore() {
        String score = "";
        if (player1_score==player2_score) {
            score = setScoreToTie();
        }
        else if (player1_score>=four || player2_score>=four) {
            score = scoreOverFour(score);
        }
        else {
            score = setScore(score);
        }
        return score;
    }

    private String setScoreToTie() {
        if (player1_score > 3) {
            return "Deuce";
        }
        return gameSituation[player1_score] + "-All";
    }

    private String scoreOverFour(String score) {
        int minusResult = player1_score-player2_score;
            if (minusResult==1) {
                score ="Advantage player1";
            }
            else if (minusResult ==-1) {
                score ="Advantage player2";
            }
            else if (minusResult>=2) {
                score = "Win for player1";
            }
            else {
                score ="Win for player2";
            }
            return score;
    }

    private String setScore(String score) {
        int tempScore;
        for (int i=1; i<3; i++) {
            if (i==1) {
                tempScore = player1_score;
            }
            else {
                score+="-";
                tempScore = player2_score;
            }
            score = getGameSituation(score, tempScore);
        }
        return score;
    }

    private String getGameSituation(String score, int tempScore) {
        if (tempScore > 2) {
            return score + gameSituation[3];
        }
        return score + gameSituation[tempScore];
    }
    
}