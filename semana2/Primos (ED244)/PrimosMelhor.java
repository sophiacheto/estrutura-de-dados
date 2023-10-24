import java.util.Scanner;

public class PrimosMelhor {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menor = scan.nextInt();
        int maior = scan.nextInt();
        int qtdprimos = 0;
        boolean [] numeros = new boolean[maior+1];
        // lista com numeros do menor ao maior

        numeros[0] = false;
        numeros[1] = false;

        for (int i=2; i<=maior; i++)
            numeros[i] = true;


        for (int i=2; i*i<=maior; i++) {
            if (numeros[i]) {
                for (int j = i*i; j<=maior; j+=i)
                    numeros[j] = false;
            }
        }

        for (int i=menor; i<=maior; i++){
            if (numeros[i]) {
                qtdprimos += 1;
            }
                
        }

        System.out.println(qtdprimos);
    }
}
