package semana10;

import java.util.ArrayList;
import java.util.Scanner;

import uteis.Arvores.BTNode;
import uteis.Arvores.BTree;

public class ED213 {
    public static String maxSum(BTree<Integer> tree) {
      int maior = 0;
      String melhor = "";

      for (String path : paths(tree)) {
         int current = sumPath(path, tree);
         if (current > maior) {
               maior = current; 
               melhor = path;
         }
      }

      return melhor;
    }


   //  SÓ FUNCIONA PARA CAMINHOS QUE CHEGUEM ATÉ O ÚLTIMO NÍVEL:
   // static ArrayList<String> paths(BTree<Integer> tree) {
   //  ArrayList<String> resultados = new ArrayList<>();
   //  int altura = tree.depth();
   //  char used[] = new char[altura];
   //  goSets(0, altura, used, resultados); // chamar funcao recursiva
   //  return resultados;
   // }


   static ArrayList<String> paths(BTree<Integer> tree) {
    ArrayList<String> resultados = new ArrayList<>();
    int altura = tree.depth();
    for (int i=1; i<=altura; i++)
      goSets(0, i, new char[i], resultados); // gera todos os caminhos, parando na raiz até parando só no último nível
    return resultados;
   }


  static void goSets(int cur, int v, char used[], ArrayList<String> resultados) {
    if (cur == v) {  // Caso base: terminamos o conjunto
       resultados.add(new String(used)); // adiciona ao array a nova opção de caminho
    } else {      
       // Se nao terminamos, continuar a gerar
       used[cur] = 'E';      // Subconjuntos que incluem o elemento actual
       goSets(cur+1, v, used, resultados);// Chamada recursiva
       used[cur] = 'D';     // Subconjuntos que nao incluem o el. actual
       goSets(cur+1, v, used,resultados);// Chamada recursiva
    }
 }

 
    public static int sumPath(String s, BTree<Integer> t) {
      char[] path = s.toCharArray();
      BTNode<Integer> current = t.getRoot();
      int sum = t.getRoot().getValue();

      for (char direction : path) {
        if (current == null) break;

         switch (direction) {
            case 'R':
               return sum;
            case 'E':
               current = current.getLeft();
               sum += current == null ? 0 : current.getValue();
               break;
            case 'D':
               current = current.getRight();
               sum += current == null ? 0 : current.getValue();
               break;
         }
      }

      return sum;
   }

 public static void main(String[] args) { 
    Scanner scan = new Scanner("14 4 3 N N 9 7 5 N N N N 18 16 15 N N 17 N N 20 N N");

    BTree<Integer> tree = BTree.readIntTree(scan);

    System.out.println(maxSum(tree));
 }
}
