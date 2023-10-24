import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


public class Primos {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menor = scan.nextInt();
        int maior = scan.nextInt();
        ArrayList < Integer > numeros = new ArrayList < Integer > (); // lista com numeros do menor ao maior
        for (int i=menor; i<=maior; i++)
            numeros.add(i);


        for (int i=2; i*i<=maior; i++) {
            Iterator<Integer> iterator = numeros.iterator();
            while (iterator.hasNext()) {
                int num = iterator.next();
                if (num%i==0 && num!=i)
                    iterator.remove();
            }
        }


        System.out.println(numeros.size());
    }
}
