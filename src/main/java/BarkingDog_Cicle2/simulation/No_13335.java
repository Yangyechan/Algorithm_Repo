package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int w = Integer.parseInt(ip[1]);
        int L = Integer.parseInt(ip[2]);

        int[] truck = new int[n];
        ip = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(ip[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        long time = 0;
        long now = 0;
        int idx = 0;
        while (!queue.isEmpty()) {
            time++;

            if (idx == n) {
                queue.poll();
                continue;
            }

            now -= queue.peek();

            if (now + truck[idx] <= L) {
                queue.poll();
                now += truck[idx];
                queue.offer(truck[idx++]);
            }else {
                queue.poll();
                queue.offer(0);
            }
        }

        System.out.println(time);
    }
}
