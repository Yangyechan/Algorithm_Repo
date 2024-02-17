package BaekjunOnlineJudge.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;

public class No_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                pq.offer(Long.parseLong(input[j]));
            }
        }

        long size = pq.size();
        for (int i = 0; i < size - N; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
