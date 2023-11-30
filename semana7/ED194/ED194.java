package semana7.ED194;

import java.util.Stack;

public class ED194 {

    public static void reverse(Stack<Integer> s, int n) {
        int[] inverter = new int[n];

        for (int i=0; i<n; i++)
            inverter[i] = s.pop();

        for (int num : inverter)
            s.push(num);
    }

    // public static void main(String[] args) {
    //     Stack<Integer> s = new Stack<>();

    //     s.push(5);
    //     s.push(4);
    //     s.push(3);
    //     s.push(2);
    //     s.push(1);

    //     System.out.println(s);

    //     reverse(s, 3);

    //     System.out.println(s);
    // }
}
