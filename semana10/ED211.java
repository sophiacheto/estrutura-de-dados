package semana10;

import java.util.Scanner;

import uteis.ArvoresBinarias.BTNode;
import uteis.ArvoresBinarias.BTree;

public class ED211 {
    
    public static int countEven(BTree<Integer> t) {
        return (evens(t.getRoot()));
    }

    private static int evens(BTNode<Integer> n) {
        if (n == null) return 0;
        if ((n.getValue()%2)!=0) return evens(n.getLeft()) + evens(n.getRight());
        return 1 + evens(n.getLeft()) + evens(n.getRight());
    }


      public static void main(String[] args) {
      Scanner scan = new Scanner("8 91 47 N N N 55 22 N N 40 N N");

      BTree<Integer> tree = BTree.readIntTree(scan);

      // tree.printPreOrder();

      // System.out.println(tree.numberLeafs());
      // System.out.println(tree.depth());
      // System.out.println(tree.strict());

      // System.out.println(tree.path("ED"));

      System.out.println(countEven(tree));
   }

}
