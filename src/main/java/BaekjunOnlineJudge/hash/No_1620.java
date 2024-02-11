package BaekjunOnlineJudge.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> number = new HashMap<>();
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            name.put(str, i);
            number.put(i, str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str2 = br.readLine();
            if (str2.charAt(0) > '0' && str2.charAt(0) <= '9') {
                int x = Integer.parseInt(str2);
                sb.append(number.get(x) + "\n");
            }else {
                sb.append(name.get(str2) + "\n");
            }
        }
        System.out.println(sb);
    }
}
