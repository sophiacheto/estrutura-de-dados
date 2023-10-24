import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.println(stdin.nextInt());
        stdin.nextLine();
            
        while (stdin.hasNextLine()) {
            String str = soLetras(stdin.nextLine());
            if (inversa(str).equals(str))
                System.out.println("sim");
            else
                System.out.println("nao");
        }
    }

    public static String soLetras(String frase) {
        String letras = new String();
        char charac;
        for (int i=0; i < frase.length(); i++) {
            charac = Character.toLowerCase(frase.charAt(i));
            if (Character.isLetter(charac))
                letras += charac;
        }
    return letras;
    }
    

    public static String inversa(String frase) {
        String inv = new String();
        String fraseLetras = soLetras(frase);
        for (int i=fraseLetras.length()-1; i >= 0; i--) 
            inv += frase.charAt(i);
        return inv;
    }
}
    