package semana7.ED006;

public class Teste {
    int count = 0;

    int maxRec2(int v[], int start, int end) {
        count++;
        if (start == end) return v[start];
        int middle = (start + end) / 2;
        int max1 = maxRec2(v, start, middle);
        int max2 = maxRec2(v, middle+1, end);
        return count;
       }

    public static void main(String[] args) {
        int [] v = {0,1,2,3,4,5,6,7};
        Teste test = new Teste();
        System.out.println(test.maxRec2(v, 0, 7));
    }
}

