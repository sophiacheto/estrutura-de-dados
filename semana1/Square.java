public class Square {
    // Desenha uma linha de n caracteres onde:
    // - o primeiro e o último caracteres são o caracter da variável 'a'
    // - todos os outros caracteres são o caracter da variável 'b'
    static void line1(int n) {
	System.out.print("+");
	for (int i=1; i<=n-2; i++)
	    System.out.print("-");
	System.out.println("+");
    }

    static void line2(int n) {
	System.out.print("|");
	for (int i=1; i<=n-2; i++)
	    System.out.print(".");
	System.out.println("|");
    }

    static void square(int n) {
        line1(n);
        for (int i=1; i<=n-2; i++)
            line2(n);
        line1(n);
    }

    // O procedimento executado inicialmente é sempre o main
    public static void main(String[] args) {	
	square(5);	    
    }

  
}