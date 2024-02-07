package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();

        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(str[i]));
        }

        while (m-- > 0) {
            long o = pq.poll();
            long t = pq.poll();
            long sum = o + t;

            for (int i = 0; i < 2; i++) {
                pq.offer(sum);
            }
        }

        long ans = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}
