package workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class No_2304 {
    static class stick implements Comparable<stick> {
        int L, H;

        stick(int L, int H) {
            this.L = L;
            this.H = H;
        }

        public int compareTo(stick o) {
            return H - o.H;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<stick> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<stick> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");

            int L = Integer.parseInt(ip[0]);
            int H = Integer.parseInt(ip[1]);

            pq.offer(new stick(L, H));
            list.add(new stick(L, H));
        }
        Collections.sort(list);

        int ans = list.get(0).H;
        int st = list.get(0).L;
        int ed = pq.peek().L;
        int height = list.get(0).H;
        int idx = 1;

        for (int i = st+1; i <= ed; i++) {

            stick now = list.get(idx);

            if (now.L == i) {
                idx++;
                if (now.H == pq.peek().H) {
                    ans += pq.poll().H;
                    height = pq.peek().H;
                }else {
                    if (height < now.H) {
                        height = now.H;
                    }
                    ans += height;
                }
            }else {
                ans += height;
            }
        }

        System.out.println(ans);
    }
}
