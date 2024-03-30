package BarkingDog_Cicle2.dynamicProgramming;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class No_1463 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int X = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[X+1];
//        boolean[] visited = new boolean[X+1];
//
//        int cnt = 0;
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{1, 0});
//        visited[1] = true;
//        arr[1] = 0;
//        while (!queue.isEmpty()) {
//            int[] now = queue.poll();
//            int a = now[0] * 3;
//            int b = now[0] * 2;
//            int c = now[0] + 1;
//
//            if (a > 0 && a <= X) {
//                if (!visited[a]) {
//                    visited[a] = true;
//                    queue.offer(new int[]{a, now[1] + 1});
//                    arr[a] = now[1] + 1;
//                }
//            }
//
//            if (b > 0 && b <= X) {
//                if (!visited[b]) {
//                    visited[b] = true;
//                    queue.offer(new int[]{b, now[1] + 1});
//                    arr[b] = now[1] + 1;
//                }
//            }
//
//            if (c > 0 && c <= X) {
//                if (!visited[c]) {
//                    visited[c] = true;
//                    queue.offer(new int[]{c, now[1] + 1});
//                    arr[c] = now[1] + 1;
//                }
//            }
//        }
//
//        System.out.println(arr[X]);
//    }
//}


import java.util.Scanner;

public class No_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}