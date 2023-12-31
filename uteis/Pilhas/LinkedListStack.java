package uteis.Pilhas;

import uteis.LinkedLists.DoublyLinkedList;

public class LinkedListStack<T> implements MyStack<T> {
   private DoublyLinkedList<T> list;

   public LinkedListStack() { list = new DoublyLinkedList<T>();}
   
   public void push(T v) { list.addFirst(v); }   
   public T pop() {
      T ans = list.getFirst();
      list.removeFirst();
      return ans;
   }
   public T top() { return list.getFirst();}
   public int size() {return list.size();}
   public boolean isEmpty() {return list.isEmpty();}

   public String toString() {return list.toString();}
}