package BarkingDog_Cicle2.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_9466 {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            ans = 0;

            String[] ip = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(ip[i]);
                arr[i+1] = num;
            }

            for (int i = 1; i <= n; i++) {
                DFS(i);
            }

            System.out.println(n-ans);
        }
    }
    static void DFS(int x) {
        if (visited[x]) {
            return;
        }

        visited[x] = true;
        int nxt = arr[x];

        if (!visited[nxt]) DFS(nxt);
        else {
            if (!finished[nxt]) {
                ans++;

                for (int i = nxt; i != x; i = arr[i]) {
                    ans++;
                }
            }
        }

        finished[x] = true;
    }
}



//import java.util.*;
//import java.io.*;
//
//class Main {
//    static int stoi(String s) { return Integer.parseInt(s);}
//
//    static int n;
//    static int[] arr;
//    static int count = 0;
//    static boolean[] visited;
//    static boolean[] finished;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int tc = stoi(br.readLine());
//
//        for(int t=0; t<tc; t++) {
//            n = stoi(br.readLine());
//            arr = new int[n+1];
//            visited = new boolean[n+1];
//            finished = new boolean[n+1];
//            count = 0;
//
//            st = new StringTokenizer(br.readLine());
//            for(int i=1; i<n+1; i++)
//                arr[i] = stoi(st.nextToken());
//
//            for(int i=1; i<n+1; i++)
//                dfs(i);
//
//            System.out.println(n - count);
//        }
//    }
//
//    static void dfs(int now) {
//        if(visited[now])
//            return;
//
//        visited[now] = true;
//        int next = arr[now];
//
//        if(visited[next] != true)
//            dfs(next);
//        else {
//            if(finished[next] != true) {
//                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
//                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
//                count++;
//                for(int i=next; i != now; i = arr[i])
//                    count++;
//            }
//        }
//
//        // 모든 작업이 끝나서 더이상 사용하지 않음
//        finished[now] = true;
//    }
//}