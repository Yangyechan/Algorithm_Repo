package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class point implements Comparable<point> {
    int start, end;

    point(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(point o) {
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
public class No_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(list);

        int start = list.get(0).start;
        int end = list.get(0).end;
        long len = 0;

        for (int i = 1; i < n; i++) {
            point p = list.get(i);
            if (p.start > end) {
                len += end - start;
                start = p.start;
                end = p.end;
            } else {
                end = Math.max(end, p.end);
            }
        }
        len += end - start;
        System.out.println(len);
    }
}
/*
4
1 3
2 5
3 5
6 7
 */
