package semana9.ED201;

import java.util.Scanner;

public class ED201 {

    // Escrever todos os subconjuntos do array v[]
        static int melhorOpcao(int v[], int max) {
            // array de booleanos para representar o conjunto
            boolean used[] = new boolean[v.length];
            return goSets(0, v, used, max); // chamar funcao recursiva
        }

 // Gera todos os subconjuntos a partir da posicao 'cur'
        static int goSets(int cur, int v[], boolean used[], int max) {
            int tamanhoIndividual = 0;
            if (cur == v.length) {  
            for (int i=0; i<v.length; i++) 
                if (used[i]) tamanhoIndividual += v[i];           // se usa a música i, adiciona o tempo dela ao tempo total da playlist
            return tamanhoIndividual>max ? 0 : tamanhoIndividual; // tempo gasto nesse caso, que só vai ser considerado se não ultrapassar o tempo máximo
            } else {                
            used[cur] = true;      // Subconjuntos que incluem o elemento actual
            int tent1 = goSets(cur+1, v, used, max);
            used[cur] = false;     // Subconjuntos que nao incluem o el. actual
            int tent2 = goSets(cur+1, v, used, max);
            return Math.max(tent1, tent2);
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner("""
                                        1300 9
                                            243
                                            202
                                            254
                                            502
                                            385
                                            942
                                            237
                                            721
                                            192
                                            """);
            int maximo = scan.nextInt();
            int[] musicas = new int[scan.nextInt()];

            scan.nextLine();

            for (int i=0; i<musicas.length; i++)
                musicas[i] = scan.nextInt();

            System.out.println(melhorOpcao(musicas, maximo));
        }
}