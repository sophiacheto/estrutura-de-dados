import java.text.DecimalFormat;
import java.util.Scanner;


// ATENÇÃO: AINDA NÃO FUNCIONA; NÃO ESTÁ FINALIZADO
public class ED202 {
    static boolean primeiraVez = true;
    static double melhor;
    static double[][] mapa;

    public static void comecar(int n, Scanner scan) {
        mapa = new double[n][n];
        for (int i=0; i<n; i++)
           for (int j=0; j<n; j++)
                mapa[i][j] = scan.nextDouble();
    }


    static void permutations(int lugares[]) {
        DecimalFormat df = new DecimalFormat("0.00");
        boolean used[] = new boolean[lugares.length]; // $i$ esta na permutacao?
        int perm[] = new int[lugares.length];         // permutacao actual
        goPerm(0, lugares, used, perm); // chamar funcao recursilugaresa
        System.out.println(df.format(melhor));
    }

    public static double fazerCaminho(int[] permutacao) { // llista em que o elemento 1 é o primeiro destino
        double tempo = 0.00;
        int anterior = permutacao[0];
        for (int lugar : permutacao) {
            tempo += mapa[anterior][lugar];
            anterior = lugar;
        }
        tempo += mapa[anterior][0];
        if (primeiraVez) {
            melhor = tempo;
            primeiraVez = false;
        }
        return tempo;
    }

        // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int lugares[], boolean used[], int perm[]) {
        int[] permutacao = new int[lugares.length];    // ordem atual dos lugares que está sendo gerada
        if (cur == lugares.length) { // Caso base: terminamos a permutacao
            for (int i = 0; i < lugares.length; i++) 
                permutacao[i] = lugares[perm[i]];    // adicionar o iesimo destino à ordem
            if (permutacao[0] == 0) {
                double tempo = fazerCaminho(permutacao);
                if (tempo < melhor)
                    melhor = tempo;
            }
        } else { // Se nao terminamos, continuar a gerar
            for (int i = 0; i < lugares.length; i++) // Tentar todos os elementos
                if (!used[i]) {
                    used[i] = true;
                    perm[cur] = i;
                    goPerm(cur + 1, lugares, used, perm);
                    used[i] = false;
                }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int qtd = scan.nextInt();
        scan.nextLine();
        scan.nextLine();


       int[] lugares = new int[qtd];
        for (int i=0; i<qtd; i++)
            lugares[i] = i;

        comecar(qtd, scan);


        permutations(lugares);
    }
}
