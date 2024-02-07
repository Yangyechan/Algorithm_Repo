package BaekjunOnlineJudge.stackAndQueue;

import java.util.*;

public class No_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int f1 = Math.abs(o1);
            int f2 = Math.abs(o2);
            if (f1 == f2) { // 절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return f1 - f2; // 절댓값 작은 데이터 우선
        });

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                }else {
                    System.out.println(queue.poll());
                }
            }else {
                queue.add(x);
            }
        }
    }
}
