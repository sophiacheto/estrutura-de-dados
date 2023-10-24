public class losango1 {
    static void fig(int n) {
        int i = 1;
        while (i<=n-1) {
            System.out.println("#".repeat(i));
            i+=2;
        }
        while (i>0) {
            System.out.println("#".repeat(i));
            i-=2;
        }}



    public static void main(String[] args) {	
        fig(5);
        }
}
