interface IntSet {
    public boolean contains(int x);       // Retorna true se x esta no conjunto
    public boolean add(int x);            // Adiciona x ao conjunto (devolve true se conseguir)
    public boolean remove(int x);         // Remove x do conjunto (devolve true se conseguir)
    public int     size();                // Retorna o numero de elementos do conjunto
    public void    clear();               // Limpa o conjunto (torna-o vazio)

    // Metodos a adicionar (nao existentes na classe base)
    public boolean equals(IntSet s);      // Retorna true se ambos os conjuntos sao iguais
    public IntSet intersection(IntSet s); // devolve um novo conjunto: a intersecao de ambos
}

public class BooleanArrayIntSet implements IntSet {
    private int size;
    private boolean[] isElemento;

    public BooleanArrayIntSet(int n) {
        size = 0;
        isElemento = new boolean[n+1];
    }

    @Override
    public boolean contains(int x) {
        return isElemento[x];
    }

    @Override
    public boolean add(int x) {
        if (isElemento[x]) return false;
        isElemento[x] = true;
        size++;
        return true;
    }

    @Override
    public boolean remove(int x) {
        if (!isElemento[x]) return false;
        isElemento[x] = false;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        isElemento = new boolean[isElemento.length];
    }

    @Override
    public boolean equals(IntSet s) {
        if (this.size != s.size()) return false;
        for (int i=0; i<isElemento.length; i++)
            if (isElemento[i] && !s.contains(i)) return false;
        return true;
    }

    @Override
    public IntSet intersection(IntSet s) {
        IntSet novo = new BooleanArrayIntSet(isElemento.length);
        for (int i=0; i<isElemento.length-1; i++)
            if (s.contains(i) && contains(i)) novo.add(i);
        return novo; 
    }    

    // public static void main(String[] args) {
    //     IntSet set1 = new BooleanArrayIntSet(5);
    //     IntSet set2 = new BooleanArrayIntSet(4);

    //     set1.add(1);
    //     set1.add(5);

    //     set2.add(4);

    //     IntSet set3 = set1.intersection(set2);
    //     System.out.println(set3.contains(1));
    // }
}
