package workbook.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int zc = 0;
        int oc = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '0') zc++;
            else oc++;
        }

        Set<Integer> set = new HashSet<>();
        int half = 0;
        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);

            if (ch == '1') {
                set.add(i);
                half++;

                if (oc / 2 == half) break;
            }
        }

        half = 0;
        for (int i = S.length()-1; i >= 0; i--) {

            char ch = S.charAt(i);

            if (ch == '0') {
                set.add(i);
                half++;

                if (zc / 2 == half) break;
            }
        }

        String ans = "";
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(i)) continue;

            ans += S.charAt(i);
        }

        System.out.println(ans);
    }
}
