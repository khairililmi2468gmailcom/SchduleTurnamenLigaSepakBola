public class Club {
    private String nama;
    private int menang;
    private int seri;
    private int kalah;
    private int goal;
    private int bobol;
    private int poin;
    private int matchPertandingan;
    public Club(String nama){
        this.nama = nama;
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
    public int getpoin() {
        return poin;
    }
    public int getmatchPertandingan() {
        return matchPertandingan;
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
    public void setSkorBobol(int i){
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
