

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
    public Club(String nama){
        this.nama = nama;
    }
    public int getrank(){
        return rank;
    }
    public String getNama(){
        return this.nama;
    }
    public int getkalah(){
        return kalah;
    }
    public int getseri() {
        return seri;
    }
    public int getgoal() {
        return goal;
    }
    public int getmenang(){
        return menang;
    }
    public int getbobol() {
        return bobol;
    }
    public int getselisihGoal(){
        selisihGoal=goal-bobol;
        return selisihGoal;
    }
    public int getpoin() {
        poin = (3*menang) + seri;
        return poin;
    }
    public int getmatchPertandingan() {
        return matchPertandingan;
    }
    public void setrank(int rank){
        this.rank=rank;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setmenang(int i) {
        menang=i;
    }
    public void setseri(int i){
        seri = i;
    }
    public void setkalah(int i) {
        kalah=i;
    }
    public void setgoal(int i){
        goal = i;
    }
    public void setbobol(int i){
        bobol = i;
    }
    public void setPoin(int i){
        poin = i;
    }
    public void setmatchPertandingan(int i){
        matchPertandingan = i;
    }
    public String toString(){
        return getNama();
    }
}
