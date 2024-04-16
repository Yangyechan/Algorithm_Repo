package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class No_11000 {
    static class Schedule implements Comparable<Schedule>{
        int st, ed;

        Schedule(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Schedule o) {
            if (st == o.st) return ed - o.ed;
            return st - o.st;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Schedule> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            int s = Integer.parseInt(ip[0]);
            int t = Integer.parseInt(ip[1]);
            list.add(new Schedule(s, t));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).ed);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= list.get(i).st) {
                pq.poll();
                pq.offer(list.get(i).ed);
            }else {
                pq.offer(list.get(i).ed);
            }
        }

        System.out.println(pq.size());
    }
}
/*
8
1 8
9 16
3 7
8 10
10 14
5 6
6 11
11 12

3
 */
