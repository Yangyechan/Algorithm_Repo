package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_22856 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static List<Integer> visit = new ArrayList<>();
    static List<Integer> inOrderList = new ArrayList<>();
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String[] ip = br.readLine().split(" ");

            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);

            lists.get(a).add(b);
            lists.get(a).add(c);
        }

        visited = new boolean[N+1];

        inOrder(1);
        similarInOrder(1);
        System.out.println(ans);
    }
    static void inOrder(int x) {
        if (x == -1) return;

        inOrder(lists.get(x).get(0));
        visit.add(x);
        inOrder(lists.get(x).get(1));
    }
    static void similarInOrder(int x) {
        inOrderList.add(x);


        if (lists.get(x).get(0) != -1) {
            similarInOrder(lists.get(x).get(0));
            inOrderList.add(x);
        }

        if (lists.get(x).get(1) != -1) {
            similarInOrder(lists.get(x).get(1));
            inOrderList.add(x);
        }

        if (x == visit.get(visit.size()-1)) {
            ans = inOrderList.size()-1;
        }
    }
}
