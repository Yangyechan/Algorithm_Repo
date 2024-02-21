package BaekjunOnlineJudge.tree;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class No_20955 {
//    static List<List<Integer>> lists = new ArrayList<>();
//    static boolean[] visited;
//    static int nodeCnt;
//    static int lineCnt;
//    static int ans;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int M = Integer.parseInt(input[1]);
//
//        for (int i = 0; i <= N; i++) {
//            lists.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < M; i++) {
//            String[] split = br.readLine().split(" ");
//            int u = Integer.parseInt(split[0]);
//            int v = Integer.parseInt(split[1]);
//            lists.get(u).add(v);
//            lists.get(v).add(u);
//        }
//
//        visited = new boolean[N + 1];
//        ans = -1;
//        for (int i = 1; i <= N; i++) {
//            if (!visited[i]) {
//                ans++;
//                nodeCnt = 0;
//                lineCnt = 0;
//                BFS(i);
//                func();
//            }
//        }
//        System.out.println(ans);
//    }
//    static void BFS(int x) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(x);
//
//        while (!queue.isEmpty()) {
//            int now = queue.poll();
//            nodeCnt++;
//            for (int nxt : lists.get(now)) {
//                if (!visited[nxt]) {
//                    lineCnt++;
//                    visited[nxt] = true;
//                    queue.offer(nxt);
//                }
//            }
//        }
//    }
//    static void func() {
//        if (nodeCnt >= lineCnt) {
//            ans += lineCnt - (nodeCnt - 1);
//        }
//    }
//}


import java.util.Arrays;
import java.util.Scanner;

public class No_20955 {
    static final int MX = 100_000;

    static int n, m;
    static int cnt;
    static int[] p;

    static int find(int x) {
        if (p[x] < 0)
            return x;
        return p[x] = find(p[x]);
    }

    static void tryMerge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            cnt++;
            return;
        }
        if (p[u] > p[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        p[u] += p[v];
        p[v] = u;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        p = new int[n + 2];
        Arrays.fill(p, -1);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tryMerge(u, v);
        }

        System.out.println(n - m - 1 + 2 * cnt);

        sc.close();
    }
}

/*
유니온 파인드를 활용한 별해입니다.

간선을 입력 받으면서 merge를 시도합니다.
두 정점의 부모가 동일하지 않다면 merge를 수행합니다.
두 정점의 부모가 동일한 경우
해당 간선은 불필요한 간선이므로
자르는 연산 횟수인 cnt를 증가시킵니다.

이 연산을 완료한 뒤에 남은 간선 수는 총 (m - cnt)개가 됩니다.
여기서 간선을 연결해 (n - 1)개의 간선을 확보해야 트리가 구성됩니다.
따라서 연결해야 하는 간선 수는 (n - 1) - (m - cnt)개가 됩니다.

그러므로 간선을 잇고 자르는 총 연산 수는
(n - 1) - (m - cnt) + cnt = n - m - 1 + 2*cnt이며,
이를 답으로 출력합니다.
*/
