package semana7.ED194;

public class LinkedListStack<T> implements MyStack {
    private DoublyLinkedList<T> list;

    @Override
    public void push(Object v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public Object top() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'top'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    
}

class DoublyLinkedList<T> {
    private DNode<T> first; // primeiro nó da lista
    private DNode<T> last; // ultimo nó da lista
    private int size; // tamanho da lista

    DoublyLinkedList() {
        first = new DNode<T>(null, null, null);
        last = new DNode<T>(null, null, null);
        first.setNext(last);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return(size == 0);
    }

    public T getFirst() {
        if(isEmpty()) {
            return null;
        }
        return first.getNext().getValue();
    }

    public T getLast() {
        if(isEmpty()) {
            return null;
        }
        return last.getPrev().getValue();
    }

    public void addFirst(T v) {
        addBetween(v, first, first.getNext());
    }

    public void addLast(T v) {
        addBetween(v, last.getPrev(), last);
    }

    public void addBetween(T v, DNode<T> n1, DNode<T> n2) {
        DNode<T> newNode = new DNode<T>(v, n1, n2);
        n1.setNext(newNode);
        n2.setPrev(newNode);
        size++;
    }

    public void removeFirst() {
        if(!isEmpty()) {
            remove(first.getNext());
        }
    }

    public void removeLast() {
        if(!isEmpty()) {
            remove(last.getPrev());
        }
    }

    public void remove(DNode<T> n) {
        DNode<T> prev = n.getPrev();
        DNode<T> next = n.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
    }

    public String toString() {
        String str = "{";
        DNode<T> cur = first.getNext();
        for(int i = 0; i < size; i++) {
            str += cur.getValue();
            cur = cur.getNext();
            if(cur != last) {
                str += ",";
            }
        }
        str += "}";
        return str;
    }
}

class DNode <T> {
    private T value; // Valor guardado no n´o
    private DNode <T> prev; // Referˆencia para o n´o anterior da lista
    private DNode <T> next; // Referˆencia para o pr´oximo n´o da lista
    // Construtor
    DNode(T v, DNode <T> p, DNode <T> n) {
        value = v;
        prev = p;
        next = n;
    }
    // Getters e Setters
    public DNode<T> getNext() {
        return next;
    }

    public DNode<T> getPrev() {
        return prev;
    }
    
    public T getValue() {
        return value;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
