package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class schedule implements Comparable<schedule> {
    int start, end;

    schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(schedule o) {
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
public class No_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<schedule> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            list.add(new schedule(start, end));
        }

        Collections.sort(list);
        priorityQueue.offer(list.get(0).end);
        for (int i = 1; i < n; i++) {
            if (priorityQueue.peek() <= list.get(i).start) {
                priorityQueue.poll();
                priorityQueue.offer(list.get(i).end);
            }else {
                priorityQueue.offer(list.get(i).end);
            }
        }
        System.out.println(priorityQueue.size());
    }
}
