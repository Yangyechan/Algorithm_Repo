package boj.dijkstra;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class No_1446_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();
            if (end <= D) {
                list.add(new int[]{start, end, distance});
            }
        }

        int[] dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        for (int i = 0; i <= D; i++) {
            if ((i + 1) <= D) {
                dist[i + 1] = Math.min(dist[i + 1], dist[i] + 1);
                for (int[] target : list) {
                    int start = target[0];
                    int end = target[1];
                    int distance = target[2];
                    if (i == start && end <= D) {
                        dist[end] = Math.min(dist[end], distance + dist[i]);
                    }
                }
            }
        }
        System.out.println(dist[D]);
    }
}
