package semana6.SinglyLinkedList;

public class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String str = "(" + x + ", " + y + ")";
        return str;
    }
}
