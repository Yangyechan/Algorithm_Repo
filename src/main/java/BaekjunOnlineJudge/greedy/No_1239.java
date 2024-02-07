package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char tmp = str.charAt(0);
        int zero = 0;
        int one = 0;
        if (tmp == '0') zero++;
        else one++;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == tmp) {
                continue;
            }
            if (ch == '0') {
                tmp = '0';
                zero++;
            }else {
                tmp = '1';
                one++;
            }
        }

        int ans = Math.min(zero, one);

        System.out.println(ans);
    }
}
