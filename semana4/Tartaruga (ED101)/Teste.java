import java.util.Scanner;


public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opcao = scan.nextInt();
        Tartaruga turtle = new Tartaruga(scan.nextInt(), scan.nextInt());
        
        while (true) {
            String comando = scan.nextLine();
            if (comando.equals("end"))
                break;
            else {
                String[] divisao = comando.split(" ");
                switch(divisao[0]) {
                    case "D":
                        turtle.canetaDown();
                        break;
                    case "U":
                        turtle.canetaUp();
                        break;
                    case "L":
                        turtle.left();
                        break;
                    case "R":
                        turtle.right();
                        break;
                    case "F":
                        turtle.mover(Integer.parseInt(divisao[1])); 
                        break;
                }
            }
        }

        switch (opcao) {
            case 0:
                System.out.println(turtle);
                break;
            case 1:
                System.out.println(turtle.porcentagem() + " " + turtle.linhasLimpas() + " " + turtle.colunasLimpas());
                break;
            case 2: 
                int linha = scan.nextInt();
                int coluna = scan.nextInt();
                scan.nextLine();
                char[][] pequena = new char[linha][coluna];
                for (int i=0; i<linha; i++)
                    pequena[i] = scan.nextLine().replaceAll(" ", "").toCharArray();
                if (turtle.matrizContem(pequena))
                    System.out.println("Sim");
                else
                    System.out.println("Nao");
                break;
            

        }

    }
}