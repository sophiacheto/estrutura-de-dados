import java.util.Arrays;
import java.util.Scanner;

public class JogoDoGalo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimensao = scan.nextInt();
        scan.nextLine();
        String matriz[][] = read(scan, dimensao);

        //printar(matriz, dimensao);

        checar(matriz);
    
    }



       private static String[][] read(Scanner in, int dimensao) {
            String matriz[][] = new String[dimensao][dimensao];
            String linhas[] = new String[dimensao];

            // criar lista em que cada elemento é uma linha da matriz
            for (int i=0; i<dimensao; i++) {
                linhas[i] = in.nextLine();
                // criar lista de elementos da linha
                String nova[] = linhas[i].split("");
                matriz[i] = nova;
            }

            return matriz;
        }    
        

        public static void printar(String[][] data, int dimensao) {
            String ans = "";
            for (int i=0; i<dimensao; i++) {
               for (int j=0; j<dimensao; j++)
                  ans += data[i][j] + " ";
               ans += "\n";
            }
            System.out.println(ans);
         }


        public static boolean searchPonto(String [][] matriz) {
            for (int i=0; i<matriz.length; i++) {
               for (int j=0; j<matriz.length; j++) {
                    if (matriz[i][j].equals("."))
                        return true;
               }
            }
            return false;
        }



        public static boolean checkLine(String[] linha) {
            String primeiro = linha[0];
            if (primeiro.equals("."))
                return false;
            else {
                for (String charac : linha) {
                    if (!charac.equals(primeiro))
                        return false;
                }
                System.out.println("Ganhou o " + primeiro);
                return true;
            }
        }         

        public static boolean checkDiagonalPrincipal(String[][] matriz) {
            String primeiro = matriz[0][0];
            if (primeiro.equals("."))
                return false;
            else {
                for (int i=0; i<matriz.length; i++) {
                    String charac = matriz[i][i];
                    if (!charac.equals(primeiro))
                        return false;
                }
                System.out.println("Ganhou o " + primeiro);
                return true;
            }
        }


        public static boolean checkDiagonalSec(String[][] matriz) {
            String primeiro = matriz[0][matriz.length-1];
            if (primeiro.equals("."))
                return false;
            else {
                for (int i=0; i<matriz.length; i++) {
                    String charac = matriz[i][matriz.length-1-i];
                    if (!charac.equals(primeiro))
                        return false;
                }
                System.out.println("Ganhou o " + primeiro);
                return true;
            }
        }


        public static boolean checkColunaN(String[][] matriz, int n) {
            String primeiro = matriz[0][n];
            if (primeiro.equals("."))
                return false;
            else {
                for (int i=0; i<matriz.length; i++) {
                    String charac = matriz[i][n];
                    if (!charac.equals(primeiro))
                        return false;
                }
                System.out.println("Ganhou o " + primeiro);
                return true;
            }
        }


        public static boolean checar(String[][] matriz) {
            for (String[] linha : matriz) 
                if (checkLine(linha))
                    return true;

            for (int i=0; i<matriz.length; i++) 
                if (checkColunaN(matriz, i))
                    return true;

            if (checkDiagonalPrincipal(matriz))
                return true;
            else if (checkDiagonalSec(matriz))
                return true;
            else if (searchPonto(matriz))
                System.out.println("Jogo incompleto");
            else
                System.out.println("Empate");
            return false;
            
    
                
        }

//         String[][] matrix = new String[dimensao][dimensao];


//         for (int i=0; i<linhas.length; i++) {
//             String linha = linhas[i];
//             //checkLine(linha);
//             String nova[] = linha.split("");
//             matrix[i] = nova;

//             System.out.println(Arrays.toString(matrix));            
//         }        
        
//         for (int i=0; i<rows; i++)
//            for (int j=0; j<cols; j++)
//               matriz[i][j] = in.nextInt();
//      }

    

//     private boolean checkLineN(int[][] matriz, int n) {
//         int linha [] = matriz[n];
//         int numero = linha[0];
//         for (int novo : linha)
//             if (novo != numero)
//                 return false;
//         return true;
//     }

//     private boolean checkColN(int[][] matriz, int n) {
//         int dimensao = matriz.length;
//         int coluna [] = new int[dimensao];

//         for (int i=0; i<dimensao; i++) 
//             coluna[i] = matriz[i][n];
        
//         int numero = coluna[0];
//         for (int novo : coluna)
//             if (novo != numero)
//                 return false;
//         return true;
//     }
  
}
