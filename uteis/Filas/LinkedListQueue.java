package uteis.Filas;

import uteis.LinkedLists.DoublyLinkedList;

public class LinkedListQueue<T> implements MyQueue<T> {
   private DoublyLinkedList<T> list;

   public LinkedListQueue() { list = new DoublyLinkedList<T>();}

   public LinkedListQueue(T[] lista) {
    list = new DoublyLinkedList<>();
    for (T item : lista)
      enqueue(item);
   }
   
   public void enqueue(T v) { list.addLast(v); }   
   public T dequeue() {
      T ans = list.getFirst();
      list.removeFirst();
      return ans;
   }
   public T first() { return list.getFirst();}
   public int size() {return list.size();}
   public boolean isEmpty() {return list.isEmpty();}

   public String toString() {return list.toString();}
}