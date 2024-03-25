package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_13460 {
    static int N, M;
    static char[][] map;
    static int[][] locate = new int[2][2]; // 0행 레드, 1행 블루, 2행 구멍
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean pos;
    static boolean blueFirst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);

        map = new char[N+1][M+1];
        char[][] copyMap = new char[N+1][M+1];
        for (int i = 0; i <= N; i++) {
            if (i == N) {
                Arrays.fill(copyMap[N], '#');
                continue;
            }
            String st = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = st.charAt(j);
                copyMap[i][j] = ch;

                if (ch == 'R') {
                    locate[0][0] = i;
                    locate[0][1] = j;
                } else if (ch == 'B') {
                    locate[1][0] = i;
                    locate[1][1] = j;
                }
            }
            copyMap[i][M] = '#';
        }

        int rx = locate[0][0];
        int ry = locate[0][1];
        int bx = locate[1][0];
        int by = locate[1][1];

        int T = (int) Math.pow(4, 10);
        for (int t = 0; t < T; t++) {
            int tc = t;
            int cnt = 0;
            pos = false;
            blueFirst = false;
            locate[0][0] = rx;
            locate[0][1] = ry;
            locate[1][0] = bx;
            locate[1][1] = by;

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    map[i][j] = copyMap[i][j];
                }
            }

            for (int i = 0; i < 10; i++) {
                cnt++;
                int dir = tc % 4;
                tc /= 4;
                if (dir == 0) {
                    int r = locate[0][1];
                    int b = locate[1][1];

                    if (r > b) {
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                    }else {
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                        if (blueFirst) {
                            break;
                        }
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                    }

                    if (pos && !blueFirst) {
                        if (cnt < min) {
                            min = cnt;
                        }
                        break;
                    }
                } else if (dir == 1) {
                    int r = locate[0][0];
                    int b = locate[1][0];

                    if (r > b) {
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                    }else {
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                        if (blueFirst) {
                            break;
                        }
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                    }

                    if (pos && !blueFirst) {
                        if (cnt < min) {
                            min = cnt;
                        }
                        break;
                    }
                } else if (dir == 2) {
                    int r = locate[0][1];
                    int b = locate[1][1];

                    if (r < b) {
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                    }else {
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                        if (blueFirst) {
                            break;
                        }
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                    }

                    if (pos && !blueFirst) {
                        if (cnt < min) {
                            min = cnt;
                        }
                        break;
                    }
                }else {
                    int r = locate[0][0];
                    int b = locate[1][0];

                    if (r < b) {
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                    }else {
                        DFS(locate[1][0], locate[1][1], dir, 'B');
                        if (blueFirst) {
                            break;
                        }
                        DFS(locate[0][0], locate[0][1], dir, 'R');
                    }

                    if (pos && !blueFirst) {
                        if (cnt < min) {
                            min = cnt;
                        }
                        break;
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
    static void DFS(int x, int y, int dir, char color) {
        if (x == N && y == M) return;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (map[nx][ny] == 'O') {
            if (color == 'R') {
                pos = true;
                map[locate[0][0]][locate[0][1]] = '.';
                locate[0][0] = N;
                locate[0][1] = M;
            } else {
                if (!pos) blueFirst = true;

                pos = false;
                map[locate[1][0]][locate[1][1]] = '.';
                locate[1][0] = N;
                locate[1][1] = M;
            }
        } else if (map[nx][ny] == '.') {
            DFS(nx, ny, dir, color);
        } else {
            if (color == 'R') {
                map[locate[0][0]][locate[0][1]] = '.';
                map[x][y] = 'R';
                locate[0][0] = x;
                locate[0][1] = y;
            } else {
                map[locate[1][0]][locate[1][1]] = '.';
                map[x][y] = 'B';
                locate[1][0] = x;
                locate[1][1] = y;
            }
        }
    }
}
