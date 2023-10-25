public class BigNumber {
    int[] numero;

    BigNumber(String n) {
        char[] characts = n.toCharArray();
        this.numero = new int[characts.length];
        int i=0;
        for (char c : characts)
            numero[i++] = Character.getNumericValue(c);
    }


    public int[] getNumero() {
        return numero;
    }


    public String toString() {
        String str = "";
        for (int i : this.numero)
            str += (i);
        return str;
    }


    public boolean equals(BigNumber n) {
        return this.toString().equals(n.toString());
    }


    public BigNumber add(BigNumber n) {
        int[] menor = this.numero.length <= n.getNumero().length ? this.numero : n.getNumero();
        int[] maior = this.numero.length > n.getNumero().length ? this.numero : n.getNumero();
        int novo;
        int dezena = 0;
        String result = "";

        for (int i=0; i<maior.length; i++) {
            int num1 = maior[maior.length-1-i];
            int num2 = i > menor.length-1 ? 0 : menor[menor.length-1-i];
            novo = (num1 + num2 + dezena)%10;
            dezena = (num1 + num2 + dezena)/10;
            result += novo;
        }

        result += dezena!=0 ? dezena : "";
        return new BigNumber(new StringBuilder(result).reverse().toString());
    }


    public BigNumber multiply(BigNumber n) {
        int[] menor = this.numero.length <= n.getNumero().length ? this.numero : n.getNumero();
        int[] maior = this.numero.length > n.getNumero().length ? this.numero : n.getNumero();
        int novo;
        BigNumber result = new BigNumber("0");

        for (int i=0; i<menor.length; i++) {
            String parciais = "";
            int dezena = 0;
            int num2 = menor[menor.length-1-i];
            for (int k=0; k<i; k++) 
                parciais += "0";
            for (int j=0; j<maior.length; j++) {
                int num1 = maior[maior.length-1-j];
                novo = (num1*num2 + dezena)%10;
                dezena = (num1*num2 + dezena)/10;
                parciais += novo;
            } 
            parciais += dezena!=0 ? dezena : "";
            BigNumber resultParcial = new BigNumber(new StringBuilder(parciais).reverse().toString());
            result = result.add(resultParcial);
        }
        return result;        
    }
}


