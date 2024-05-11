package workbook.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_23971 {
    static boolean[][] visited;
    static int H, W, N, M;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        H = Integer.parseInt(ip[0]);
        W = Integer.parseInt(ip[1]);
        N = Integer.parseInt(ip[2]);
        M = Integer.parseInt(ip[3]);
//
//        visited = new boolean[H][W];
//
//        DFS(0, 0);

        int x = 0;
        int xCnt = 0;
        while (x <= H-1) {
            x += N+1;
            xCnt++;
        }

        int y = 0;
        int yCnt = 0;
        while (y <= W-1) {
            y += M+1;
            yCnt++;
        }

        System.out.println(xCnt * yCnt);
    }
}
