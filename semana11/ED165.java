package semana11;

import java.util.Scanner;

public class ED165 {

    static boolean possibilidades(int v[], int result) {
        for (int i : v) {
            for (int j : v)
                if (i+j==result) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tamanho = scan.nextInt();
        scan.nextLine();

        int[] conjunto = new int[tamanho];
        for (int i=0; i<tamanho; i++)
            conjunto[i] = scan.nextInt();

        scan.nextLine();
        int qtdpossiveis = scan.nextInt();
        scan.nextLine();

        int[] possiveis = new int[qtdpossiveis];
        for (int i=0; i<qtdpossiveis; i++)
            possiveis[i] = scan.nextInt();


        for (int testar : possiveis)
            if (possibilidades(conjunto, testar)) System.out.println(testar + ": " + "sim");
            else System.out.println(testar + ": " + "nao");
    }
}
