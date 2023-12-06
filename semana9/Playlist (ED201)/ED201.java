import java.util.Scanner;

public class ED201 {

    // Escrever todos os subconjuntos do array v[]
        static int melhorOpcao(int v[], int max) {
            // array de booleanos para representar o conjunto
            boolean used[] = new boolean[v.length];
            int [] melhor = new int[1];
            return goSets(0, v, used, max, melhor); // chamar funcao recursiva
        }

 // Gera todos os subconjuntos a partir da posicao 'cur'
        static int goSets(int cur, int v[], boolean used[], int max, int[] melhor) {
            int tamanhoIndividual = 0;
            if (cur == v.length) {  // Caso base: terminamos o conjunto
            for (int i=0; i<v.length; i++) 
                if (used[i]) tamanhoIndividual += v[i];
            if (tamanhoIndividual <= max && tamanhoIndividual > melhor[0]) melhor[0] = tamanhoIndividual;
            return melhor[0];
            } else {                  // Se nao terminamos, continuar a gerar
            used[cur] = true;      // Subconjuntos que incluem o elemento actual
            int tent1 = goSets(cur+1, v, used, max, melhor);
            used[cur] = false;     // Subconjuntos que nao incluem o el. actual
            int tent2 = goSets(cur+1, v, used, max, melhor);
            return Math.max(tent1, tent2);
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int maximo = scan.nextInt();
            int[] musicas = new int[scan.nextInt()];

            scan.nextLine();

            for (int i=0; i<musicas.length; i++)
                musicas[i] = scan.nextInt();

            System.out.println(melhorOpcao(musicas, maximo));
        }
}