package semana11;

import java.util.Scanner;

import uteis.ArvoresBinariasPesquisa.BSTree;

public class ED164 {
    public static void main(String[] args) {
        BSTree<String> tree = new BSTree<>();
        Scanner scan = new Scanner(System.in);

        int qtd = scan.nextInt();

        for (int i=0; i<qtd; i++) 
            tree.insert(scan.next());

        System.out.println(tree.numberNodes());
    }
}
