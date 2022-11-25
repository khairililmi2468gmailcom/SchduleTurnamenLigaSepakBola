
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

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
        String[] clubNames = textList.split("\\R");
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
    public void UpdateClub(){
        System.out.println("Update");
        for(int i=0; i<jmlClub; i++){
            listClub.get(i).setgoal(0);
            listClub.get(i).setbobol(0);
            listClub.get(i).setmenang(0);
            listClub.get(i).setkalah(0);
            listClub.get(i).setseri(0);
            listClub.get(i).setmatchPertandingan(0);
        }
        //Update goal and bobol
        for(int i = 0; i<jmlPertandingan; i++){
                    getPertandingan(i).getteamHome().setgoal(getPertandingan(i).getteamHome().getgoal()+getPertandingan(i).getteamHomeScore());
                    getPertandingan(i).getteamHome().setbobol(getPertandingan(i).getteamHome().getbobol()+getPertandingan(i).getteamHomeScore());
                    getPertandingan(i).getteamAway().setgoal(getPertandingan(i).getteamAway().getgoal()+getPertandingan(i).getteamAwayScore());
                    getPertandingan(i).getteamAway().setbobol(getPertandingan(i).getteamAway().getbobol()+getPertandingan(i).getteamAwayScore());
        }
        //Update jml_pert, menang, seri, kalah
        for(int i=0; i<jmlPertandingan; i++){
            if(getPertandingan(i).getplayed()){
                getPertandingan(i).getteamAway().setmatchPertandingan(getPertandingan(i).getteamAway().getmatchPertandingan()+1);
                getPertandingan(i).getteamHome().setmatchPertandingan(getPertandingan(i).getteamHome().getmatchPertandingan()+1);
            }
            if(getPertandingan(i).getteamHomeScore()>getPertandingan(i).getteamAwayScore()){
                System.out.println(getPertandingan(i).getteamHomeScore()+"-"+getPertandingan(i).getteamAwayScore());
                getPertandingan(i).getteamHome().setmenang(getPertandingan(i).getteamHome().getmenang()+1);//add win+=1
                getPertandingan(i).getteamAway().setkalah(getPertandingan(i).getteamAway().getkalah()+1);//add lose+=1
            }else if(getPertandingan(i).getteamHomeScore()<getPertandingan(i).getteamAwayScore()){
                getPertandingan(i).getteamAway().setmenang(getPertandingan(i).getteamAway().getmenang()+1);
                getPertandingan(i).getteamHome().setkalah(getPertandingan(i).getteamHome().getkalah()+1);
            }else if(getPertandingan(i).getplayed() && getPertandingan(i).getteamHomeScore()==getPertandingan(i).getteamAwayScore()){
                getPertandingan(i).getteamAway().setseri(getPertandingan(i).getteamAway().getseri()+1);
                getPertandingan(i).getteamHome().setseri(getPertandingan(i).getteamHome().getseri()+1);
            }
        }
        sortClub();

    }
    public void sortClub(){
       System.out.println("Sort..");
       Collections.sort(listClub, new Comparator<Club>() {
           @Override
           public int compare(Club c1, Club c2) {
               return -String.valueOf(c1.getpoin()).compareTo(String.valueOf(c2.getpoin()));
           }
       });

    }

}

