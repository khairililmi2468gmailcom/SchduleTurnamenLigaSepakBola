
import java.util.Comparator;

public class PembandingClub implements Comparator<Club> {

    @Override
    public int compare(Club c1, Club c2) {

        if (c1.getpoin() > c2.getpoin())
            return -1;
        else if (c1.getpoin() < c2.getpoin())
            return 1;
        else {
            int goalc1 = c1.getgoal() - c2.getbobol();
            int goalc2 = c1.getgoal() - c2.getbobol();
            if (goalc1 > goalc2)
                return -1;
            else if (goalc1 < goalc2) {
                return 1;
            } else {
                return 0;
            }
        }

    }
}
