public class Contar {
    static int count(String palavra, char letra) {
        int cont = 0;
        for (int i=0; i<palavra.length(); i++) {
            if (palavra.charAt(i) == letra)
                cont += 1;
        }
	return cont;
    }
            
        // O procedimento executado inicialmente é sempre o main
        public static void main(String[] args) {	
        System.out.println(count("amor", 'a'));	   
        }

    }  

