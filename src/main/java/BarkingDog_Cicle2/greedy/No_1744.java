package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> minus = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num <= 0) {
                minus.add(num);
            } else if (num == 1) {
                one.add(num);
            } else {
                list.add(num);
            }
        }
        Collections.sort(minus);
        Collections.sort(list);

        int ans = 0;
        if (minus.size() == 1) {
            ans += minus.get(0);
        }else {
            if (minus.size() % 2 == 0) {
                for (int i = 0; i < minus.size()-1; i+=2) {
                    ans += minus.get(i) * minus.get(i+1);
                }
            }else {
                for (int i = 0; i < minus.size()-2; i+=2) {
                    ans += minus.get(i) * minus.get(i+1);
                }
                ans += minus.get(minus.size()-1);
            }
        }

        if (list.size() == 1) {
            ans += list.get(0);
        }else {
            if (list.size() % 2 == 0) {
                for (int i = list.size()-1; i >= 1; i-=2) {
                    ans += list.get(i) * list.get(i-1);
                }
            }else {
                for (int i = list.size()-1; i > 1; i-=2) {
                    ans += list.get(i) * list.get(i-1);
                }
                ans += list.get(0);
            }
        }

        for (int i = 0; i < one.size(); i++) {
            ans += 1;
        }

        System.out.println(ans);
    }
}
