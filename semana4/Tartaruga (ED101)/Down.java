public class Down implements Caneta {
    int pintado=0;
    char[][] grelha;

    Down(char[][] grelha) {
        this.grelha = grelha;
    }

    @Override
    public void escrever(int x, int y) {
        grelha[x][y] = '*';
        pintado++;
    }

    @Override
    public int getPintado() {
        return pintado;
    }

}
