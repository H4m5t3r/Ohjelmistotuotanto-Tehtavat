package ohtu;

public class TennisGame {
    
    private int player1_score = 0;
    private int player2_score = 0;
    private final int four = 4;
    
    public TennisGame(String player1Name, String player2Name) {
        
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
            score = setScoreToTie(score);
        }
        else if (player1_score>=four || player2_score>=four) {
            score = scoreOverFour(score);
        }
        else {
            score = setScore(score);
        }
        return score;
    }

    private String setScoreToTie(String score) {
        switch (player1_score) {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            case 3:
                    score = "Forty-All";
                break;
            default:
                    score = "Deuce";
                break;
        }
        return score;
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
        switch(tempScore) {
            case 0:
                return score+="Love";
            case 1:
                return score+="Fifteen";
            case 2:
                return score+="Thirty";
            default:
                return score+="Forty";
        }
    }
    
}