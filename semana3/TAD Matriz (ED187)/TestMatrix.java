import java.util.Random;
import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   Matrix(int r, int c, int min, int max) {
      Random rand = new Random();
      data = new int[r][c];
      rows = r;
      cols = c;
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = rand.nextInt(min, max+1);
         // data[i][j] = rand.nextInt(max+1) + min;   // para a versão 11 do Java
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }

   
    public int[][] dados() {
      return data;
   }

   // cria uma matriz identidade
    public static Matrix identity(int n) {
        Matrix identidade = new Matrix(n, n);
        
        for (int i=0; i<n; i++)
         for (int j=0; j<n; j++)
            if (i==j)
                identidade.data[i][j] = 1;

        return identidade;
    }
    

    public Matrix transpose() {
        Matrix transposta = new Matrix(cols, rows);

        for (int i=0; i<cols; i++)
            for (int j=0; j<rows; j++)
               transposta.data[i][j] = data[j][i];

      return transposta;
    }


    public Matrix sum(Matrix m) {
      Matrix nova = new Matrix(rows, cols);

      for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++) 
               nova.data[i][j] = m.data[i][j] + data[i][j];

      return nova;
    }


    public Matrix multiply(Matrix m) {
      Matrix nova = new Matrix(rows, m.cols);
      int elemento;

      for (int i=0; i<rows; i++)
         for (int j=0; j<m.cols; j++) {
            elemento = 0;
            for (int r=0; r<cols; r++)
               elemento += (data[i][r] * m.data[r][j]);
            nova.data[i][j] += elemento;
         }

      return nova;
    }
}


 public class TestMatrix {
    public static void main(String[] args) {
      Matrix aleatoria = new Matrix(5, 3, 0, 10);
      System.out.println(aleatoria);
    }}
//       Scanner stdin = new Scanner(System.in);

//       Matrix m1 = Matrix.identity(5);
//       System.out.println("m1:");
//       System.out.println(m1);
      
//       Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
//       m2.read(stdin);
//       System.out.println("m2:");
//       System.out.println(m2);
//       Matrix m3 = new Matrix(stdin.nextInt(), stdin.nextInt());
//       m3.read(stdin);
//       System.out.println("m3:");
//       System.out.println(m3);
//       Matrix m4 = new Matrix(stdin.nextInt(), stdin.nextInt());
//       m4.read(stdin);
//       System.out.println("m4:");
//       System.out.println(m4);

//       Matrix m5 = m1.transpose();
//       System.out.println("m5:");
//       System.out.println(m5);
//       Matrix m6 = m2.transpose();
//       System.out.println("m6:");
//       System.out.println(m6);

//       Matrix m7 = m2.sum(m3);
//       System.out.println("m7:");
//       System.out.println(m7);

//       Matrix m8 = m2.multiply(m4);
//       System.out.println("m8:");
//       System.out.println(m8);
//    }
// }