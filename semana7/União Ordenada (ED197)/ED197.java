import uteis.Filas.LinkedListQueue;
import uteis.Filas.MyQueue;

public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> uniao = new LinkedListQueue<>();

        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty()) {uniao.enqueue(b.dequeue());}
            else if (b.isEmpty()) {uniao.enqueue(a.dequeue());}
            else {
            int elemA = a.first();
            int elemB = b.first();

            uniao.enqueue(elemA<elemB ? a.dequeue() : b.dequeue());
            }
        }

        return uniao;
    }

 
    // public static void main(String[] args) {
    //     Integer[] listaA = {1,2,4,5};
    //     Integer[] listaB = {2,3,5,6,8};
    //     MyQueue<Integer> a = new LinkedListQueue<>(listaA);
    //     MyQueue<Integer> b = new LinkedListQueue<>(listaB);

    //     System.out.println(merge(a, b));
    // }
}

