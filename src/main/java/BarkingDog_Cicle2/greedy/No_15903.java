package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PriorityQueue;

public class No_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        ip = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(ip[i]);
            pq.offer(num);
        }

        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            long tmp = a + b;

            pq.offer(tmp);
            pq.offer(tmp);
        }

        int size = pq.size();
        long ans = 0;
        for (int i = 0; i < size; i++) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}
