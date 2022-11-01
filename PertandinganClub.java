
/**
 *
 * @author khairil ilmi
 */
public abstract class PertandinganClub {
    
    private String name;
    private String lokasiPertandinganClub;
    private String stat;
    
    @Override
    public boolean equals(Object o) {
        return this.name.equals(((PertandinganClub)o).name);
    }
    
    
    public String getName() {
        return name;
    }
    
    public String getlokasiPertandinganClub() {
        return lokasiPertandinganClub;
    }
    
    public String getStat() {
        return stat;
    }
    
    public void setlokasiPertandinganClub(String s) {
        this.lokasiPertandinganClub = s;
    }
    
    public void setName(String s) {
        this.name = s;
    } 
    
    public void setStat(String s) {
        this.stat = s;
    }   
    
}
