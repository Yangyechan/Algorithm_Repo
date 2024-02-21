package BaekjunOnlineJudge.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No_20955 {
    static int N, M, cnt;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        cnt = 0;
        for (int i = 0; i < M; i++) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            input(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        cnt += set.size() - 1;
        System.out.println(cnt);
    }
    static int find(int a) {
        return parent[a] < 0 ? a : (parent[a] = find(parent[a]));
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            return true;
        }

        return false;
    }

    static void input(int a, int b) {
        if (!union(a, b)) {
            cnt++;
        }
    }
}


//import java.io.*;
//import java.util.*;
//
////  @author : blog.naver.com/kerochuu
////  @date : 2021. 8. 16.
//public class No_20955 {
//
//    static int N, M, count = 0;
//    static int[] parents;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = stoi(st.nextToken());
//        M = stoi(st.nextToken());
//
//        parents = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            parents[i] = -1;
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            input(stoi(st.nextToken()), stoi(st.nextToken()));
//        }
//
//        HashSet<Integer> hs = new HashSet<>();
//        for (int i = 1; i <= N; i++) {
//            hs.add(find(i));
//        }
//        count += hs.size() - 1;
//
//        System.out.println(count);
//    }
//
//    private static void input(int a, int b) {
//        if (!union(a, b)) {
//            count++;
//        }
//    }
//
//    private static boolean union(int a, int b) {
//        a = find(a);
//        b = find(b);
//        if (a != b) {
//            parents[b] = a;
//            return true;
//        }
//        return false;
//    }
//
//    private static int find(int a) {
//        return parents[a] < 0 ? a : (parents[a] = find(parents[a]));
//    }
//
//    private static int stoi(String input) {
//        return Integer.parseInt(input);
//    }
//}
