import java.util.Scanner;

public class Losango {
    static void fig(int n) {
        int i = 1;
        while (i<=n-1) {
            System.out.print(".".repeat((n-i)/2));
            System.out.print("#".repeat(i));
            System.out.println(".".repeat((n-i)/2));
            i+=2;
        }
        while (i>0) {
            System.out.print(".".repeat((n-i)/2));
            System.out.print("#".repeat(i));
            System.out.println(".".repeat((n-i)/2));
            i-=2;
        }}



    public static void main(String[] args) {	
        Scanner scan = new Scanner(System.in);
        fig(scan.nextInt());
        }
}
