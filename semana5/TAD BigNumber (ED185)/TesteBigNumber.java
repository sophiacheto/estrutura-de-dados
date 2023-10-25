public class TesteBigNumber {
    public static void main(String[] args) {
        BigNumber n1 = new BigNumber("98765432109876543210");

        BigNumber n2 = new BigNumber("98765432109876543210");

        System.out.println(n1.add(n2)); // Escreve "false"
    
    }
}
