
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Khairil Ilmi
 */
public class Liga implements InterfaceClass {

    private final int jumlahClub;

    private final ArrayList<Club> liga;
    private final Scanner input;
    private final ArrayList<Pertandingan> pertandingan;
    public Liga(int jumlahClub) {

        this.jumlahClub = jumlahClub;
        liga = new ArrayList<>();
        pertandingan = new ArrayList<>();
        input = new Scanner(System.in);
        displayMenu();
    }

    private void displayMenu() {

        while (true) {
            System.out.println("\n      Menu: ");
            System.out.println("\t1.Tambah Team (tekan 1)");
            System.out.println("\t2.Hapus Team (tekan 2)");
            System.out.println("\t3.Statistik Team (tekan 3)");
            System.out.println("\t4.Klasemen Liga (tekan 4)");
            System.out.println("\t5.Tambah Pertandingan (tekan 5)");
            System.out.println("\t6.Tampilkan Kelender dan Cari Pertandingan (tekan 6)");
            System.out.print("Pilih: ");
            String line = input.nextLine();
            int pilih = 0;
            try {
                pilih = Integer.parseInt(line);
            } catch (Exception e) {
            }

            switch (pilih) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    deleteTeam();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    displayKlasemen();
                    break;
                case 5:
                    tambahPertandingan();
                    break;
                case 6:
                    displayCalender();
                    break;
                default:
                    System.out.println("Wrong pilih");
            }

        }
    }

    private void addTeam() {
        if (liga.size() == jumlahClub) {
            System.out.println("Tidak Dapat menambah Team");
            return;
        }

        Club club = new Club();
        System.out.println("Masukkan Nama Club: ");
        String line = input.nextLine();
        club.setName(line);

        if (liga.contains(club)) {
            System.out.println("Club sudah terdaftar");
            return;
        }
        System.out.println("Masukkan Daerah Asal Club: ");
        line = input.nextLine();
        club.setlokasiPertandinganClub(line);
        liga.add(club);
    }

    private void deleteTeam() {
        System.out.println("Masukkan nama club: ");
        String line = input.nextLine();
        for (Club club : liga) {
            if (club.getName().equals(line)) {
                liga.remove(club);
                System.out.println("Club " + club.getName() + " berhasil dihapus");
                return;
            }
        }
        System.out.println("Club Tidak Ada");
    }

    private void displayStatistics() {

        System.out.println("Masukkan nama club: ");
        String line = input.nextLine();
        for (Club club : liga) {
            if (club.getName().equals(line)) {
                System.out.println("\t\tClub " + club.getName() + " Menang\t: " + club.getmenang());
                System.out.println("\t\tClub " + club.getName() + " Kalah\t\t: " + club.getkalah());
                System.out.println("\t\tClub " + club.getName() + " Seri\t\t: " + club.getseri());
                System.out.println("\t\tClub " + club.getName() + " Jumlah Goal\t: " + club.getgoal());
                System.out.println("\t\tClub " + club.getName() + " Kebobolah\t: " + club.getbobol());
                System.out.println("\t\tClub " + club.getName() + " poin\t\t:" + club.getpoin());
                System.out.println("\t\tClub " + club.getName() + " Pertandingan\t: " + club.getmatchPertandingan());
                return;
            }
        }
        System.out.println("Club tidak ditemukan");
        
    }

    private void displayKlasemen(){
        try{
            Collections.sort(liga, new PembandingClub());
            for (Club club : liga) {
                System.out.println("\t\tClub: " + club.getName() + " Poin: " + club.getpoin() + " Skore: " + (club.getgoal() - club.getbobol()));
            }

        } catch (Exception e) {
            System.out.println("Belum ada pertandingan");
        }
    }

    private void tambahPertandingan() {
        System.out.println("Masukkan tanggal (format mm-dd-yyyy): ");
        String line = input.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(line);
        } catch (ParseException ex) {
            System.out.println("masukkan tanggal main mm-dd-yyyy");
            return;
        }
        System.out.println("Home Team: ");
        line = input.nextLine();
        Club home = null;
        for (Club club : liga) {
            if (club.getName().equals(line))
                home = club;
        }
        if (home == null) {
            System.out.println("Club tidak ditemukan");
            return;
        }
        System.out.println("Away Team: ");
        line = input.nextLine();
        Club away = null;
        for (Club club : liga) {
            if (club.getName().equals(line))
                away = club;
        }
        if (away == null) {
            System.out.println("Club tidak ditemukan");
            return;
        }

        System.out.println("Home Team goal: ");
        line = input.nextLine();
        int homeGoals = -1;
        try {
            homeGoals = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (homeGoals == -1) {
            System.out.println("Masukkan skor Team Home!!!");
            return;
        }

        System.out.println("Away Team goal: ");
        line = input.nextLine();
        int awayGoals = -1;
        try {
            awayGoals = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (awayGoals == -1) {
            System.out.println("Masukkan skor Team Away!!!");
            return;
        }

        Pertandingan tanding = new Pertandingan();
        tanding.setDate(date);
        tanding.setteamHome(home);
        tanding.setteamAway(away);
        tanding.setteamHomeScore(awayGoals);
        tanding.setteamAwayScore(homeGoals);
        pertandingan.add(tanding);
       
        home.setgoal(home.getgoal() + homeGoals);
        away.setgoal(away.getgoal() + awayGoals);
        home.setSkorBobol(home.getbobol() + awayGoals);
        away.setSkorBobol(away.getbobol() + homeGoals);
        home.setmatchPertandingan(home.getmatchPertandingan() + 1);
        away.setmatchPertandingan(away.getmatchPertandingan() + 1);

        if (homeGoals > awayGoals) {
            home.setpoin(home.getpoin() + 3);
            home.setmenang(home.getmenang() + 1);
            away.setkalah(away.getkalah() + 1);
        }

        else if (homeGoals < awayGoals) {
            away.setpoin(away.getpoin() + 3);
            away.setmenang(away.getmenang() + 1);
            home.setkalah(home.getkalah() + 1);
        } else {
            home.setpoin(home.getpoin() + 1);
            away.setpoin(away.getpoin() + 1);
            home.setseri(home.getseri() + 1);
            away.setseri(away.getseri() + 1);
        }
    }

    private void displayCalender() {

        System.out.println("Tahun: ");
        String line = input.nextLine();
        int Y = -7777;
        try { 
            Y = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (Y == -7777) {
            System.out.println("Masukkan Tahun!!!");
            return;
        }

        System.out.println("Bulan: ");
        line = input.nextLine();
        int M = 0;
        try {
            M = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (M == 0) {
            System.out.println("Masukkan bulan!!!");
            return;
        }

        String[] bulan = {
                "",
                "Januari", "Februari", "Maret",
                "April", "Mei", "Juni",
                "Juli", "Agustus", "September",
                "Oktober", "November", "Desember"
        };

        int[] hari = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (M == 2 && isTahunKabisat(Y))
            hari[M] = 29;

        System.out.println("    " + bulan[M] + " " + Y);
        System.out.println("M  S  S  R  K  J  S");

        int d = hari(M, 1, Y);
        

        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= hari[M]; i++) {
            if (i < 10)
                System.out.print(i + "  ");
            else
                System.out.print(i + " ");
            if (((i + d) % 7 == 0) || (i == hari[M]))
                System.out.println();
        }

        System.out.println("Enter hari: ");
        line = input.nextLine();
        int D = 0;
        try {
            D = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (D == 0 || hari[M] < D) {
            System.out.println("masukkan hari!!!");
            return;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Y, M - 1, D);
        for (Pertandingan m : pertandingan) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(m.getDate());
            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                    || cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
                System.out.println(m.getteamHome().getName() + " " + m.getteamHomeScore() + " : " + m.getteamAwayScore() + " "
                        + m.getteamAway().getName());
            }
        }
    }
    
    public boolean isTahunKabisat(int year) {

        if ((year % 4 == 0) && (year % 100 != 0))
            return true;
        if (year % 400 == 0)
            return true;
        return false;
    }
    public int hari(int M, int D, int Y) {
        int y = Y - (14 - M) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = M + 12 * ((14 - M) / 12) - 2;
        int d = (D + x + (31 * m) / 12) % 7;
        return d;
    }

}
