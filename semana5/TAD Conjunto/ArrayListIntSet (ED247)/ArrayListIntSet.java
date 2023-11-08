// Interface que define o TAD conjunto de numeros inteiros
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

public class ArrayListIntSet implements IntSet {
    private int size;
    private int[] elementos;

    public ArrayListIntSet(int max) {
        size = 0;
        elementos = new int[max];
    }

    @Override
    public boolean contains(int x) {
        for (int i=0; i<size; i++)
            if (elementos[i] == x) return true;
        return false;
    }

    @Override
    public boolean add(int x) {
        if (!contains(x)) {
            elementos[size] = x;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int x) {
        int inicial = size;
        for (int i=0; i<inicial; i++)
            if (elementos[i] == x) {
                elementos[i] = elementos[size-1];
                size--;
                return true;
            }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean equals(IntSet s) {
        if (this.size() != s.size()) return false;
        for (int i=0; i<size; i++)
            if (!s.contains(elementos[i])) return false;
        return true;
    }

    @Override
    public IntSet intersection(IntSet s) {
        IntSet novo = new ArrayListIntSet(size);
        for (int i=0; i<size; i++)
            if (s.contains(elementos[i])) novo.add(elementos[i]);
        return novo;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i=0; i<size; i++) {
            if (i>0) str += ",";
            str += elementos[i];
        }
        str += "}";
        return str;
    }

    // public static void main(String[] args) {
    //     IntSet s1 = new ArrayListIntSet(20);

    //     System.out.println(s1.add(10));
    //     System.out.println(s1.add(5));
    //     System.out.println(s1.add(20));
    //     System.out.println(s1.add(130));
    //     System.out.println(s1.add(130));
    //     System.out.println(s1.add(10));
    //     System.out.println(s1.add(20));
    //     System.out.println(s1.add(5));
    //     System.out.println(s1.add(5));
    //     System.out.println(s1.add(6));

    //     System.out.println(s1.remove(10));
    //     System.out.println(s1.remove(20));
    //     System.out.println(s1.remove(30));
    //     System.out.println(s1.remove(20));
    //     System.out.println(s1.remove(10));
    //     System.out.println(s1.remove(130));
    //     System.out.println(s1.remove(5));
    //     System.out.println(s1.remove(6));
    //     System.out.println(s1.remove(1));
    //     System.out.println(s1.remove(5));
    // }
}