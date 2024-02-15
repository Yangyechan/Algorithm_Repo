package BaekjunOnlineJudge.binarySearchTree;

import java.util.*;
import java.io.*;

public class No_21944 {
    static String op;
    static int N, L, P, G, x;
    static Pair[] probLevel = new Pair[100002];
    static TreeSet<Integer>[] probByL = new TreeSet[102];
    static TreeSet<Integer>[][] probByGL = new TreeSet[102][102];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i = 0; i < 102; i++) {
            probByL[i] = new TreeSet<>();
            for(int j = 0; j < 102; j++) {
                probByGL[i][j] = new TreeSet<>();
            }
        }

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            probLevel[P] = new Pair(L, G);
            probByL[L].add(P);
            probByGL[G][L].add(P);
        }

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            if (op.equals("recommend")) {
                G = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    for (int i = 100; i >= 0; i--) {
                        if (probByGL[G][i].isEmpty()) continue;
                        System.out.println(probByGL[G][i].last());
                        break;
                    }
                } else {
                    for (int i = 0; i < 101; i++) {
                        if (probByGL[G][i].isEmpty()) continue;
                        System.out.println(probByGL[G][i].first());
                        break;
                    }
                }
            }

            else if(op.equals("recommend2")){
                x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    for (int i = 100; i >= 0; i--) {
                        if (probByL[i].isEmpty()) continue;
                        System.out.println(probByL[i].last());
                        break;
                    }
                } else {
                    for (int i = 0; i < 101; i++) {
                        if (probByL[i].isEmpty()) continue;
                        System.out.println(probByL[i].first());
                        break;
                    }
                }
            }

            else if(op.equals("recommend3")){
                x = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                int ans = -1;
                if(x == 1){
                    for(int i = L; i < 101; i++){
                        if(probByL[i].isEmpty()) continue;
                        ans = probByL[i].first();
                        break;
                    }
                }
                else{
                    for(int i = L-1; i >= 0; i--){
                        if(probByL[i].isEmpty()) continue;
                        ans = probByL[i].last();
                        break;
                    }
                }
                System.out.println(ans);
            }

            else if (op.equals("add")) {
                P = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                G = Integer.parseInt(st.nextToken());
                probLevel[P] = new Pair(L, G);
                probByL[L].add(P);
                probByGL[G][L].add(P);
            }

            else if (op.equals("solved")) {
                P = Integer.parseInt(st.nextToken());
                L = probLevel[P].first;
                G = probLevel[P].second;
                probByL[L].remove(P);
                probByGL[G][L].remove(P);
            }
        }
    }

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeSet;
//
//class solve implements Comparable<solve> {
//    int num, level, algo;
//
//    solve(int num, int level, int algo) {
//        this.num = num;
//        this.level = level;
//        this.algo = algo;
//    }
//
//    @Override
//    public int compareTo(solve o) {
//        if (level == o.level) {
//            return num - o.num;
//        }
//        return level - o.level;
//    }
//}
//public class No_21944 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        TreeSet<solve> ts = new TreeSet<>();
//        int N = Integer.parseInt(br.readLine());
//
//        Map<Integer, solve> numMap = new HashMap<>();
//        Map<Integer, TreeSet<solve>> map1 = new HashMap<>();
//        Map<Integer, TreeSet<solve>> map3 = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            String[] input = br.readLine().split(" ");
//            int num = Integer.parseInt(input[0]);
//            int level = Integer.parseInt(input[1]);
//            int algo = Integer.parseInt(input[2]);
//            ts.add(new solve(num, level, algo));
//            numMap.put(num, new solve(num, level, algo));
//            if (!map1.containsKey(algo)) {
//                map1.put(algo, new TreeSet<>());
//                map1.get(algo).add(new solve(num, level, algo));
//            }else {
//                map1.get(algo).add(new solve(num, level, algo));
//            }
//            if (!map3.containsKey(level)) {
//                map3.put(level, new TreeSet<>());
//                map3.get(level).add(new solve(num, level, algo));
//            }else {
//                map3.get(level).add(new solve(num, level, algo));
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int M = Integer.parseInt(br.readLine());
//        for (int i = 0; i < M; i++) {
//            String[] input = br.readLine().split(" ");
//
//            if (input[0].equals("recommend")) {
//                int key = Integer.parseInt(input[1]);
//                if (!map1.containsKey(key)) continue;
//                if (input[2].equals("1")) {
//                    sb.append(map1.get(key).last().num + "\n");
//                }else {
//                    sb.append(map1.get(key).first().num + "\n");
//                }
//            } else if (input[0].equals("recommend2")) {
//                if (ts.isEmpty()) continue;
//                if (input[1].equals("1")) {
//                    sb.append(ts.last().num + "\n");
//                }else {
//                    sb.append(ts.first().num + "\n");
//                }
//            } else if (input[0].equals("recommend3")) {
//                int L = Integer.parseInt(input[2]);
//                boolean check = false;
//                if (input[1].equals("1")) {
//                    for (int j = L; j <= 100; j++) {
//                        if (map3.containsKey(j) && !map3.get(j).isEmpty()) {
//                            sb.append(map3.get(j).first().num + "\n");
//                            check = true;
//                            break;
//                        }
//                    }
//                    if (!check) sb.append(-1 + "\n");
//                }else {
//                    for (int j = L; j >= 1; j--) {
//                        if (map3.containsKey(j) && !map3.get(j).isEmpty()) {
//                            sb.append(map3.get(j).last().num + "\n");
//                            check = true;
//                            break;
//                        }
//                    }
//                    if (!check) sb.append(-1 + "\n");
//                }
//            } else if (input[0].equals("add")) {
//                int num = Integer.parseInt(input[1]);
//                int level = Integer.parseInt(input[2]);
//                int algo = Integer.parseInt(input[3]);
//                ts.add(new solve(num, level, algo));
//                numMap.put(num, new solve(num, level, algo));
//                if (!map1.containsKey(algo)) {
//                    map1.put(algo, new TreeSet<>());
//                    map1.get(algo).add(new solve(num, level, algo));
//                }else {
//                    map1.get(algo).add(new solve(num, level, algo));
//                }
//                if (!map3.containsKey(level)) {
//                    map3.put(level, new TreeSet<>());
//                    map3.get(level).add(new solve(num, level, algo));
//                }else {
//                    map3.get(level).add(new solve(num, level, algo));
//                }
//            }else {
//                int key = Integer.parseInt(input[1]);
//                solve s = numMap.get(key);
//                numMap.remove(key);
//                ts.remove(s);
//                map1.get(s.algo).remove(s);
//                map3.get(s.level).remove(s);
//            }
//        }
//        System.out.println(sb);
//    }
//}
