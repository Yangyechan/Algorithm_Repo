package BaekjunOnlineJudge.simulation;


import java.util.*;
import java.io.*;

public class No_16985 {
    static int[][][][] board = new int[4][5][5][5];
    static int[][][] maze = new int[5][5][5];
    static int[] dx = {1, 0, 0, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    board[0][i][j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[1][i][j][k] = board[0][i][4 - k][j];
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[2][i][j][k] = board[1][i][4 - k][j];
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[3][i][j][k] = board[2][i][4 - k][j];
                }
            }
        }

        int[] order = {0, 1, 2, 3, 4};
        int ans = 9999;
        do {
            for (int tmp = 0; tmp < 1024; tmp++) {
                int brute = tmp;
                for (int i = 0; i < 5; i++) {
                    int dir = brute % 4;
                    brute /= 4;
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            maze[i][j][k] = board[dir][order[i]][j][k];
                        }
                    }
                }
                ans = Math.min(ans, solve());
            }
        } while (nextPermutation(order));

        if (ans == 9999) ans = -1;
        System.out.println(ans);
    }

    static int solve() {
        int[][][] dist = new int[5][5][5];
        if (maze[0][0][0] == 0 || maze[4][4][4] == 0) return 9999;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 6; dir++) {
                int x = cur[0];
                int y = cur[1];
                int z = cur[2];
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nz = z + dz[dir];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
                if (maze[nx][ny][nz] == 0 || dist[nx][ny][nz] != 0) continue;
                if (nx == 4 && ny == 4 && nz == 4)
                    return dist[x][y][z];
                dist[nx][ny][nz] = dist[x][y][z] + 1;
                q.offer(new int[]{nx, ny, nz});
            }
        }
        return 9999;
    }

    static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) i--;

        if (i <= 0) return false;

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) j--;

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class No_16985 {
//    static int[][][] map = new int[5][5][5];
//    static int[][][] copyMap = new int[5][5][5];
//    static int[][][] temp = new int[5][5][5];
//    static boolean[][][] visited;
//    static boolean[] check = new boolean[5];
//    static int[] dx = {-1, 0 ,1, 0, 0, 0};
//    static int[] dy = {0, 1, 0, -1, 0, 0};
//    static int[] dz = {0, 0, 0, 0, 1, -1};
//    static int min = Integer.MAX_VALUE;
//    static int[] exit;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                String[] str = br.readLine().split(" ");
//                for (int k = 0; k < 5; k++) {
//                    map[j][k][i] = Integer.parseInt(str[k]);
//                }
//            }
//        }
//
//        for (int t = 0; t < 1024; t++) {
//            int tmp = t;
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    for (int k = 0; k < 5; k++) {
//                        copyMap[j][k][i] = map[j][k][i];
//                    }
//                }
//            }
//            visited = new boolean[5][5][5];
//            for (int h = 0; h < 5; h++) {
//                int dir = tmp % 4;
//                tmp /= 4;
//                if (dir == 0) continue;
//                rotate(h, dir);
//            }
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    for (int k = 0; k < 5; k++) {
//                        temp[j][k][i] = copyMap[j][k][i];
//                    }
//                }
//            }
//            backTracking(0);
//        }
//        if (min == Integer.MAX_VALUE) {
//            System.out.println(-1);
//        }else {
//            System.out.println(min - 1);
//        }
//    }
//    static void rotate(int h, int dir) {
//        int[][] tmp = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                tmp[i][j] = copyMap[i][j][h];
//            }
//        }
//        if (dir == 1) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    copyMap[i][j][h] = tmp[4 - j][i];
//                }
//            }
//        } else if (dir == 2) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    copyMap[i][j][h] = tmp[4 - i][4 - j];
//                }
//            }
//        } else if (dir == 3) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    copyMap[i][j][h] = tmp[j][4 - i];
//                }
//            }
//        }
//    }
//    static void BFS(int x, int y, int h) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{x, y, h});
//        visited[x][y][h] = true;
//        while (!queue.isEmpty()) {
//            int[] now = queue.poll();
//            if (now[0] == exit[0] && now[1] == exit[1] && now[2] == exit[2]) {
//                min = Math.min(min, copyMap[exit[0]][exit[1]][exit[2]]);
//                break;
//            }
//            for (int i = 0; i < 6; i++) {
//                int nx = now[0] + dx[i];
//                int ny = now[1] + dy[i];
//                int nh = now[2] + dz[i];
//                if (!check(nx, ny, nh)) continue;
//                if (!visited[nx][ny][nh]) {
//                    if (copyMap[nx][ny][nh] == 1) {
//                        visited[nx][ny][nh] = true;
//                        copyMap[nx][ny][nh] = copyMap[now[0]][now[1]][now[2]] + 1;
//                        queue.offer(new int[]{nx, ny, nh});
//                    }
//                }
//            }
//        }
//    }
//    static void backTracking(int depth) {
//        if (depth == 5) {
//            if (copyMap[0][0][0] == 1 && copyMap[4][4][4] == 1) {
//                exit = new int[]{4, 4, 4};
//                BFS(0, 0, 0);
//            }
//            if (copyMap[0][4][0] == 1 && copyMap[4][0][4] == 1) {
//                exit = new int[]{4, 0, 4};
//                BFS(0, 4, 0);
//            }
//            if (copyMap[4][0][0] == 1 && copyMap[0][4][4] == 1) {
//                exit = new int[]{0, 4, 4};
//                BFS(4, 0, 0);
//            }
//            if (copyMap[4][4][0] == 1 && copyMap[0][0][4] == 1) {
//                exit = new int[]{0, 0, 4};
//                BFS(4, 4, 0);
//            }
//            return;
//        }
//        for (int i = 0; i < 5; i++) {
//            if (!check[i]) {
//                check[i] = true;
//                for (int j = 0; j < 5; j++) {
//                    for (int k = 0; k < 5; k++) {
//                        copyMap[j][k][depth] = temp[j][k][i];
//                    }
//                }
//                backTracking(depth + 1);
//                check[i] = false;
//            }
//        }
//    }
//    static boolean check(int nx, int ny, int nh) {
//        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nh >= 0 && nh < 5) return true;
//        else return false;
//    }
//}
