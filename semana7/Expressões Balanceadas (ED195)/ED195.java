import java.util.Stack;

public class ED195 {
    public static boolean balanced(String s) {
        Stack<Character> abertos = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[')
                abertos.push(c);
            else if (abertos.isEmpty()) return false;
            else if ((c == ')' && '(' != abertos.pop())  || c==']' && '['!=abertos.pop())  return false;
        }

        return abertos.isEmpty();
    }

    // public static void main(String[] args) {
    //     System.out.println(balanced("]"));;
    // }
}
