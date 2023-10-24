public class Fraction {
    int numerador;
    int denominador;

    Fraction(int n, int d) {
        numerador = n;
        denominador = d;
    }

    public String toString() {
        String escrita;
        if (numerador < denominador)
            escrita = numerador + "/" + denominador;
        else {
            int parte = numerador/denominador;
            int resto = numerador%denominador;
            escrita = parte + "+" + resto + "/" + denominador;
        }
        return escrita;
    }

    public Fraction add(Fraction f) {
        int novoDen = f.denominador * denominador;
        int novoNum = f.numerador*denominador + numerador*f.denominador;
        Fraction soma = new Fraction(novoNum, novoDen);
        return soma;
    }

    public Fraction simplify() {
        int mindiv = MDC(numerador, denominador);
        Fraction simplificada = new Fraction(numerador/mindiv, denominador/mindiv);
        return simplificada;
    }

    private static int MDC(int a, int b) {
        int resto = a%b;
        if (resto!=0)
            return MDC(b, resto);
        else
            return b;
    }

    public static void main(String[] args) {
        Fraction fracao = new Fraction(3, 9);
        System.out.println(fracao.simplify());

        Fraction frac2 = new Fraction(1, 2);
        System.out.println(frac2);
        System.out.println(frac2.simplify());
    }
}
