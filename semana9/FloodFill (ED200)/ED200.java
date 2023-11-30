package semana9.FloodFill;

import java.util.Scanner;

public class ED200 {
   static int rows;            // Numero de linhas
   static int cols;            // Numero de colunas   
   static char m[][];          // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
      if (visited[y][x]) return 0;  // Caso base: celula ja visitada
      if (m[y][x] == '.') return 0; // Caso base: celula vazia
      int count = 1;        // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y-1, x);   // Adicionando celulas nao vizinhas
      count += t(y+1, x);
      count += t(y, x+1);
      count += t(y, x-1);
      count += t(y - 1, x - 1);
      count += t(y + 1, x + 1);
      count += t(y + 1, x - 1);
      count += t(y - 1, x + 1);
      return count;
   }
   
   static int max() {
        int max = 0;
        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++) {
                if (!visited[i][j]) {
                    int qtd = t(i,j);
                    max = Math.max(max, qtd);
                }
            }
        return max;
   }
   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int repetitions = in.nextInt();

      for (int n=0; n<repetitions; n++) {

        // Leitura de uma matriz de caracteres
        rows = in.nextInt();
        cols = in.nextInt();
        m = new char[rows][cols];
        visited = new boolean[rows][cols];
        for (int i=0; i<rows; i++)
            m[i] = in.next().toCharArray();

    
        
        System.out.println(max());
      }
   }

   
}