package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1520 {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        M = Integer.parseInt(strings[0]);
        N = Integer.parseInt(strings[1]);
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] strings1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strings1[j]);
                dp[i][j] = -1; // dp 배열을 -1로 초기화하여 방문 여부를 표시
            }
        }

        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1; // 목적지에 도달한 경우 1을 반환하여 경로의 개수를 카운트
        }

        if (dp[x][y] != -1) {
            return dp[x][y]; // 이미 방문한 경우 저장된 결과를 반환
        }

        dp[x][y] = 0; // 아직 방문하지 않은 경우 0으로 초기화

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny); // 현재 위치에서 다음 위치로 이동하여 경로의 개수를 누적
            }
        }

        return dp[x][y];
    }
}
//public class No_1520 {
//    static class Node {
//        int x, y, cost;
//        Node (int x, int y, int cost){
//            this.x = x;
//            this.y = y;
//            this.cost = cost;
//        }
//    }
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int cnt;
//    static int M, N;
//    static int[][] map;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] strings = br.readLine().split(" ");
//        M = Integer.parseInt(strings[0]);
//        N = Integer.parseInt(strings[1]);
//        map = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            String[] strings1 = br.readLine().split(" ");
//            for (int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(strings1[j]);
//            }
//        }
//        bfs(0, 0, map[0][0]);
//        System.out.println(cnt);
//    }
//    private static void bfs(int x, int y, int cost) {
//        Queue<Node> queue = new LinkedList();
//        queue.add(new Node(x, y, cost));
//        while (!queue.isEmpty()) {
//            Node target = queue.poll();
//            int nx = target.x;
//            int ny = target.y;
//            int ncost = target.cost;
//            if (nx == M - 1 && ny == N - 1) {
//                cnt++;
//            }
//            for (int i = 0; i < 4; i++) {
//                int nextX = nx + dx[i];
//                int nextY = ny + dy[i];
//                if (nextX >= 0 && nextX <= M - 1
//                        && nextY >= 0 && nextY <= N - 1 && (ncost > map[nextX][nextY])) {
//                    queue.add(new Node(nextX, nextY, map[nextX][nextY]));
//                }
//            }
//        }
//    }
//}
