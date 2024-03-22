package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_3190 {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Time {
        int t;
        String dir;

        Time(int t, String dir) {
            this.t = t;
            this.dir = dir;
        }

    }

    static List<Node> snake = new ArrayList<>();
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Time> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            String[] ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            map[a-1][b-1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] ip = br.readLine().split(" ");
            int t = Integer.parseInt(ip[0]);
            q.offer(new Time(t, ip[1]));
        }

        int cnt = 0;
        int dir = 0;
        snake.add(new Node(0, 0));
        map[0][0] = 2;
        while (true) {
            int x = snake.get(0).x;
            int y = snake.get(0).y;

            if (!q.isEmpty() && q.peek().t == cnt) {
                if (q.peek().dir.equals("L")) {
                    dir = (dir + 3) % 4;
                }else {
                    dir = (dir + 1) % 4;
                }
                q.poll();
            }

            x += dx[dir];
            y += dy[dir];

            if (x < 0 || x >= N || y < 0 || y >= N) break;
            if (map[x][y] == 2) break;

            if (map[x][y] == 1) {
                snake.add(0, new Node(x, y));
                map[x][y] = 2;
            }else {
                Node tail = snake.get(snake.size()-1);
                map[tail.x][tail.y] = 0;
                map[x][y] = 2;
                snake.remove(snake.size()-1);
                snake.add(0, new Node(x, y));
            }

            cnt++;
        }

        System.out.println(cnt+1);
    }
}
