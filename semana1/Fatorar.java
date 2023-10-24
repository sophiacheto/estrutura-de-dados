public class Fatorar {
    static boolean isPrime(int n) {
        for (int i=2; i*i<=n; i++) {
            if (n%i == 0)
            return false;
        }
	return true;
    }

    static void fatoracao(int n) {
        System.out.print(n + "=");
        int i=2;
        boolean primeiro = true;
        while (i<=n) {
            if (isPrime(i) && n%i == 0) {
                n = n/i;
                if (primeiro) {
                    System.out.print(i);
                    primeiro = false; }
                else
                    System.out.print("*" + i);
            } else
                i++;
        }}
            
        // O procedimento executado inicialmente é sempre o main
        public static void main(String[] args) {	
        fatoracao(69);	    
        }

    }  

