package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int w = Integer.parseInt(str[1]);
        int L = Integer.parseInt(str[2]);
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> load = new LinkedList<>();
        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(str2[i]));
        }
        for (int i = 0; i < w; i++) {
            load.offer(0);
        }
        int cnt = 0;
        int sum = 0;
        while (!load.isEmpty()) {
            cnt++;
            sum -= load.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + sum <= L) {
                    sum += truck.peek();
                    load.offer(truck.poll());
                }else {
                    load.offer(0);
                }
            }
        }
        System.out.println(cnt);
    }
}
