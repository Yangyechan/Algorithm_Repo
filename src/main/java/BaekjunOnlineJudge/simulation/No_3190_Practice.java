package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No_3190_Practice {
    static int N;
    static int[][] map;
    static Deque<int[]> deque = new ArrayDeque<>();
    static Map<Integer, String> lr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        lr = new HashMap<>();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                map[x-1][y-1] = 2;
            }
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(str2[0]);
                lr.put(num, str2[1]);
            }
        }

        int cnt = 0;
        int dir = 1;
        deque.offerFirst(new int[]{0, 0});
        while (true) {
            cnt++;
            dir %= 4;
            int[] now = deque.peekFirst();
            map[now[0]][now[1]] = 1;

            int nx = now[0] + dx[dir];
            int ny = now[1] + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1) break;

            if (map[nx][ny] != 2) {
                int[] tail = deque.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            if (lr.containsKey(cnt)) {
                String s = lr.get(cnt);
                lr.remove(cnt);
                if (s.equals("L")) dir += 1;
                else dir += 3;
            }

            deque.offerFirst(new int[]{nx, ny});
        }
        System.out.println(cnt);
    }
}
