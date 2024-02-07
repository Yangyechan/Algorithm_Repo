package BaekjunOnlineJudge.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        String[] str2 = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(str2[i]);
            while (true) {
                int idx = 0;
                for (int target : deque) {
                    if (target == num) {
                        break;
                    }
                    idx++;
                }
                if (idx == 0) {
                    deque.pollFirst();
                    break;
                }else if (idx <= deque.size() / 2) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    cnt++;
                } else {
                    int temp2 = deque.pollLast();
                    deque.offerFirst(temp2);
                    cnt++;
                }
            }

        }
        System.out.println(cnt);
    }
}
