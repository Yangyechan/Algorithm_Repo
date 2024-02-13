package BaekjunOnlineJudge.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");

                if (!map.containsKey(input[1])) {
                    map.put(input[1], 1);
                }else {
                    int num = map.get(input[1]);
                    map.put(input[1], num + 1);
                }

            }
            int size = 1;
            for (int num : map.values()) {
                size *= (num + 1);
            }
            System.out.println(size - 1);
        }
    }
}
