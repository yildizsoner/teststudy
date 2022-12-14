import javax.swing.text.NumberFormatter;
import java.util.Scanner;

public class BurakQuestion01 {

    public static void main(String[] args) {
        burakMethod();
    }
    /*
    Task:

     */

    public static void burakMethod() {
        Scanner input = new Scanner (System.in);
        do {
            System.out.println("Lutfen bir sayi giriniz");
            double sayi = input.nextDouble();
            sayi= (4-sayi);
            sayi= (sayi);
            sayi= (sayi+3/4);
            if(sayi%1==0) {
                System.out.println(sayi);
                break;
            }

        }while(true);

    }
}
