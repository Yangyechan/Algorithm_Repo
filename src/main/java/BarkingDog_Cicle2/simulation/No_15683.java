package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_15683 {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static class cctv{
        int x, y;

        cctv(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<cctv> lists = new ArrayList<>();
    static int[] dir;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(ip[j]);
                map[i][j] = num;
                if (num >= 1 && num <= 5) {
                    lists.add(new cctv(i, j));
                }
            }
        }

        dir = new int[lists.size()];
        backTracking(0);
        System.out.println(max);
    }
    static void backTracking(int depth) {
        if (depth == lists.size()) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < depth; i++) {
                int x = lists.get(i).x;
                int y = lists.get(i).y;
                int cctv = map[x][y];
                int d = dir[i];

                if (cctv == 1) {
                    DFS(x, y, d);
                } else if (cctv == 2) {
                    DFS(x, y, d);
                    DFS(x, y, (d + 2) % 4);
                } else if (cctv == 3) {
                    DFS(x, y, d);
                    DFS(x, y, (d + 1) % 4);
                } else if (cctv == 4) {
                    DFS(x, y, d);
                    DFS(x, y, (d + 1) % 4);
                    DFS(x, y, (d + 2) % 4);
                }else {
                    DFS(x, y, d);
                    DFS(x, y, (d + 1) % 4);
                    DFS(x, y, (d + 2) % 4);
                    DFS(x, y, (d + 3) % 4);
                }
            }
            
            zeroCnt();
            return;
        }

        for (int i = 0; i < 4; i++) {
            dir[depth] = i;
            backTracking(depth+1);
        }
    }

    static void DFS(int x, int y, int d) {
        if (copyMap[x][y] == 6) return;
        else if (copyMap[x][y] == 0) {
            copyMap[x][y] = 7;
        }

        if (d == 0) {
            int ny = y + 1;
            if (ny < M) {
                DFS(x, ny, 0);
            }
        } else if (d == 1) {
            int nx = x + 1;
            if (nx < N) {
                DFS(nx, y, 1);
            }
        } else if (d == 2) {
            int ny = y - 1;
            if (ny >= 0) {
                DFS(x, ny, 2);
            }
        }else {
            int nx = x - 1;
            if (nx >= 0) {
                DFS(nx, y, 3);
            }
        }
    }

    static void zeroCnt() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        
        if (cnt < max) max = cnt;
    }
}
