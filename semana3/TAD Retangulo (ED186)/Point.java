// Uma classe simples para representar um ponto 2D
class Point {
    int x, y;
 
    Point() {
       x = y = 0;
    }
    
    Point(int x0, int y0) {
       x = x0;
       y = y0;
    }

    public Point somar(Point ponto) {
      int novoX = this.x + ponto.x;
      int novoY = this.y + ponto.y;
      return new Point(novoX, novoY);
    }
 
    public String toString() {
       return "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
      System.out.println('o');
    }
 }