import java.util.Arrays;
import java.util.Scanner;

public class PizzaSurtando {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRestricoes = scan.nextInt();  // numero de ingredientes que o mario nao gosta
        String restricoes [] = new String[numRestricoes]; // criar lista para os ingredientes que o mario nao gosta

        for (int i=0; i<numRestricoes; i++)
            restricoes[i] = scan.next(); // adicionar ingredientes que o mario nao gosta

        System.out.println("nao pode " + Arrays.toString(restricoes));

        int qtdPizzas = scan.nextInt(); // numero de pizzas que podem ser pedidas
        scan.nextLine();

        System.out.println(qtdPizzas);

        while (scan.hasNextLine()) {
            int qtdIngredientes = scan.nextInt();
            String pedido [] = new String[qtdIngredientes];
            for (int i=0; i<qtdIngredientes; i++) {
                pedido[i] = scan.next();
            }
            for (String ingredienteProibido : restricoes) {
                if (Arrays.asList(pedido).contains(ingredienteProibido)) {
                    System.out.println("tem " + ingredienteProibido);
                    qtdPizzas -= 1;
                    break;
                }
            }
        }


        System.out.println(qtdPizzas);
    }
}

