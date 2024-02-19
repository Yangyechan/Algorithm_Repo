package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1043 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        String[] input2 = br.readLine().split(" ");
        int n = Integer.parseInt(input2[0]);
        for (int i = 1; i <= n; i++) {
            set.add(Integer.parseInt(input2[i]));
        }

        String[] copy = new String[M];
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            copy[i] = tmp;
            String[] input3 = tmp.split(" ");
            int v = Integer.parseInt(input3[0]);

            for (int j = 1; j <= v; j++) {
                int a = Integer.parseInt(input3[j]);
                for (int k = 1; k <= v; k++) {
                    int b = Integer.parseInt(input3[k]);
                    lists.get(a).add(b);
                    lists.get(b).add(a);
                }
            }
        }

        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        if (!set.isEmpty()) {
            for (int t : set) {
                queue.offer(t);
                visited[t] = true;
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < lists.get(now).size(); i++) {
                if (!visited[lists.get(now).get(i)]) {
                    visited[lists.get(now).get(i)] = true;
                    queue.offer(lists.get(now).get(i));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < copy.length; i++) {
            String[] tmp = copy[i].split(" ");
            int nxt = Integer.parseInt(tmp[0]);
            boolean pos = false;
            for (int j = 1; j <= nxt; j++) {
                int target = Integer.parseInt(tmp[j]);

                if (!visited[target]) {
                    pos = true;
                    break;
                }
            }
            if (pos) ans++;
        }
        System.out.println(ans);
    }
}


/*
5 4
1 5
2 1 2
2 2 3
2 3 4
2 4 5

0
 */