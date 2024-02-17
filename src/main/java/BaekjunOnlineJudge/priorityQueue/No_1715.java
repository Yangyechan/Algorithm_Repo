package BaekjunOnlineJudge.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long ans = 0;
        while (true) {
            if (pq.size() == 1) {
                break;
            }
            long x = pq.poll();
            long y = pq.poll();
            long tmp = x + y;

            ans += tmp;
            pq.offer(tmp);
        }

        System.out.println(ans);
    }
}
