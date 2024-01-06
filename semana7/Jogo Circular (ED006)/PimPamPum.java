import java.util.Scanner;

public class PimPamPum {

    public static String rodada(Scanner scan) {
        CircularLinkedList<String> pessoas = new CircularLinkedList<>();

        String[] frase = scan.nextLine().split(" ");
        int n = scan.nextInt(); // número de pessoas
        
        for (int i=0; i<n; i++) {
            String pessoa = scan.next();
            pessoas.addLast(pessoa);
        }

        for (String palavra : frase) 
            pessoas.rotate();
        
        return pessoas.getFirst();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        for (int i=0; i<numCasos; i++) {
            String pessoa = rodada(scan);
            if (pessoa.equals("Carlos")) System.out.println("O Carlos nao se livrou");
            else System.out.println("O Carlos livrou-se (coitado do " + pessoa + "!)");
        }
    }
}














class CircularLinkedList<T> {
   private Node<T> last; // Ultimo no da lista
   private int size;     // Tamanho da lista

   // Construtor (cria lista vazia)
   public CircularLinkedList() {
      last = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return last.getNext().getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      return last.getValue();
   }

   // Roda a lista (o primeiro passa a ser o novo ultimo da lista)
   public void rotate() {
      if (!isEmpty()) // Se estiver vazia nao faz nada
         last = last.getNext();
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      if (isEmpty()) {
         last = new Node<T>(v, null);
         last.setNext(last); // Apontar para si proprio em "loop"
      } else {
         Node<T> newNode = new Node<T>(v, last.getNext());
         last.setNext(newNode);
      }
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      addFirst(v);
      last = last.getNext();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      if (size == 1) last = null;
      else last.setNext(last.getNext().getNext());
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         last = null;
      } else {
         Node<T> cur = last.getNext();
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         last = cur;
         last.setNext(last.getNext().getNext());
      }
      size--;
   }
   
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      if (!isEmpty()) {
         Node<T> cur = last.getNext();
         for (int i=0; i<size; i++) {
            str += cur.getValue();
            if (cur != last) str += ",";
            cur = cur.getNext();
         }
      }         
      str += "}";
      return str;
   }
}










 class Node<T> {
   private T value;      // Valor guardado no no
   private Node<T> next; // Referencia para o proximo no da lista

   // Construtor
   Node(T v, Node<T> n) {
      value = v;
      next = n;
   }

   // Getters e Setters
   public T getValue() { return value; }
   public Node<T> getNext()  { return next; }
   public void setValue(T v) { value=v; }
   public void setNext(Node<T> n) { next = n; }
}
