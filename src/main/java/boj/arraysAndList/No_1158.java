package boj.arraysAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (queue.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                int num = queue.poll();
                queue.add(num);
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb);
    }
}
