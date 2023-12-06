package semana6;

public class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private int size;         // Tamanho da lista

    // Construtor (cria lista vazia)
    SinglyLinkedList() {
    first = null;
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
    
    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first); 
        first = newNode;
        size++;
    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null); 
        if (isEmpty()) {
        first = newNode;
        } else {
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        cur.setNext(newNode);         
        }
        size++;
    }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }

    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty()) return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
        cur = cur.getNext();
        return cur.getValue();      
    }

    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
        if (isEmpty()) return;
        first = first.getNext();
        size--;
    }

    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
        first = null;
        } else {
        // Ciclo com for e uso de de size para mostrar alternativa ao while
        Node<T> cur = first;
        for (int i=0; i<size-2; i++)
            cur = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        }
        size--;
    }
    
    // Converte a lista para uma String
    public String toString() {
        String str = "{";      
        Node<T> cur = first;
        while (cur != null) {
        str += cur.getValue();
        cur = cur.getNext();
        if (cur != null) str += ",";                     
        }      
        str += "}";
        return str;
    }

    public T get(int pos) {
        Node<T> current = first;
        if (pos>=size || pos<0)
            return null;
        for (int i=0; i<pos; i++)
            current = current.getNext();
        return current.getValue();
    }

    public T remove(int pos) {
        Node<T> current = first;
        T valor;

        if (pos>=size || pos<0)
            return null;

        size--;
        if (pos==0) {
            first = first.getNext();
            return current.getValue();            
        }
        for (int i=0; i<pos-1; i++)
            current = current.getNext(); // current = nó anterior ao que será removido
        valor = current.getNext().getValue();
        current.setNext(current.getNext().getNext());
        return valor;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        Node<T> current = this.first;

        for (int i=0; i<this.size; i++) {
            copy.addLast(current.getValue());
            current = current.getNext();
        }
        return copy;
    }

    public void duplicate() {
        Node<T> current = first;

        for (int i=0; i<size; i++) {
        current.setNext(new Node<T>(current.getValue(), current.getNext()));
        current = current.getNext().getNext();
        }

        size *= 2;
    }

    public int count(T value) {
        Node<T> current = first;
        int qtd = 0;

        for (int i=0; i<size; i++) {
            if (current.getValue().equals(value)) qtd++;
            current = current.getNext();
        }
        return qtd;
    }

    public void removeAll(T value) {
        Node<T> current = first;
        int i = 0;

        while (current != null) {
            if (current.getValue().equals(value)) remove(i);
            else i++;
            current = current.getNext();
        }
    }

    // public static void main(String[] args) {
    //     SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    //     list.addFirst(1);
    //     list.addLast(2);
    //     list.addLast(2);
    //     list.addLast(2);
    //     list.addLast(1);
    //     list.addLast(3);
    //     list.addLast(4);
    //     list.addLast(2);
    //     list.addLast(1);
    //     System.out.println(list);
    //     list.removeAll(1);
    //     list.removeAll(2);
    //     list.removeAll(3);
    //     list.removeAll(4);
    //     System.out.println(list);
    // }
}
