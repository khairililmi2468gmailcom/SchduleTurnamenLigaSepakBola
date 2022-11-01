
import java.util.Scanner;

/**
 *
 * @author Khairil ilmi
 */
public class SketBola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        try{
            System.out.print("Masukkan berapa club untuk liga: ");
            int jmlClub = input.nextInt();
           Liga plm = new Liga(jmlClub);
           input.close();

       } catch(Exception e){
            System.out.println("Harus input");
       }
       input.close();
    }
    
}
