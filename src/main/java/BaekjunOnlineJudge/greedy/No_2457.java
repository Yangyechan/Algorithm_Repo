package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class flower implements Comparable<flower>{
    int start, end;

    flower (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(flower o) {
        if (end == o.end) {
            return start - o.start;
        }
        return end - o.end;
    }
}

public class No_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<flower> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int sm = Integer.parseInt(str[0]);
            int sd = Integer.parseInt(str[1]);
            int em = Integer.parseInt(str[2]);
            int ed = Integer.parseInt(str[3]);
            list.add(new flower(sm * 100 + sd, em * 100 + ed));
        }
        Collections.sort(list);

        int now = 301;
        int next_t = 0;
        int cnt = 0;
        while (now < 1201) {
            next_t = now;
            for (int i = 0; i < n; i++) {
                flower tm = list.get(i);
                if (tm.start <= now && tm.end > now) {
                    next_t = tm.end;
                }
            }
            if (next_t == now) {
                System.out.println(0);
                return;
            }
            now = next_t;
            cnt++;
        }
        System.out.println(cnt);
    }
}

