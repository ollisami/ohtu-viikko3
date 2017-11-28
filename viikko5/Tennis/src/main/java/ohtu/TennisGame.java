package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 ++;
        else
            m_score2 ++;
    }
    
    private String getTieScore() {
        switch (m_score1)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    
    private String getAdvantageScore(int diff) {
        String p = "";
        if(Math.abs(diff) >= 2) {
            p += "Win for ";
            return diff < 0 ? p + this.player2Name : p + this.player1Name;
        } else {
            p += "Advantage ";
            return diff < 0 ? p + this.player2Name : p + this.player1Name;
        }
    }
    
    private String scroreToString (int score) {
        switch(score)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Invalid score";
        }
    }

    public String getScore() {    
        return m_score1==m_score2 ? 
                getTieScore() : m_score1 >= 4 || m_score2 >= 4 ?
                getAdvantageScore(m_score1-m_score2) :
                scroreToString(m_score1) + "-" + scroreToString(m_score2);
    }
}