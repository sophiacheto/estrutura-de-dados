package semana12;

import java.util.Comparator;
import java.util.Scanner;

import uteis.Heaps.MinHeap;

public class ED215 {
    int lance;
    String pessoa;

    public ED215(String pessoa, int lance) {
        this.lance = lance;
        this.pessoa = pessoa;
    }

    public int getLance() {
        return lance;
    }

    public String getPessoa() {
        return pessoa;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int qtd = scan.nextInt();
        MinHeap<ED215> lances = new MinHeap<>(qtd, new ValueComparator());

        scan.nextLine();

        while (scan.hasNext()) {
            if (scan.next().equals("VENDA")) {
                ED215 vencedor = lances.removeMin();
                System.out.println(vencedor.getLance() + " " + vencedor.getPessoa());
            }
            else {
                lances.insert(new ED215(scan.next(), scan.nextInt()));
            }       
        }
    }
}

class ValueComparator implements Comparator<ED215> {
    public int compare(ED215 a, ED215 b) {
        return b.getLance() - a.getLance();
    }
}