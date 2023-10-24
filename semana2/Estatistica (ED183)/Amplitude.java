import java.util.Scanner;

public class Amplitude {

   public static void main(String[] args) {

    Scanner stdin = new Scanner(System.in);
    int qtd = 0;
    int maior = stdin.nextInt();
    int menor = maior;

    while (stdin.hasNextInt()) { 
        int atual = stdin.nextInt();
        if (atual > maior)
            maior = atual;
        else if (atual < menor)
            menor = atual;
    }
    
    System.out.println(maior-menor);
}
}