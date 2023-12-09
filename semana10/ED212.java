package semana10;

import java.util.Arrays;
import java.util.Scanner;

import uteis.Arvores.BTNode;
import uteis.Arvores.BTree;

public class ED212 {

    public static int[] sumLevels(BTree<Integer> t) {
        int numlevels = t.depth();
        int[] somas = new int[numlevels+1];
        
        for (int i=0; i<=numlevels; i++)
            somas[i] = calculateSumLevel(t.getRoot(), i);
        return somas;
    }

    private static int calculateSumLevel(BTNode<Integer> n, int k){
        if(k==0) return n.getValue();
        if(n.getLeft()==null && n.getRight()!=null) return calculateSumLevel(n.getRight(), k-1);
        if(n.getLeft()!=null && n.getRight()==null) return calculateSumLevel(n.getLeft(), k-1);
        if(n.getLeft()==null && n.getRight()==null) return 0;
        return calculateSumLevel(n.getRight(), k-1) + calculateSumLevel(n.getLeft(), k-1);
    }

       public static void main(String[] args) {
      Scanner scan = new Scanner("14 4 3 N N 9 7 5 N N N N 18 16 15 N N 17 N N 20 N N");

      BTree<Integer> tree = BTree.readIntTree(scan);
      // tree.printPreOrder();

      // System.out.println(tree.numberLeafs());
      // System.out.println(tree.depth());
      // System.out.println(tree.strict());

      // System.out.println(tree.path("ED"));

      System.out.println(Arrays.toString(sumLevels(tree)));
      }
}
