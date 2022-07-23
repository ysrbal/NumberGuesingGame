import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100);
        int right = 0;
        int[] guess = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while (right < 5) {
            System.out.print("Tahmininizi Giriniz : ");
            int selected = inp.nextInt();
            if (selected < 0 || selected > 99) {
                System.out.println("Hatali Bir Deger Girdiniz. Lutfen 0-100 arasinda bir sayi giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Cok fazla hatali giris yaptiniz. Kalan Hakkiniz : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Tekrar hatali giris yaptiginiz takdirde hakkinizdan düsecektir.");
                }
                continue;
            }
            if (selected == number) {
                System.out.println("Tebrikler Tahmininiz Dogrudur. Tahmin Ettiginiz Sayi : " + number);
                isWin = true;
                break;
            } else {
                if (selected > number) {
                    System.out.println(selected + " sayisi, gizli sayidan buyuktur.");
                } else {
                    System.out.println(selected + " sayisi gizli sayidan kucuktur.");
                }

                guess[right++] = selected;
                System.out.println("Kalan Hakkiniz : " + (5 - right));

            }
        }
        if (!isWin) {
            System.out.println("Kaybettiniz. Tahmin etmeye calistiginiz sayi : " + number);
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(guess));
            }
        }
    }
}
