package semana7.ED006;

import java.util.Scanner;

public class PimPamPum {

    public void rodada(Scanner scan) {
        CircularLinkedList<String> pessoas = new CircularLinkedList<>();

        String[] frase = scan.nextLine().split(" ");
        int n = scan.nextInt(); // número de pessoas
        
        for (int i=0; i<n; i++) {
            String pessoa = scan.next();
            pessoas.addLast(pessoa);
        }

        
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

    }
}
