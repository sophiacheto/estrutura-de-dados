package semana7.ED006;

public class CircularLinkedList<T> {
    Node<T> last;
    int size;

    CircularLinkedList() {
        this.last = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return last.getNext().getValue();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return last.getValue();
    }

    public void rotate() {
        if (!isEmpty())
            last = last.getNext();
    }

    public void addFirst(T value) {
        if (isEmpty()) {
            last = new Node <T>(value, null);
            last.setNext(last);
        }
        else {
            Node<T> novo = new Node<T>(value, last.getNext());
            last.setNext(novo);
        }
        size++;
    }

    public void addLast(T value) {
        addFirst(value);
        last = last.getNext();
    }

    public void removeFirst() {
        if (isEmpty()) return;
        if (size==1) last = null;
        else last.setNext(last.getNext().getNext());
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) last = null;
        else {
            Node<T> cur = last;
            for ( int i=0; i<size-1; i++)
                cur = cur.getNext();  // penultimo nó
            // last = cur;
            // last.setNext(last.getNext().getNext());
            cur.setNext(last.getNext());
            last = cur;
        }
        size--;
    }

    public String toString () {
        String str = "{";
        if (! isEmpty ()) {
            Node <T> cur = last.getNext ();
            for (int i=0; i<size; i++) {
                str += cur.getValue ();
                if (cur != last) str += ",";
                cur = cur.getNext ();
            }
        }
        str += "}";
        return str;
    }
        
    public static void main(String[] args) {
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();

        lista.addFirst(1);
        lista.addLast(2);

        System.out.println(lista);

        lista.removeLast();

        System.out.println(lista);
    }

}
