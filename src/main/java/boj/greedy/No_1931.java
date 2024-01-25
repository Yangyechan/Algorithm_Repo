package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class time implements Comparable<time> {
    int start;
    int end;
    int hour;

    time (int start, int end) {
        this.start = start;
        this.end = end;

    }

    @Override
    public int compareTo(time o) {
        if (end == o.end) {
            return start - o.start;
        }
        return end - o.end;
    }
}
public class No_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);

            list.add(new time(start, end));
        }
        Collections.sort(list);

        int target = list.get(0).end;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            int tmp = list.get(i).start;
            if (tmp >= target) {
                target = list.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
