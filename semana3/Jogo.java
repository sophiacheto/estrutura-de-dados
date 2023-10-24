import java.util.Arrays;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimensao = scan.nextInt();
        scan.nextLine();

        String str = "";
        while (scan.hasNext())
            str += scan.nextLine() + " ";


        str = str.replaceAll("X", "1");
        str = str.replaceAll("O", "2");
        str = str.replaceAll("\\.", "0");


        Matrix quadro = new Matrix(dimensao, dimensao);
        Scanner scann = new Scanner(str);
        quadro.read(scann);

        System.out.println(quadro);



        

    }


    // private static void read(Scanner in, int dimensao) {
    //     String linhas[] = new String[dimensao];

    //     for (int i=0; i<dimensao; i++) 
    //         linhas[i] = in.nextLine();

    


    //     System.out.println(Arrays.toString(linhas));
         
    //     String[][] matrix = new String[dimensao][dimensao];

    //     for (int i=0; i<linhas.length; i++) {
    //         String linha = linhas[i];
    //         //checkLine(linha);
    //         String nova[] = linha.split("");
    //         matrix[i] = nova;

    //         System.out.println(Arrays.toString(matrix));            
    //     }        
        
        // for (int i=0; i<rows; i++)
        //    for (int j=0; j<cols; j++)
        //       matriz[i][j] = in.nextInt();
     //}

    
    // private String checkLineN(Scanner scan) {
    //     while (scan.hasNext()) {
    //         String linha = scan.nextLine();
    //         if (linha == dimensao * 'X')
    //             return "Ganhou o X";
    //         else if (linha == dimensao * 'O')
    //             return "Ganhou o Y";
    //     }
    // }

    // private String checkDiagonal(Scanner scan) {

    // }



    // private boolean checkColN(int[][] matriz, int n) {
    //     int dimensao = matriz.length;
    //     int coluna [] = new int[dimensao];

    //     for (int i=0; i<dimensao; i++) 
    //         coluna[i] = matriz[i][n];
        
    //     int numero = coluna[0];
    //     for (int novo : coluna)
    //         if (novo != numero)
    //             return false;
    //     return true;
    // }
  
}
