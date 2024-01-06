package semana11;

import java.util.Scanner;
import uteis.Dicionario.BSTMap;

public class ED172 {
    public static void main(String[] args) {
        BSTMap<String, Integer> map = new BSTMap<>();
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String palavra = scan.next();
            if (map.get(palavra)==null) // a palavra não existir ainda
                map.put(palavra, 1);
            else
                map.put(palavra, map.get(palavra)+1);
        }

        print(map);
    }


    public static void print(BSTMap<String, Integer> map) {
      for (String palavra : map.keys())
        System.out.println(palavra + ": " + map.get(palavra));
    }
}
