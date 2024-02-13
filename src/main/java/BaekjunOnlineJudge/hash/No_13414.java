package BaekjunOnlineJudge.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            String sn = br.readLine();
            set.add(sn);
            if (set.contains(sn)) {
                set.remove(sn);
            }
            set.add(sn);

        }

        int size = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            if (size == k) break;
            sb.append(s + "\n");
            size++;
        }
        System.out.println(sb);
    }
}
