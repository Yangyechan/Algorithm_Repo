package workbook.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;

public class No_8979 {
    static class National implements Comparable<National> {
        int idx, g, s, b;

        National(int idx, int g, int s, int b) {
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(National o) {
            if (o.g == g) {
                if (o.s == s) {
                    if (o.b != b) {
                        return o.b - b;
                    }
                }else {
                    return o.s - s;
                }
            }
            return o.g - g;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int K = Integer.parseInt(ip[1]);

        PriorityQueue<National> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");

            int idx = Integer.parseInt(ip[0]);
            int g = Integer.parseInt(ip[1]);
            int s = Integer.parseInt(ip[2]);
            int b = Integer.parseInt(ip[3]);

            pq.offer(new National(idx, g, s, b));
        }

        int ans = 1;
        National now = pq.poll();

        if (now.idx == K) {
            System.out.println(1);
            return;
        }

        int tmp = 0;
        while (!pq.isEmpty()) {
            National nxt = pq.peek();
            boolean same = false;
            if (now.g == nxt.g) {
                if (now.s == nxt.s) {
                    if (now.b == nxt.b){
                        same = true;
                    }else {
                        ans++;
                    }
                }else {
                    ans++;
                }
            }else {
                ans++;
            }

            if (same) {
                tmp++;
            } else {
                ans += tmp;
                tmp = 0;
            }

            if (nxt.idx == K) {
                System.out.println(ans);
                break;
            }

            now = pq.poll();
        }
    }
}
