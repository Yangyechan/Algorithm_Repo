package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class person implements Comparable<person> {
    int num, cnt;

    person(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(person o) {
        if (cnt == o.cnt) {
            return num - o.num;
        }
        return cnt - o.cnt;
    }
}
public class No_1389 {
    static List<List<Integer>> lists;
    static int[] check;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        PriorityQueue<person> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            check = new int[n + 1];
            visited = new boolean[n + 1];
            BFS(i);
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                cnt += check[j];
            }
            pq.offer(new person(i, cnt));
        }

        System.out.println(pq.peek().num);
    }
    static void BFS(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int cnt = now[1];

            for (int i = 0; i < lists.get(num).size(); i++) {
                if (lists.get(num).get(i) == x) continue;

                if (!visited[lists.get(num).get(i)]) {
                    visited[lists.get(num).get(i)] = true;
                    check[lists.get(num).get(i)] = cnt + 1;
                    queue.offer(new int[]{lists.get(num).get(i), cnt + 1});
                }else {
                    check[lists.get(num).get(i)]
                            = Math.min(check[lists.get(num).get(i)], cnt + 1);
                }
            }
        }
    }
}
