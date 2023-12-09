package uteis.Arvores;

import java.util.Scanner;

import uteis.Filas.LinkedListQueue;
import uteis.Filas.MyQueue;
import uteis.Pilhas.LinkedListStack;
import uteis.Pilhas.MyStack;

public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   // ----------------------------

   // Ler uma árvore
   public static BTree<Integer> readIntTree(Scanner in) {
      BTree<Integer> t = new BTree<Integer>();
      t.setRoot(readIntNode(in));
      return t;
   }
   
   private static BTNode<Integer> readIntNode(Scanner in) {
      String s = in.next();
      if (s.equals("N")) return null;
      Integer value = Integer.parseInt(s);
      BTNode<Integer> left = readIntNode(in);
      BTNode<Integer> right = readIntNode(in);
      return new BTNode<Integer>(value, left, right);
   }

//  -----------------------

   public int numberLeafs() {
      return numberLeafs(root);
   }

   private int numberLeafs(BTNode<T> n) {
      if (n.getLeft() == null && n.getRight() == null) return 1;
      if (n.getLeft() == null) return numberLeafs(n.getRight());
      if (n.getRight() == null) return numberLeafs(n.getLeft());
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
   }

   public boolean complete() {
      return (numberLeafs() == Math.pow(2, depth()));
   }

   public boolean strict() {
      return strict(root);
   }

   private boolean strict(BTNode<T> n) {
      if (n.getLeft() == null && n.getRight() == null) return true;
      if (n.getLeft() == null && n.getRight() != null) return false;
      if (n.getLeft() != null && n.getRight() == null) return false;
      return strict(n.getLeft()) && strict(n.getRight());
   }

   public T path(String s) {
      char[] path = s.toCharArray();
      BTNode<T> current = root;

      for (char direction : path) {
         switch (direction) {
            case 'R':
               return current.getValue();
            case 'E':
               current = current.getLeft();
               break;
            case 'D':
               current = current.getRight();
               break;
         }
      }

      return current.getValue();
   }

   public int nodesLevel(int k) {
      if (k==0) return 1;
      int[] count = {0};
      int nivelPai = k-1;
      numeroDeFilhos(nivelPai, 0, count, root);
      return count[0];
   }

   private void numeroDeFilhos(int max, int currentlevel, int[] count, BTNode<T> n) {
      if (currentlevel==max) {
         if (n.getLeft() != null) count[0] += 1;
         if (n.getRight() != null) count[0] += 1;
         return;
      }
      if (n.getLeft() == null && n.getRight() == null) return;
      if (n.getLeft() == null) {;
         numeroDeFilhos(max, currentlevel+1, count, n.getRight());
         return;
      }
      if (n.getRight() == null) {
         numeroDeFilhos(max, currentlevel+1, count, n.getLeft());
         return;
      }
      numeroDeFilhos(max, currentlevel+1, count, n.getRight());
      numeroDeFilhos(max, currentlevel+1, count, n.getLeft());
   }

   public int nodesLevelRobert(int k){
      return calculateNodesLevel(root, k);
   }

   private int calculateNodesLevel(BTNode<T> n, int k){
         if(k==0) return 1;
         if(n.getLeft()==null && n.getRight()!=null) return calculateNodesLevel(n.getRight(), k-1);
         if(n.getLeft()!=null && n.getRight()==null) return calculateNodesLevel(n.getLeft(), k-1);
         if(n.getLeft()==null && n.getRight()==null) return 0;
         return calculateNodesLevel(n.getRight(), k-1) + calculateNodesLevel(n.getLeft(), k-1);
   }



   public static void main(String[] args) {
      Scanner scan = new Scanner("55 N 3 45 53 N N 15 N N 73 85 N N 15 N N");

      BTree<Integer> tree = readIntTree(scan);
      // tree.printPreOrder();

      // System.out.println(tree.numberLeafs());
      // System.out.println(tree.depth());
      // System.out.println(tree.strict());

      // System.out.println(tree.path("ED"));

      System.out.println(tree.nodesLevel(5));
      System.out.println(tree.nodesLevelRobert(5));
   }
}