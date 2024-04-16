package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int zero = 0;
        int one = 0;
        char num;
        if (str.charAt(0) == '0') {
            zero++;
            num = '0';
        } else {
            one++;
            num = '1';
        }

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') {
                if (num == '1') {
                    zero++;
                    num = '0';
                }
            }else {
                if (num == '0') {
                    one++;
                    num = '1';
                }
            }
        }

        int ans = Math.min(zero, one);
        System.out.println(ans);
    }
}
