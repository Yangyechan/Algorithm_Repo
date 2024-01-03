package boj.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;
    Edge (int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo (Edge o) {
        return weight - o.weight;
    }
}
public class No_1922 {
    static int[] parents;
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        edgeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            String[] strList = str.split(" ");
            int start = Integer.parseInt(strList[0]);
            int end = Integer.parseInt(strList[1]);
            int weight = Integer.parseInt(strList[2]);
            edgeList.add(new Edge(start, end, weight));
        }

        Collections.sort(edgeList);

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            Edge o = edgeList.get(i);
            if (find(o.start) != find(o.end)) {
                ans += o.weight;
                union(o.start, o.end);
            }
        }
        System.out.println(ans);
    }
    private static int find (int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union (int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }
}
//class Edge implements Comparable<Edge> {
//    int start;
//    int end;
//    int weight;
//
//    Edge(int start, int end, int weight) {
//        this.start = start;
//        this.end = end;
//        this.weight = weight;
//    }
//
//    @Override
//    public int compareTo(Edge o) {
//        return weight - o.weight;
//    }
//
//}
//
//public class No_1922 {
//    static int[] parent;
//    static ArrayList<Edge> edgeList;
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//
//        edgeList = new ArrayList<>();
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//
//            edgeList.add(new Edge(start, end, weight));
//        }
//
//        parent = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            parent[i] = i;
//        }
//
//        Collections.sort(edgeList);
//
//        int ans = 0;
//        for (int i = 0; i < edgeList.size(); i++) {
//            Edge edge = edgeList.get(i);
//
//            // 사이클이 발생하는 간선은 제외.
//            if (find(edge.start) != find(edge.end)) { // 3 4
//                ans += edge.weight;
//                union(edge.start, edge.end);
//            }
//        }
//
//        bw.write(ans + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static int find(int x) {
//        if (x == parent[x]) {
//            return x;
//        }
//
//        return parent[x] = find(parent[x]);
//    }
//    // parent = {0, 1, 1, 2, 1, 4, 1}
//    public static void union(int x, int y) {
//        x = find(x);
//        y = find(y);
//
//        if (x != y) {
//            parent[y] = x;
//        }
//    }
//
//}
