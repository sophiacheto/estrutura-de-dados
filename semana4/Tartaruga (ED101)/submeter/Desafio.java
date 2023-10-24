import java.util.Arrays;
import java.util.Scanner;

public class Desafio {
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

class Tartaruga {
    char[][] grelha;
    Caneta caneta;
    int x;
    int y;
    Point incremento;
    final Point[] options = {new Point(0,1), new Point(-1,0), new Point(0,-1), new Point(1,0)};
    Caneta up;
    Caneta down;

    int tamanhoTotal;
    int pintados = 0;

    Tartaruga(int linhas, int colunas) {
        this.x = 0;
        this.y = 0;
        this.incremento = options[0];
        this.tamanhoTotal = linhas * colunas;
        this.grelha = new char[linhas][colunas];
        for (int i=0; i<linhas; i++)
            for (int j=0; j<colunas; j++)
                grelha[i][j] = '.';
        up = new Up(grelha);
        down = new Down(grelha);
        this.caneta = up;
    }

    public void canetaUp() {
        this.caneta = up;
    }

    public void canetaDown() {
        this.caneta = down;
        if (grelha[x][y] == '.') {
            caneta.escrever(x, y);
            pintados+=1;
        }
    }

    public String toString() {
        String ans = "";
        for (int i=0; i<grelha.length; i++) {
            for (int j=0; j<grelha[0].length; j++) {
                ans += grelha[i][j];
                if (j!=grelha[0].length-1)
                    ans+= " ";
            }
            if (i!=grelha.length-1)
                ans += "\n";
        }
        return ans;
    }

    public void mover(int n) {
        for (int i=0; i<n; i++) {
            if (areInside(x, y)) {
                x+=incremento.x;
                y+=incremento.y;
                if (grelha[x][y] == '.') {
                    caneta.escrever(x, y);
                    pintados+=1;
                }
            }
        }
    }

    public void left() {
        int atual = 0;
        for (int i=0; i<4; i++)
            if (options[i] == incremento)
                atual = i;
        this.incremento = options[(atual+1)%4];
    }

    public void right() {
        int atual = 0;
        for (int i=0; i<4; i++)
            if (options[i] == incremento)
                atual = i;
        if (atual<=0)
            atual+=4;
        this.incremento = options[atual-1];
    }

    public boolean areInside(int x, int y) {
        return (x+incremento.x>=0 && x+incremento.x<grelha.length && y+incremento.y>=0 && y+incremento.y<grelha[0].length);
    }

    public int linhasLimpas() {
        int num = 0;
        for (char[] linha : grelha)
            if (!containsChar(linha, '*'))
                num++;
        return num;
    }

    public int colunasLimpas() {
        int num = 0;
        char[] coluna = new char[grelha.length];
        for (int i=0; i<grelha[0].length; i++) {  // numero da coluna (iésima coluna)
            for (int j=0; j<grelha.length; j++)
                coluna[j] = grelha[j][i];
            if (!containsChar(coluna, '*')) 
                num++;
        }
        return num;
    }

    public int porcentagem() {
        int p = down.getPintado();
        return p*100/tamanhoTotal;
    }

    public boolean matrizContem(char[][] matrizMenor) {
        // Computa o tamanho das matrizes. 
        int alturaMenor = matrizMenor.length;
        int larguraMenor = alturaMenor == 0 ? 0 : matrizMenor[0].length;
        int alturaMaior = grelha.length;
        int larguraMaior = alturaMaior == 0 ? 0 : grelha[0].length;

        // Percorre as linhas da matriz maior para procurar a menor.
        for (int a = 0; a <= alturaMaior - alturaMenor; a++) {
            // Percorre as colunas da matriz maior para procurar a menor.
            r: for (int b = 0; b <= larguraMaior - larguraMenor; b++) {

                // Tendo a posição [a][b] da matriz maior como correspondente ao possível canto superior esquerdo da matriz menor,
                // verifica se essa posição contém a matriz menor ao percorrer ambas as matrizes juntas a partir desse ponto.
                // Começa percorrendo as linhas de ambas as matrizes.
                for (int c = 0; c < alturaMenor; c++) {
                    // Percorre as colunas de ambas as matrizes.
                    for (int d = 0; d < larguraMenor; d++) {

                        // Se as coordenadas tiverem valores diferentes, então essa posição da matriz maior não contém a menor.
                        // Dessa forma, se for esse o caso, interrompe o processo de percorrer ambas as matrizes juntas e avança para a
                        // próxima possibilidade na matriz maior.
                        if (grelha[a + c][b + d] != matrizMenor[c][d]) continue r;
                    }
                }

                // Se terminou de percorrer ambas as matrizes (a maior a partir da posição [a][b]) e todas as posições forem iguais, então a matriz menor está dentro da maior.
                return true;
            }
        }

        // Se terminou de percorrer a matriz maior e não encontrou a menor, então é porque a menor não está dentro da maior.
        return false;
    }

    public static boolean containsChar(char[] array, char character) {
        for (char c : array) {
            if (c == character) {
                return true;
            }
        }
        return false;
    }
}


class Up implements Caneta {
    char[][] grelha;

    Up(char[][] grelha) {
        this.grelha = grelha;
    }


    @Override
    public void escrever(int x, int y) {
    }


    @Override
    public int getPintado() {
        return 0;
    }

}

class Down implements Caneta {
    int pintado=0;
    char[][] grelha;

    Down(char[][] grelha) {
        this.grelha = grelha;
    }

    @Override
    public void escrever(int x, int y) {
        grelha[x][y] = '*';
        pintado+=1;
    }

    public int getPintado() {
        return pintado;
    }

}

interface Caneta {
    void escrever(int x, int y);
    int getPintado();
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
