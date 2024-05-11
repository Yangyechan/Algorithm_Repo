package workbook.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.toUpperCase();

        int max = 0;
        char maxKey = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);

            if (!map.containsKey(key)) {
                map.put(key, 1);
            }else {
                int tmp = map.get(key);
                map.put(key, tmp + 1);

                if (max < tmp + 1) {
                    max = tmp + 1;
                    maxKey = key;
                }
            }
        }

    }
}
