import java.util.Arrays;
import java.util.Scanner;

public class Pizza {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRestricoes = scan.nextInt();  // numero de ingredientes que o mario nao gosta
        String restricoes [] = new String[numRestricoes]; // criar lista para os ingredientes que o mario nao gosta

        for (int i=0; i<numRestricoes; i++)
            restricoes[i] = scan.next(); // adicionar ingredientes que o mario nao gosta

        int qtdPizzas = scan.nextInt(); // numero de pizzas que podem ser pedidas
        scan.nextLine();

        // System.out.println(Arrays.toString(restricoes));

        while (scan.hasNextLine()) {
            scan.next();
            String pedido = scan.nextLine();
            // System.out.println(pedido);
            if (!pizzaOK(restricoes, pedido))
                qtdPizzas -= 1;
        }
    
        System.out.println(qtdPizzas);
    }
    

    static boolean pizzaOK (String [] restricoes, String pedido) {
        String [] ingredientes = pedido.split(" ");
        for (String ingredienteProibido : restricoes) {
            for (String ing : ingredientes)
                if (ing.equals(ingredienteProibido))
                    return false;
        }
        return true;
    }
}

