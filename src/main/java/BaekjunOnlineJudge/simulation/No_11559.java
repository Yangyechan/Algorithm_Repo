package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_11559 {
    static class bbuyo {
        int x;
        int y;
        char c;
        bbuyo(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static char[][] map = new char[12][6];
    // static char[][] copyMap = new char[12][6];
    static boolean[][] visited;
    static boolean pos = false;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        while (true) {
            pos = false;
            visited = new boolean[12][6];
            BFS();
            gravity();
            if (!pos) break;
        }
        System.out.print(cnt);
    }
    static void BFS() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {
                    Queue<bbuyo> queue = new LinkedList<>();
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    queue.offer(new bbuyo(i, j, map[i][j]));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        bbuyo now = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = now.x + dx[d];
                            int ny = now.y + dy[d];
                            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                                if (!visited[nx][ny] && map[nx][ny] == now.c) {
                                    visited[nx][ny] = true;
                                    queue.offer(new bbuyo(nx, ny, now.c));
                                    list.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    if (list.size() >= 4) {
                        for (int k = 0; k < list.size(); k++) {
                            int[] tmp = list.get(k);
                            map[tmp[0]][tmp[1]] = '.';
                        }
                        cnt++;
                        pos = true;
                    }
                }
            }
        }
    }
    static void gravity() {
        for (int i = 0; i < 6; i++) {
            char[] ch = new char[12];
            Arrays.fill(ch, '.');
            int idx = 11;
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    ch[idx--] = map[j][i];
                }
            }
            idx = 11;
            for (int j = 11; j >= 0; j--) {
                map[j][i] = ch[idx--];
            }
        }
    }
}
