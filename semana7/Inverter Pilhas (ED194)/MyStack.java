public interface MyStack<T> {
// M´etodos que modificam a pilha
public void push(T v); // Coloca um valor no topo da pilha
public T pop (); // Retira e retorna o valor no topo da pilha
// M´etodos que acedem a informac¸˜ao (sem modificar)
public T top (); // Retorna valor no topo da pilha
public int size (); // Retorna quantidade de elementos na pilha
public boolean isEmpty (); // Indica se a pilha est´a vazia
}
