package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_14267 {
    static List<List<Integer>> lists = new ArrayList<>();
    static int[] parent;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        parent = new int[n+1];
        count = new int[n+1];

        ip = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(ip[i]);

            if (num == -1) continue;

            lists.get(num).add(i+1);
            parent[i+1] = num;
        }

        for (int i = 0; i < m; i++) {
            ip = br.readLine().split(" ");
            int num = Integer.parseInt(ip[0]);
            int w = Integer.parseInt(ip[1]);

            count[num] += w;
        }

        DFS(1);

        for (int i = 1; i <= n; i++) {
            System.out.print(count[i] + " ");
        }
    }
    static void DFS(int x) {
        if (parent[x] != -1) {
            count[x] += count[parent[x]];
        }

        for (int nxt : lists.get(x)) {
            DFS(nxt);
        }
    }
}
