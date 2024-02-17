package BaekjunOnlineJudge.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max.size() <= min.size()) {
                max.offer(num);
            }else {
                min.offer(num);
            }
            if (!min.isEmpty() && min.peek() < max.peek()) {
                min.offer(max.poll());
                max.offer(min.poll());
            }
            sb.append(max.peek() + "\n");
        }
        System.out.println(sb);
    }
}

