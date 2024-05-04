package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MEMO implements Comparable<MEMO>{
    int idx;
    int depth;
    public MEMO(int idx, int depth){
        this.idx = idx;
        this.depth = depth;
    }
    public int compareTo(MEMO o){
        return o.depth - this.depth;     // 내림차순 정렬 depth
    }
}
public class No_15681 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int[] depth;
    static int[] count;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        visited = new boolean[N + 1];
        depth = new int[N + 1];
        BFS(R);

        List<MEMO> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(new MEMO(i, depth[i]));
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        count = new int[N + 1];
        for (int i = 0; i < list.size(); i++) {
            ans = 0;
            int num = list.get(i).idx;
            DFS(num);
            count[num] = ans;
        }

        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(count[num] + "\n");
        }

        System.out.println(sb);
    }
    static void BFS(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 1});
        visited[x] = true;
        depth[x] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int nxt : lists.get(now[0])) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    depth[nxt] = now[1] + 1;
                    queue.offer(new int[]{nxt, now[1] + 1});
                }
            }
        }
    }
    static void DFS(int x) {
        ans++;
        for (int nxt : lists.get(x)) {
            if (depth[x] < depth[nxt]) {
                if(count[nxt] != 0){
                    ans += count[nxt];
                    continue;
                }
                DFS(nxt);
            }
        }
    }
}
