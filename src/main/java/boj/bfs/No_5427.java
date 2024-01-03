package boj.bfs;
import java.util.*;
import java.io.*;

public class No_5427 {
    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int testNo = 0; testNo < TC; testNo++) {
            boolean escape = false;
            Queue<int[]> Qf = new LinkedList<>(), Qs = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bY = Integer.parseInt(st.nextToken());
            int bX = Integer.parseInt(st.nextToken());
            int[][] board = new int[bX][bY];
            int[][] visF = new int[bX][bY];
            int[][] visS = new int[bX][bY];
            for (int[] row: visF) Arrays.fill(row, 0);
            for (int[] row: visS) Arrays.fill(row, 0);

            for (int i = 0; i < bX; i++) {
                String line = br.readLine();
                for (int j = 0; j < bY; j++) {
                    char c = line.charAt(j);
                    if (c == '#') board[i][j] = -1;
                    else {
                        if (c == '@') {
                            Qs.add(new int[]{i, j});
                            visS[i][j] = 1;
                        } else if (c == '*') {
                            Qf.add(new int[]{i, j});
                            visF[i][j] = 1;
                        }
                        board[i][j] = 0;
                    }
                }
            }

            while (!Qf.isEmpty()) {
                int[] v = Qf.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = v[0] + dx[k];
                    int ny = v[1] + dy[k];
                    if (nx < 0 || bX <= nx || ny < 0 || bY <= ny) continue;
                    if (board[nx][ny] == -1) continue;
                    if (visF[nx][ny] != 0) continue;
                    visF[nx][ny] = visF[v[0]][v[1]] + 1;
                    Qf.add(new int[]{nx, ny});
                }
            }

            while (!Qs.isEmpty() && !escape) {
                int[] v = Qs.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = v[0] + dx[k];
                    int ny = v[1] + dy[k];
                    if (nx < 0 || bX <= nx || ny < 0 || bY <= ny) {
                        bw.write(visS[v[0]][v[1]] + "\n");
                        escape = true;
                        break;
                    }
                    if (board[nx][ny] == -1) continue;
                    if (visS[nx][ny] != 0) continue;
                    if (visF[nx][ny] != 0 && visF[nx][ny] <= visS[v[0]][v[1]] + 1) continue;
                    visS[nx][ny] = visS[v[0]][v[1]] + 1;
                    Qs.add(new int[]{nx, ny});
                }
            }

            if (!escape) bw.write("IMPOSSIBLE\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class No_5427 {
//    static int w, h;
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static Queue<int[]> queue1;
//    static Queue<int[]> queue2;
//    static int[][] fMap;
//    static boolean[][] fVisited;
//    static int[][] pMap;
//    static boolean[][] pVisited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            String[] str = br.readLine().split(" ");
//            int w = Integer.parseInt(str[0]);
//            int h = Integer.parseInt(str[1]);
//            fMap = new int[h][w];
//            pMap = new int[h][w];
//            fVisited = new boolean[h][w];
//            pVisited = new boolean[h][w];
//            queue1 = new LinkedList<>();
//            queue2 = new LinkedList<>();
//            for (int j = 0; j < h; j++) {
//                String str2 = br.readLine();
//                for (int k = 0; k < w; k++) {
//                    if (str2.charAt(k) == '#') {
//                        fMap[j][k] = -1;
//                        pMap[j][k] = -1;
//                        fVisited[j][k] = true;
//                        pVisited[j][k] = true;
//                    } else if (str2.charAt(k) == '.') {
//                        fMap[j][k] = 0;
//                        pMap[j][k] = 0;
//                    } else if (str2.charAt(k) == '*') {
//                        fMap[j][k] = 1;
//                        fVisited[j][k] = true;
//                        queue1.offer(new int[]{j, k});
//                    } else if (str2.charAt(k) == '@') {
//                        pMap[j][k] = 1;
//                        pVisited[j][k] = true;
//                        queue2.offer(new int[]{j, k});
//                    }
//                }
//            }
//            while (!queue1.isEmpty()) {
//                int[] now = queue1.poll();
//                for (int j = 0; j < 4; j++) {
//                    int nx = now[0] + dx[j];
//                    int ny = now[1] + dy[j];
//                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
//                        if (fMap[nx][ny] == 0 && !fVisited[nx][ny]) {
//                            fVisited[nx][ny] = true;
//                            fMap[nx][ny] = fMap[now[0]][now[1]] + 1;
//                            queue1.offer(new int[]{nx, ny});
//                        }
//                    }
//                }
//            }
//            while (!queue2.isEmpty()) {
//                int[] now = queue2.poll();
//                for (int j = 0; j < 4; j++) {
//                    int nx = now[0] + dx[j];
//                    int ny = now[1] + dy[j];
//                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
//                        if (fMap[nx][ny] > pMap[now[0]][now[1]] + 1 && !pVisited[nx][ny]) {
//                            pVisited[nx][ny] = true;
//                            pMap[nx][ny] = pMap[now[0]][now[1]] + 1;
//                            queue2.offer(new int[]{nx, ny});
//                        }
//                    }
//                }
//            }
//            int max = Integer.MAX_VALUE;
//            for (int j = 0; j < w; j++) {
//                if (max > pMap[0][j] && pMap[0][j] > 0) {
//                    max = pMap[0][j];
//                }
//            }
//            for (int j = 0; j < w; j++) {
//                if (max > pMap[h-1][j] && pMap[h-1][j] > 0) {
//                    max = pMap[h-1][j];
//                }
//            }
//            for (int j = 0; j < h; j++) {
//                if (max > pMap[j][0] && pMap[j][0] > 0) {
//                    max = pMap[j][0];
//                }
//            }
//            for (int j = 0; j < h; j++) {
//                if (max > pMap[j][w-1] && pMap[j][w-1] > 0) {
//                    max = pMap[j][w-1];
//                }
//            }
//            if (max == Integer.MAX_VALUE) {
//                System.out.println("IMPOSSIBLE");
//            }else {
//                System.out.println(max);
//            }
//        }
//    }
//}
