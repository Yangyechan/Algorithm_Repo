package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int e = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        long cnt = 0;
        int a = 1;
        int b = 1;
        int c = 1;
        while (true) {
            cnt++;
            if (a == e && b == s && m == c) {
                System.out.println(cnt);
                break;
            }
            a++;
            b++;
            c++;
            if (a > 15) a = 1;
            if (b > 28) b = 1;
            if (c > 19) c = 1;
        }
    }
}
