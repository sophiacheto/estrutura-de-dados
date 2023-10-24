import java.util.Scanner;

public class Estatistica {

   public static void main(String[] args) {

    Scanner stdin = new Scanner(System.in);
    double n = stdin.nextInt();
    int maior = stdin.nextInt();
    int menor = maior;
    int soma = maior;

    for (int i=1; i<n; i++) { 
        int atual = stdin.nextInt();
        soma += atual;
        if (atual > maior)
            maior = atual;
        else if (atual < menor)
            menor = atual;
    }


    System.out.printf("%.2f\n", soma/n);
    System.out.println(maior-menor);
}
}
