package BarkingDog_Cicle2.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_9372 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] ip = br.readLine().split(" ");

            int N = Integer.parseInt(ip[0]);
            int M = Integer.parseInt(ip[1]);

            parent = new int[N+1];
            Arrays.fill(parent, -1);

            int ans = 0;
            for (int i = 0; i < M; i++) {
                ip = br.readLine().split(" ");

                int a = Integer.parseInt(ip[0]);
                int b = Integer.parseInt(ip[1]);

                if (!union(a, b)) continue;

                ans++;
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
    static int find(int x) {
        return parent[x] < 0 ? x : find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (a < b) parent[b] = a;
        else parent[a] = b;

        return true;
    }
}
