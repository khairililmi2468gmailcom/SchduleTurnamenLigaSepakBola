
/**
 *
 * @author khairil ilmi
 * @version 1.0
 */
/**
 * {@code}
 * membuat class Club yang mewarisi sifat dari class pertandingan
 */
public class Club extends PertandinganClub {
    
    /**
     * Deklarasi atribut
     */
    private int menang;
    private int seri;
    private int kalah;
    private int goal;
    private int bobol;
    private int poin;
    private int matchPertandingan;
    /**
     * accessor method getkalah
     * tipe int
     * @return
     */
    public int getkalah(){
        return kalah;
    }
    /**
     * accessor method getseri
     * tipe int
     * @return
     */
    public int getseri() {
        return seri;
    }
    /**
     * accessor method getgoal
     * tipe int
     * @return
     */
    public int getgoal() {
        return goal;
    }
    /**
     * accessor method getmenang
     * tipe int
     * @return
     */
    public int getmenang(){
        return menang;
    }
    /**
     * acccesor method bobol
     * tipe int
     * @return
     */
    public int getbobol() {
        return bobol;
    }
    /**
     * accessor method getpoin
     * tipe int
     * @return
     */
    public int getpoin() {
        return poin;
    }
    /**
     * accessor method getmatchPertandingan
     * tipe int
     * @return
     */
    public int getmatchPertandingan() {
        return matchPertandingan;
    }
    /**
     * mutator method setmenang
     * bertipe void
     * @param i
     */
    public void setmenang(int i) {
        menang=i;
    }
    /**
     * mutator method setseri
     * bertipe void
     * @param i
     */
    public void setseri(int i){
        seri = i;
    }
    /**
     * mutator method setkalah
     * bertipe void
     * @param i
     */
    public void setkalah(int i) {
        kalah=i;
    }
    
    /**
     * mutator method setgoal
     * bertipe void
     * @param i
     */
    public void setgoal(int i){
        goal = i;
    }
    /**
     * mutator method setSkorBobol
     * bertipe void
     * @param i
     */
     public void setSkorBobol(int i){
        bobol = i;
    }
     /**
      * mutator method setpoin
      * bertipe void
      * @param i
      */
     public void setpoin(int i){
        poin = i;
    }
    /**
     * mutator setmatchPertandingan
     * bertipe void
     * @param i
     */
     public void setmatchPertandingan(int i){
        matchPertandingan = i;
    }
    
}
