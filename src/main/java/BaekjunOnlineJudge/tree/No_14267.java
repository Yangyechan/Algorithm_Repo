package BaekjunOnlineJudge.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_14267 {
    static int[] parent;
    static List<List<Integer>> lists;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        split = br.readLine().split(" ");
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(split[i-1]);
            if (num == -1) continue;
            parent[i] = num;
            lists.get(num).add(i);
        }

        count = new int[n + 1];
        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int num = Integer.parseInt(split[0]);
            int score = Integer.parseInt(split[1]);
            count[num] += score;
        }

        DFS(1, -1);

        for (int i = 1; i <= n; i++) {
            System.out.print(count[i] + " ");
        }
    }
    static void DFS(int x, int score) {
        if (parent[x] != -1) {
            count[x] += count[parent[x]];
        }
        for (int nxt : lists.get(x)) {
            DFS(nxt, score);
        }
    }
}



//import java.util.*;
//import java.io.*;
//
//public class No_14267 {
//    static int n, m;
//    static int[] p;
//    static int[] score;
//    static ArrayList<Integer>[] child;
//
//    public static void dfs(int cur) {
//        if(p[cur] != -1)
//            score[cur] += score[p[cur]];
//        for(int nxt : child[cur])
//            dfs(nxt);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        p = new int[n+1];
//        score = new int[n+1];
//        child = new ArrayList[n+1];
//
//        for(int i = 1; i <= n; i++){
//            child[i] = new ArrayList<>();
//            p[i] = Integer.parseInt(br.readLine());
//            if(p[i] != -1)
//                child[p[i]].add(i);
//        }
//        while(m-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int i = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//            score[i] += w;
//        }
//        dfs(1);
//        for(int i = 1; i <= n; i++)
//            System.out.print(score[i] + " ");
//    }
//}
