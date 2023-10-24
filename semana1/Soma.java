public class Soma {
    public static void main(String[] args) {
	int n = 500;
    int soma = 0; 
	
	for (int i=1; i<=n; i++) {
        System.out.println(i);
        soma += i;
    }
	System.out.println("Soma = " + soma);
    }
}