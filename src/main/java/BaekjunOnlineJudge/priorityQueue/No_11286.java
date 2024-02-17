package BaekjunOnlineJudge.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class number implements Comparable<number> {
    int og, abs;

    number(int og, int abs) {
        this.og = og;
        this.abs = abs;
    }

    @Override
    public int compareTo(number o) {
        if (abs == o.abs) {
            return og - o.og;
        }
        return abs - o.abs;
    }
}
public class No_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<number> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                }else {
                    number target = pq.poll();
                    sb.append(target.og + "\n");
                }
            }else {
                pq.offer(new number(x, Math.abs(x)));
            }
        }
        System.out.println(sb);
    }
}
