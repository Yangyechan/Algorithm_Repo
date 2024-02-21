package BaekjunOnlineJudge.tree;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Node implements Comparable<Node> {
    int nd, wid;

    Node(int nd, int wid) {
        this.nd = nd;
        this.wid = wid;
    }

    @Override
    public int compareTo(Node o) {
        return wid - o.wid;
    }
}
public class No_2250 {
    static List<List<Integer>> lists = new ArrayList<>();
    static TreeSet<Node>[] ts;
    static int cnt = 1;
    static int maxLev, maxWid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        ts = new TreeSet[10001];
        for (int i = 0; i <= 10000; i++) {
            ts[i] = new TreeSet<>();
        }

        int[] parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);
            if (left != -1) parent[left] = n;
            if (right != -1) parent[right] = n;
            lists.get(n).add(left);
            lists.get(n).add(right);
        }

        int root = 0;
        for(int i = 1; i <= N; i++) {
            if(parent[i] == 0) {
                root = i;
                break;
            }
        }

        DFS(root , 1);
        for (int i = 1; i <= 10000; i++) {
            int tmp = ts[i].last().wid - ts[i].first().wid + 1;
            if (tmp == maxWid) {
                maxLev = i;
                break;
            }
        }
        System.out.println(maxLev + " " + maxWid);
    }
    static void DFS(int x, int level) {
        int left = lists.get(x).get(0);
        int right = lists.get(x).get(1);

        if (left != -1) {
            DFS(left, level + 1);
        }

        ts[level].add(new Node(x, cnt));
        cnt++;
        if (ts[level].last().wid - ts[level].first().wid + 1 > maxWid) {
            maxWid = ts[level].last().wid - ts[level].first().wid + 1;
        }

        if (right != -1) {
            DFS(right, level + 1);
        }
    }
}
