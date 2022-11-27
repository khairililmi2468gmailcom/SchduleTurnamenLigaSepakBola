import java.util.Date;


public class Pertandingan {
    private boolean played;
    private Club teamHome;
    private Club teamAway;
    private int teamHomeScore;
    private int teamAwayScore;
    private Date date;
    
    /**
     * method untuk mendapatkan nilai true atau false(main atau tidak)
     * @return played
     */
    public boolean getplayed(){
        return played;
    } 
    /**
     *
     * @param play
     */   
    public void setplayed(boolean play){
        this.played = play;
    }
    /**
     * method getter untuk mendapatkan nilai dari tim home
     * @return teamhome
     */
    public Club getteamHome() {
        return teamHome;
    }
    /**
     * method getter untuk mendapatkan nilai dari  team away
     * @return teamAway
     */
    public Club getteamAway() {
        return teamAway;
    }
     /**
     * method getter untuk mendapatkan nilai dari skor team home
     * @return teamHomeScore
     */
    public int getteamHomeScore(){
        return teamHomeScore;
    }
    /**
     * method getter untuk mendapatka nilai dari skor team away
     * @return teamAwayScore
     */
    public int getteamAwayScore(){
        return teamAwayScore;
    }
    
    public Date getDate() {
        return date;
    }
    /**
     * method setter untuk mengubah team home
     * @param teamHome
     */
    public void setteamHome(Club teamHome) {
        this.teamHome = teamHome;
    }
     /**
     * method setter untuk mengubah team away
     * @param teamAway
     */
    public void setteamAway(Club teamAway) {
        this.teamAway = teamAway;
    }
     /**
     * method setter untuk mengubah score team home
     * @param teamHomeScore
     */
    public void setteamHomeScore(int teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }
     /**
     * method setter untuk mengubah score team away
     * @param teamAwayScore
     */
    public void setteamAwayScore(int teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }
    
    /**
    * Method untuk menampilkan objek team home vs team away
    * @return string
    */
    public String toString(){
        return getteamHome()+"[vs]"+getteamAway();
    }
}
