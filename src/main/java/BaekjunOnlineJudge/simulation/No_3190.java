package BaekjunOnlineJudge.simulation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class No_3190 {
    static int n, k;
    static int[][] board; // 1: 뱀, 2: 사과
    static int second = 0;
    static int[] dx = {1, 0, -1, 0};  // [1][0]: 아래, [0][1]: 오른쪽, [-1][0]: 위, [0][-1]: 왼쪽
    static int[] dy = {0, 1, 0, -1};
    static Deque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
    static Queue<Pair<Integer, Character>> switchDir = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a][b] = 2; // 사과
        }

        int l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int c = sc.nextInt();
            char d = sc.next().charAt(0);
            switchDir.add(new Pair<>(c, d)); // 방향전환
        }

        dq.offerFirst(new Pair<>(1, 1));
        int dir = 1;

        while (true) {
            dir %= 4;

            Pair<Integer, Integer> cur = dq.peekFirst();
            board[cur.getX()][cur.getY()] = 1;
            second++;

            int nx = cur.getX() + dx[dir];
            int ny = cur.getY() + dy[dir];

            if (nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 1) break;

            if (board[nx][ny] != 2) {
                Pair<Integer, Integer> tail = dq.peekLast();
                board[tail.getX()][tail.getY()] = 0;
                dq.pollLast();
            }

            if (!switchDir.isEmpty() && switchDir.peek().getX() == second) {
                Pair<Integer, Character> sd = switchDir.poll();
                if (sd.getY() == 'L') dir += 1;
                else if (sd.getY() == 'D') dir += 3;
            }

            dq.offerFirst(new Pair<>(nx, ny));
        }
        System.out.println(second);
        sc.close();
    }

    static class Pair<X, Y> {
        private X x;
        private Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getX() {
            return x;
        }

        public Y getY() {
            return y;
        }
    }
}


