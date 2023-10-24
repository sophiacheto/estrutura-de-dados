import java.util.Arrays;
import java.util.Scanner;

class CacaPalavras {
    char [][] tabuleiro;
    char [][] resultado;
    int rows;
	int cols;
    
    CacaPalavras(int n, int m) {
        tabuleiro = new char[n][m];
        resultado = new char[n][m];

        rows = n;
        cols = m;
        for (int i=0; i<rows; i++) 
	        Arrays.fill(resultado[i], '.');
    }

    public void read(Scanner in) {
    // while (!in.hasNextInt())
    	for (int i=0; i<rows; i++)
	        tabuleiro[i] = in.next().toCharArray();
    }

    public void write() {
        String ans = "";
        for (int i=0; i<rows; i++) {
           for (int j=0; j<cols; j++)
              ans += tabuleiro[i][j];
           ans += "\n";
        }
        System.out.print(ans);
    }

    public void writeResult() {
        String ans = "";
        for (int i=0; i<rows; i++) {
           for (int j=0; j<cols; j++)
              ans += resultado[i][j];
           ans += "\n";
        }
        System.out.print(ans);
    }


    public void procurarPalavra(String palavra) {
        for (int x=0; x<rows; x++)
            for (int y=0; y<cols; y++)
                if (tabuleiro[x][y] == palavra.charAt(0)) {
                    percorrerPalavra(palavra, x,y);
                    if (!percorrerPalavra(palavra, x, y))
                        continue;
                }
    }

    
    public boolean percorrerPalavra(String palavra, int x, int y) {
        // Subindo
        for (int i=0; i<palavra.length() && x-i>=0; i++) {
            if (palavra.charAt(i) == tabuleiro[x-i][y]) {
               if (i==palavra.length()-1) {
                    salvarPalavra(x,y,x-i,y);
                    return true;
               }
            }
            else
                break;  
        }  
        
        // Descendo
        for (int i=0; i<palavra.length() && x+i<rows; i++) {
            if (palavra.charAt(i) == tabuleiro[x+i][y]) {
               if (i==palavra.length()-1) {
                    salvarPalavra(x, y, x+i, y);
                    return true;
                }
            }
            else 
                break;   
        }  

        // Esquerda para direita
        for (int i=0; i<palavra.length() && y+i<cols; i++) {
            if (palavra.charAt(i) == tabuleiro[x][y+i]) {
               if (i==palavra.length()-1) {
                    salvarPalavra(x, y, x, y+i);
                    return true;
                }
            }
            else
                break;      
        }  

        // Direita para esquerda
        for (int i=0; i<palavra.length() && y-i>=0; i++) {
            if (palavra.charAt(i) == tabuleiro[x][y-i]) {
               if (i==palavra.length()-1) {
                    salvarPalavra(x, y, x, y-i);
                    return true;
                }
            }
            else
                break;  
        }  

        return false;
    }


    public void salvarPalavra(int x, int y, int xf, int yf) {
        int maiorX = xf>x ? xf : x;
        int menorX = xf>x ? x : xf;
        int maiorY = yf>y ? yf : y;
        int menorY = yf>y ? y : yf;
        for (int i=menorX; i<=maiorX; i++)
            for (int j=menorY; j<=maiorY; j++)
                resultado[i][j] = tabuleiro[i][j];
    }
}

public class JogoPalavra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m, n;
        int count = 1;

        while (true) {
            n = scan.nextInt();
            m = scan.nextInt();

            if (n!= 0) {
                scan.nextLine();

                CacaPalavras game = new CacaPalavras(n, m);

                game.read(scan);
                int qtdPalavras = scan.nextInt();

                for (int i=0; i<qtdPalavras; i++)
                    game.procurarPalavra(scan.next());
                
                System.out.println("Input #" + count++);
                game.writeResult();
            }
            else
                break;
        } 
    }
}

