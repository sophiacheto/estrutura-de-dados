public class Rectangle {
    Point infEsq;
    Point supDir;
    int xEsq;
    int xDir;
    int yInf;
    int ySup;

    Rectangle(int x1, int y1, int x2, int y2) {
        infEsq = new Point(x1, y1);
        supDir = new Point(x2, y2);
        xEsq = x1;
        xDir = x2;
        yInf = y1;
        ySup = y2;
    }

    Rectangle (Point p1, Point p2) {
        infEsq = p1;
        supDir = p2;
        xEsq = p1.x;
        xDir = p2.x;
        yInf = p1.y;
        ySup = p2.y;
    }

    public int area() {
        int area = (xDir - xEsq) * (ySup - yInf);
        return area;
    }
    
    public int perimeter() {
        int perimetro = (xDir - xEsq)*2 + (ySup - yInf)*2;
        return perimetro;
    }

    public boolean pointInside(Point p) {
        if ((xEsq <= p.x) && (p.x <= xDir) && (yInf <= p.y) && (p.y <= ySup))
            return true;
        else
            return false;
    }

    public boolean rectangleInside(Rectangle r) {
        if (pointInside(r.infEsq) && pointInside(r.supDir))
            return true;
        else
            return false;
    }
}
