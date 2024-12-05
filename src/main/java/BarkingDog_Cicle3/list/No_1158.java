package BarkingDog_Cicle3.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < K; i++) {
                int tmp = q.poll();

                if (i == K-1) list.add(tmp);
                else q.offer(tmp);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1) sb.append(list.get(i) + ">");
            else sb.append(list.get(i) + ", ");
        }
        System.out.println(sb);
    }
}
