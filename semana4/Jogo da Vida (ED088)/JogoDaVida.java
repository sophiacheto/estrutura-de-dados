import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo


    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	m = new char[r][c];
    }


    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();
    }
    

    // Metodo para escrever a matriz m[][]
    public void write() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += m[i][j] + " ";
         ans += "\n";
      }
      System.out.print(ans);
    }


    // Deve devolver o numero de celulas vivas que sao vizinhas de (x,y)
    public int countAlive(int x, int y) {
    int count;
    if (m[x][y] == ALIVE)
        count = -1;
    else
        count = 0;

	for (int i=x-1; i<=x+1; i++)
        for (int j=y-1; j<=y+1; j++)
            if (i>=0 && j>=0 && i<m.length && j<m[0].length) {
                if (Character.compare(m[i][j], ALIVE) == 0)
                    count += 1;
            }

	return count;
    }


    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        char m2[][] = new char[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int vizinhasVivas = countAlive(i, j);
                if (m[i][j] == ALIVE) 
                    m2[i][j] = vizinhasVivas == 2 || vizinhasVivas == 3 ? ALIVE : DEAD;              
                else  // se a célula estiver morta 
                    m2[i][j] = vizinhasVivas == 3 ? ALIVE : DEAD;
            }
        }
        m = m2;
    }

}



// Classe principal com o main()
public class JogoDaVida {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = in.nextInt();
	int cols = in.nextInt();
	int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game g = new Game(rows, cols);
	g.read(in);

    for (int i=0; i<n; i++)
        g.iterate();
    
    g.write();
    }
}