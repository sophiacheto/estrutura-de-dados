public class Node<T> {
    T value;
    Node<T> next;

    Node(T v, Node<T> n) {
        value = v;
        next = n;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    
}
