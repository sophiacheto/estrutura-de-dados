public class Palindromos {
    static String inverter(String algo) { 
        String inv = "";
	for (int i=algo.length() - 1; i>=0; i--)
	    inv += algo.charAt(i);
    return inv;
    }

    static boolean palindromoo(String str) { 
        if ((inverter(str)).equals(str))
            return true;
       return false;
    }
   

    public static void main(String[] args) {	
	if (palindromoo("ala"))
        System.out.println("sim");
    else
        System.out.println("nao");;
    }
}