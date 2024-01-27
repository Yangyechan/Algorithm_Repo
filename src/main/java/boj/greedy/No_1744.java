package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) list1.add(num);
            else list2.add(num);
        }
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2);

        int ans = 0;
        if (list1.size() % 2 == 1) {
            for (int i = 0; i < list1.size(); i+=2) {
                if (i == list1.size()-1) {
                    ans += list1.get(i);
                    continue;
                }
                int tmp = Math.max(list1.get(i) * list1.get(i+1), list1.get(i) + list1.get(i+1));
                ans += tmp;
            }
        }else {
            for (int i = 0; i < list1.size(); i+=2) {
                int tmp = Math.max(list1.get(i) * list1.get(i+1), list1.get(i) + list1.get(i+1));
                ans += tmp;
            }
        }

        if (list2.size() % 2 == 1) {
            for (int i = 0; i < list2.size(); i+=2) {
                if (i == list2.size()-1) {
                    ans += list2.get(i);
                    continue;
                }
                int tmp = Math.max(list2.get(i) * list2.get(i+1), list2.get(i) + list2.get(i+1));
                ans += tmp;
            }
        }else {
            for (int i = 0; i < list2.size(); i+=2) {
                int tmp = Math.max(list2.get(i) * list2.get(i+1), list2.get(i) + list2.get(i+1));
                ans += tmp;
            }
        }
        System.out.println(ans);
    }
}
