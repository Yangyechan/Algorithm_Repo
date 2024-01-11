package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class No_15686 {
    static int N, M;
    static int[][] map;
    static boolean[] check;
    static List<int[]> list1;
    static List<int[]> list2;
    static int min = Integer.MAX_VALUE;
    static int[] pickList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][N];
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        pickList = new int[M];

        for (int i = 0; i < N; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str2[j]);
                if (map[i][j] == 1) {
                    list1.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    list2.add(new int[]{i, j});
                }
            }
        }

        check = new boolean[list2.size()];
        func(0);
        System.out.print(min);
    }

    static void func(int depth) {
        if (depth == M) {
            int sum = 0;
            for (int i = 0; i < list1.size(); i++) {
                int[] now1 = list1.get(i);
                PriorityQueue<Integer> queue = new PriorityQueue<>();
                for (int j = 0; j < M; j++) {
                    int dir = 0;
                    int[] now2 = list2.get(pickList[j]);
                    dir += Math.abs(now2[0] - now1[0]);
                    dir += Math.abs(now2[1] - now1[1]);
                    queue.offer(dir);
                    if (dir == 1) break;
                }
                sum += queue.poll();
            }
            min = Math.min(sum, min);
            return;
        }

        for (int i = depth; i < list2.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                pickList[depth] = i;
                func(depth + 1);
                check[i] = false;
            }
        }
        // 백트래킹 최적화를 위한 가지치기
        int start = (depth == 0) ? 0 : pickList[depth - 1] + 1; // 이전에 선택한 인덱스 다음부터 시작
        for (int i = start; i < list2.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                pickList[depth] = i;

                func(depth + 1);
                check[i] = false;
            }
        }
    }
}

