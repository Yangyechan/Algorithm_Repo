package boj.stackAndQueue;

import java.util.*;

public class No_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        int num = 0;
        while (queue.size() > 1) {
            if (num % 2 == 0) {
                queue.poll();
                num = 1;
            }else {
                int x = queue.poll();
                queue.offer(x);
                num = 0;
            }
        }
        System.out.println(queue.poll());
    }
}
