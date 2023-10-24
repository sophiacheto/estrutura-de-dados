public class Lindenmeyer {
    static void criar(int n)  {
        String linha = "A";
        String next = "";
        System.out.println(linha);
        for (int a=1; a<n; a++) {
            for (int i=0; i<linha.length(); i++) {
                if (linha.charAt(i) == 'A')
                    next += "AB";
                else
                    next += "A";
            }
            System.out.println(next);
            linha = next;
            next = "";
        }
    }
            
        // O procedimento executado inicialmente é sempre o main
    public static void main(String[] args) {	
        criar(7);	   
    }
}  
