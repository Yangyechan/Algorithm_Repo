package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Node implements Comparable<Node> {
    int x, y, cost;
    Node (int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo (Node o) {
        if (cost == o.cost) {
            if (x == o.x) {
                return Integer.compare(y, o.y);
            }
            return Integer.compare(x, o.x);
        }
        return cost - o.cost;
    }
}
public class No_4485 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        String line = null;
        int idx = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (!(line = br.readLine()).equals("0")) {
            int T = Integer.parseInt(line);
            map = new int[T][T];
            for (int i = 0; i < T; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < T; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
            sb.append("Problem " + idx + ": " + bfs(0, 0, T)+"\n");
            idx++;
        }
        System.out.println(sb);
    }
    private static int bfs(int x, int y, int T) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, map[0][0]));
        int[][] move = new int[T][T];
        for (int i = 0; i < T; i++) {
            Arrays.fill(move[i], 500);
        }
        move[x][y] = map[x][y];
        while (!q.isEmpty()) {
            Node target = q.poll();
            int px = target.x;
            int py = target.y;
            if (px == T-1 && py == T-1) {
                return target.cost;
            }
            for (int i = 0; i < 4; i++) {
                int nx = target.x + dx[i];
                int ny = target.y + dy[i];
                if (nx >= 0 && nx < T && ny >=0 && ny < T) {
                    if (target.cost + map[nx][ny] < move[nx][ny]) {
                        move[nx][ny] = target.cost + map[nx][ny];
                        q.add(new Node(nx, ny, move[nx][ny]));
                    }
                }
            }
        }
        return -1;
    }
}
