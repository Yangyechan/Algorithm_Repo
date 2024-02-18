package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class candidate implements Comparable<candidate> {
    int num, score;

    candidate(int num, int score) {
        this.num = num;
        this.score = score;
    }

    @Override
    public int compareTo(candidate o) {
        if (score == o.score) {
            return num - o.num;
        }
        return score - o.score;
    }
}
public class No_2660 {
    static int n;
    static List<List<Integer>> lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (a == -1 && b == -1) break;

            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        PriorityQueue<candidate> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int cnt = BFS(i);
            if (pos()) {
                pq.offer(new candidate(i, cnt));
            }
        }

        List<Integer> cList = new ArrayList<>();
        int minScore = pq.peek().score;
        while (!pq.isEmpty()) {
            candidate tmp = pq.poll();
            if (tmp.score == minScore) {
                cList.add(tmp.num);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore + " " + cList.size() + "\n");
        for (int i = 0; i < cList.size(); i++) {
            sb.append(cList.get(i) + " ");
        }
        System.out.println(sb);
    }
    static int BFS(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        visited[x] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < lists.get(now[0]).size(); i++) {
                if (!visited[lists.get(now[0]).get(i)]) {
                    visited[lists.get(now[0]).get(i)] = true;
                    cnt = Math.max(cnt, now[1] + 1);
                    queue.offer(new int[]{lists.get(now[0]).get(i), now[1] + 1});
                }
            }
        }
        return cnt;
    }

    static boolean pos() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
