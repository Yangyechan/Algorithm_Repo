package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;

public class No_2170 {
    static class Line implements Comparable<Line>{
        long st, ed;

        Line(long st, long ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Line o) {
            if (st > o.st) {
                return 1;
            }else if (st == o.st) {
                if (ed > o.ed) {
                    return 1;
                }else if (ed == o.ed){
                    return 0;
                }else {
                    return -1;
                }
            }else {
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            long x = Long.parseLong(ip[0]);
            long y = Long.parseLong(ip[1]);

            pq.offer(new Line(x, y));
        }

        Line now = pq.poll();
        long ans = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Line nxt = pq.peek();

            if (now.ed >= nxt.st) {
                pq.poll();
                if (now.ed < nxt.ed) {
                    now.ed = nxt.ed;
                }
            }else {
                ans += now.ed - now.st;
                now = pq.poll();
            }
        }

        ans += now.ed - now.st;
        System.out.println(ans);
    }
}
