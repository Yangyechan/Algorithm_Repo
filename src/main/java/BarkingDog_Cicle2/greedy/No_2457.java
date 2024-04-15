package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2457 {
    static class flower implements Comparable<flower>{
        int st, ed;

        flower(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(flower o) {
            if (ed == o.ed) {
                return st - o.st;
            }
            return ed - o.ed;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<flower> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            int st1 = Integer.parseInt(ip[0]);
            int ed1 = Integer.parseInt(ip[1]);
            int st2 = Integer.parseInt(ip[2]);
            int ed2 = Integer.parseInt(ip[3]);

            list.add(new flower(st1 * 100 + ed1, st2 * 100 + ed2));
        }
        Collections.sort(list);

        int now = 301;
        int idx = 0;
        int cnt = 0;
        while (now <= 1130) {
            int tmp = now;
            for (int i = idx; i < N; i++) {
                flower nx = list.get(i);
                if (nx.st <= now && now < nx.ed) {
                    tmp = nx.ed;
                    idx = i;
                }
            }

            if (tmp == now) {
                System.out.println(0);
                return;
            }

            now = tmp;
            cnt++;
        }

        System.out.println(cnt);
    }
}
