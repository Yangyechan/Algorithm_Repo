package boj.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_2252_TopologySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] indegree = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            indegree[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : list.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
//public class No_2252_TopologySort {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//        for (int i = 0; i <= N; i++) {
//            lists.add(new ArrayList<>());
//        }
//        int indegree[] = new int[N+1];
//        for (int i = 0; i < M; i++) {
//             int S = sc.nextInt();
//             int E = sc.nextInt();
//             lists.get(S).add(E);
//             indegree[E]++; // 진입차수 배열 데이터 저장 부분 0 1 1 0 0
//        }
//
//        // 위상정렬 실행
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 1; i <= N; i++) {
//            if (indegree[i] == 0) {
//                queue.offer(i); // 0 0 0 3 4
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int now = queue.poll(); // 3
//            System.out.print(now + " ");
//            for (int next : lists.get(now)) {
//                indegree[next]--;
//                if (indegree[next] == 0) {
//                    queue.offer(next);
//                }
//            }
//        }
//    }
//}
