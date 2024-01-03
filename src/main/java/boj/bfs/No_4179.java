package boj.bfs;
import java.util.*;

public class No_4179 {
    static int n, m;
    static int[][] dist1 = new int[1002][1002]; // 불의 전파 시간
    static int[][] dist2 = new int[1002][1002]; // 지훈이의 이동 시간
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static String[] board = new String[1002];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        for(int i = 0; i < n; i++)
            board[i] = sc.next();

        Queue<Pair> Q1 = new LinkedList<>();
        Queue<Pair> Q2 = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'F'){
                    Q1.offer(new Pair(i, j));
                    dist1[i][j] = 0;
                }
                if(board[i].charAt(j) == 'J'){
                    Q2.offer(new Pair(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        // 불에 대한 BFS
        while(!Q1.isEmpty()){
            Pair cur = Q1.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist1[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                dist1[nx][ny] = dist1[cur.x][cur.y]+1;
                Q1.offer(new Pair(nx, ny));
            }
        }

        // 지훈이에 대한 BFS
        while(!Q2.isEmpty()){
            Pair cur = Q2.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    System.out.println(dist2[cur.x][cur.y]+1);
                    return;
                }
                if(dist2[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y]+1) continue;
                dist2[nx][ny] = dist2[cur.x][cur.y]+1;
                Q2.offer(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class No_4179 {
//    static int R,C;
//    static int[][] fMap;
//    static int[][] jMap;
//    static boolean[][] jVisited;
//    static boolean[][] fVisited;
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static Queue<int[]> queue1;
//    static Queue<int[]> queue2;
//
//    static int minNum = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        R = Integer.parseInt(str[0]);
//        C = Integer.parseInt(str[1]);
//        jMap = new int[R][C];
//        fMap = new int[R][C];
//        jVisited = new boolean[R][C];
//        fVisited = new boolean[R][C];
//        queue1 = new LinkedList<>();
//        queue2 = new LinkedList<>();
//
//        for (int i = 0; i < R; i++) {
//            String str2 = br.readLine();
//            for (int j = 0; j < C; j++) {
//                if (str2.charAt(j) == '#') {
//                    fMap[i][j] = -1;
//                    jMap[i][j] = -1;
//                    fVisited[i][j] = true;
//                    jVisited[i][j] = true;
//                } else if (str2.charAt(j) == '.') {
//                    fMap[i][j] = 0;
//                    jMap[i][j] = 0;
//
//                } else if (str2.charAt(j) == 'J') {
//                    jMap[i][j] = 1;
//                    jVisited[i][j] = true;
//                    queue2.offer(new int[]{i, j});
//                } else if (str2.charAt(j) == 'F') {
//                    fMap[i][j] = 1;
//                    fVisited[i][j] = true;
//                    queue1.offer(new int[]{i, j});
//                }
//            }
//        }
//        BFS1();
//        BFS2();
//        for (int i = 0; i < C; i++) {
//            if (jMap[0][i] < minNum && jMap[0][i] > 0) {
//                minNum = jMap[0][i];
//            }
//        }
//        for (int i = 0; i < C; i++) {
//            if (jMap[R-1][i] < minNum && jMap[R-1][i] > 0) {
//                minNum = jMap[R-1][i];
//            }
//        }
//        for (int i = 0; i < R; i++) {
//            if (jMap[i][0] < minNum && jMap[i][0] > 0) {
//                minNum = jMap[i][0];
//            }
//        }
//        for (int i = 0; i < R; i++) {
//            if (jMap[i][C-1] < minNum && jMap[i][C-1] > 0) {
//                minNum = jMap[i][C-1];
//            }
//        }if (minNum == Integer.MAX_VALUE) {
//            System.out.println("IMPOSSIBLE");
//        } else if (minNum > 0) {
//            System.out.println(minNum);
//        }else {
//            System.out.println("IMPOSSIBLE");
//        }
//    }
//    static void BFS1() {
//        while (!queue1.isEmpty()) {
//            int[] now = queue1.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = now[0] + dx[i];
//                int ny = now[1] + dy[i];
//                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
//                    if (fMap[nx][ny] >= 0 && !fVisited[nx][ny]) {
//                        fVisited[nx][ny] = true;
//                        fMap[nx][ny] = fMap[now[0]][now[1]] + 1;
//                        queue1.offer(new int[]{nx, ny});
//                    }
//                }
//            }
//        }
//    }
//    static void BFS2() {
//        while (!queue2.isEmpty()) {
//            int[] now = queue2.poll();
//            if (jMap[now[0]][now[1]] >= fMap[now[0]][now[1]]) {
//                break;
//            }
//            for (int i = 0; i < 4; i++) {
//                int nx = now[0] + dx[i];
//                int ny = now[1] + dy[i];
//                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
//                    if (jMap[nx][ny] >= 0 && !jVisited[nx][ny] && jMap[nx][ny] < fMap[nx][ny]) {
//                        jVisited[nx][ny] = true;
//                        jMap[nx][ny] = jMap[now[0]][now[1]] + 1;
//                        queue2.offer(new int[]{nx, ny});
//                    }
//                }
//            }
//        }
//    }
//}
