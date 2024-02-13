package BaekjunOnlineJudge.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, String> site = new HashMap<>();
        Map<String, String> password = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            site.put(str[0], str[1]);
            password.put(str[1], str[0]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str2 = br.readLine();
            if (str2.contains(".")) {
                sb.append(site.get(str2) + "\n");
            }else {
                sb.append(password.get(str2) + "\n");
            }
        }
        System.out.println(sb);
    }
}
