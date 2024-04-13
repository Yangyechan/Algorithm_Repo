package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No_1931 {
    static class Room implements Comparable<Room> {
        int st, ed;

        Room(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Room o) {
            if (ed == o.ed) return st - o.st;
            return ed - o.ed;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            int s = Integer.parseInt(ip[0]);
            int e = Integer.parseInt(ip[1]);
            pq.offer(new Room(s, e));
        }

        int ans = 1;
        int now = pq.peek().ed;
        pq.poll();
        while (!pq.isEmpty()) {
            Room tmp = pq.poll();

            if (now <= tmp.st) {
                now = tmp.ed;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
