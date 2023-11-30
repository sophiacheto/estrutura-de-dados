import uteis.Filas.LinkedListQueue;
import uteis.Filas.MyQueue;

public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        while (!q.isEmpty()) {
            String nome = q.dequeue();
            String destino = q.dequeue();

            switch (destino) {
                case "A":
                    a.enqueue(nome);
                    break;
                case "B":
                    b.enqueue(nome);
                    break;
                default:
                    if (a.size() < b.size()) a.enqueue(nome);
                    else if (a.size() > b.size()) b.enqueue(nome);
                    break;
            }

        }
    }

    public static void main(String[] args) {
        String[] lista = {"Luis","B","Pedro","B","Luisa","X","Joao","X"};
        MyQueue<String> fila = new LinkedListQueue<>(lista);
        MyQueue<String> a = new LinkedListQueue<>();
        MyQueue<String> b = new LinkedListQueue<>();

        process(fila, a, b);

        System.out.println(fila);
        System.out.println(a);
        System.out.println(b);
    }


}