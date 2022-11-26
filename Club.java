

public class Club {
    private int rank;
    private String nama;
    private int matchPertandingan;
    private int menang;
    private int seri;
    private int kalah;
    private int goal;
    private int bobol;
    private int selisihGoal;
    private int poin;

    /**
     * Method constructor dengan paramereter
     * @param nama
     */
    public Club(String nama){
        this.nama = nama;
    }

    /**
     * Method getter untuk mendapatkan nilai dari rank
     * @return rank
     */
    public int getrank(){
        return rank;
    }

    /**
     * Method getter untuk mendapatkan nilai dari nama
     * @return this.nama
     */
    public String getNama(){
        return this.nama;
    }

    /**
     * Method getter untuk mendapatkan nilai dari kalah
     * @return kalah 
     */
    public int getkalah(){
        return kalah;
    }

    /**
     * Method getter untuk mendapatkan nilai dari seri
     * @return seri 
     */
    public int getseri() {
        return seri;
    }

    /**
     * Method getter untuk mendapatkan nilai dari goal
     * @return goal
     */ 
    public int getgoal() {
        return goal;
    }

    /**
     * Method getter untuk mendapatkan nilai dari menang
     * @return menang
     */
    public int getmenang(){
        return menang;
    }

    /**
     * Method getter untuk mendapatkan nilai dari bobol
     * @return bobol 
     */  
    public int getbobol() {
        return bobol;
    }

    /**
     * Method getter untuk mendapatkan selisih goal
     * dengan cara goal dikurangi bobol
     * @return seisihGoal
     */
    public int getselisihGoal(){
        selisihGoal=goal-bobol;
        return selisihGoal;
    }

    /**
     * Method getter untuk mendapatkan nilai dari poin
     * dengan cara (banyak menang dikali 3) ditambah dengan banyak seri
     * @return poin
     */ 
    public int getpoin() {
        poin = (3*menang) + seri;
        return poin;
    }

    /**
     * Method getter untuk mendapatkan nilai dari matchPertandingan
     * @return matchPertandingan 
     */ 
    public int getmatchPertandingan() {
        return matchPertandingan;
    }

    /**
     * Method getter untuk mendapatkan nilai dari rank
     * @return rank
     */ 
    public void setrank(int rank){
        this.rank=rank;
    }

    /**
     * Method setter untuk mengubah nilai nama
     * @param nama
     */
    public void setNama(String nama){
        this.nama=nama;
    }

    /**
     * Method setter untuk mengubah nilai menang
     * @param menang
     */
    public void setmenang(int i) {
        menang=i;
    }

    /**
     * Method setter untuk mengubah nilai seri
     * @param seri
     */
    public void setseri(int i){
        seri = i;
    }

    /**
     * Method setter untuk mengubah nilai kalah
     * @param kalah
     */
    public void setkalah(int i) {
        kalah=i;
    }

    /**
     * Method setter untuk mengubah nilai goal
     * @param goal
     */
    public void setgoal(int i){
        goal = i;
    }

    /**
     * Method setter untuk mengubah nilai bobol
     * @param bobol
     */
    public void setbobol(int i){
        bobol = i;
    }

    /**
     * Method setter untuk mengubah nilai poin
     * @param poin
     */
    public void setPoin(int i){
        poin = i;
    }

    /**
     * Method setter untuk mengubah nilai match pertandingan
     * @param matchPertandingan
     */
    public void setmatchPertandingan(int i){
        matchPertandingan = i;
    }

    /**
     * Method untuk menampilkan objek nama
     * @return string
     */
    public String toString(){
        return getNama();
    }
}
