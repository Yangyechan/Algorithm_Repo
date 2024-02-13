package BaekjunOnlineJudge.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_1351 {
    static long n, p, q;
    static Map<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Long.parseLong(input[0]);
        p = Long.parseLong(input[1]);
        q = Long.parseLong(input[2]);
        map = new HashMap<>();
        // map.put(0L, 1L);
        System.out.println(func(n));
    }

    static long func(long x) {
        if (x == 0) {
            return 1;
        }

        if (map.containsKey(x)) {
            return map.get(x);
        }

        map.put(x, func(x / p) + func(x / q));
        return map.get(x);
    }
}
