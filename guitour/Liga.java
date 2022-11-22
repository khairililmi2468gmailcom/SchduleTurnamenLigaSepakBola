package guitour;
import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
    ArrayList<Pertandingan> listPertandingan = new ArrayList<Pertandingan>();
    ArrayList<Club> listClub = new ArrayList<Club>();
    private int jmlClub;
    private int jmlPertandingan;
    public Liga(String list_club){
        generateClubs(list_club);
        generatePertandingan();
        //System.out.println("Jumlah Club : "+getjmlClub());
        //System.out.println("Jumlah Pertandingan : "+getjmlPertandingan());
        //getListClub();
        //getListPertandingan();
    }
    public Liga(){
        generateClubs();
        generatePertandingan();
        //System.out.println("Jumlah Club : "+getjmlClub());
        //System.out.println("Jumlah Pertandingan : "+getjmlPertandingan());
        //getListClub();
        //getListPertandingan();
    }

    public void setjmlClub(int jml){
        this.jmlClub = jml;
    }
    public void setjmlPertandingan(int jml){
        this.jmlPertandingan = jml;
    }
    public void generatePertandingan(){
        if(listClub.isEmpty()){
            System.out.println("Clubs belum ada!");
        }
        else{
            for(int i = 0; i<jmlClub; i++){
                for(int j=i+1; j<jmlClub; j++){
                    Pertandingan pert = new Pertandingan();
                    pert.setteamHome(listClub.get(i));
                    pert.setteamAway(listClub.get(j));
                    listPertandingan.add(pert);       
                }
            }
            jmlPertandingan=listPertandingan.size();
        }
    }
    public int getjmlPertandingan(){
        return jmlPertandingan;
    }
    public int getjmlClub(){
        return jmlClub;
    }
    /**
     * generate Clubs to ListCube's ArrayList in Terminal.
     */
    public void generateClubs(){
        Scanner in = new Scanner(System.in);
        System.out.print("Jumlah Club : ");
        jmlClub=in.nextInt();
        in.nextLine();
        for(int i=0; i<jmlClub; i++){
            System.out.print("Team "+(i+1)+" : ");
            listClub.add(new Club(in.nextLine()));
        }
        in.close();
    }
    /**
     * generate Clubs to listClubs'ArrayList from String separate by new line
     * @param textList
     */
    public void generateClubs(String textList){
        String[] clubNames = textList.split(System.lineSeparator());
        for(int i=0; i<clubNames.length; i++){
            if(clubNames[i] == "") continue;
            listClub.add(new Club(clubNames[i]));
            System.out.println(clubNames[i]);
        }
        jmlClub=listClub.size();
    }
    public void getListClub(){
        System.out.println("List Club : ");
        for(int i=0; i<listClub.size(); i++){
            System.out.println(listClub.get(i));
        }
    }
    public void getListPertandingan(){
        System.out.println("List Pertandingan : ");
        for(int i=0; i<listPertandingan.size(); i++){
            System.out.println(listPertandingan.get(i));
        }
    }
    public Pertandingan getPertandingan(int x){
        return listPertandingan.get(x);
    }
    public Club getClub(int x) {
    	return listClub.get(x);
    }
    
}

