package guitour;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Pertandingan {
    private boolean played;
    private Club teamHome;
    private Club teamAway;
    private int teamHomeScore;
    private int teamAwayScore;
    private Date date;
    
    public boolean getplayed(){
        return played;
    }    
    public void setplayed(boolean play){
        this.played = play;
    }
    public Club getteamHome() {
        return teamHome;
    }
    
    public Club getteamAway() {
        return teamAway;
    }
    
    public int getteamHomeScore(){
        return teamHomeScore;
    }
    
    public int getteamAwayScore(){
        return teamAwayScore;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setteamHome(Club teamHome) {
        this.teamHome = teamHome;
    }
    
    public void setteamAway(Club teamAway) {
        this.teamAway = teamAway;
    }
    
    public void setteamHomeScore(int teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }
    
    public void setteamAwayScore(int teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }
    
    public void setDate(String Sdate) throws ParseException {

        this.date = new SimpleDateFormat("dd/MM/yyyy").parse(Sdate);
    }
    public String toString(){
        return getteamHome()+"[vs]"+getteamAway();
    }
}
