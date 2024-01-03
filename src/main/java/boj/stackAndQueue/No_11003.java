package boj.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class No_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int L = Integer.parseInt(str[1]);
        String[] str2 = br.readLine().split(" ");
        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(str2[i]);
            while (!deque.isEmpty() && deque.peekLast()[1] > num) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, num});
            if (i - deque.peekFirst()[0] >= L) {
                deque.pollFirst();
            }
            sb.append(deque.peekFirst()[1] + " ");
            //System.out.print(deque.peekFirst()[1] + " ");
        }
        System.out.println(sb);
    }
}
