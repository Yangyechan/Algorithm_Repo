package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
    int x;
    int y;
    Edge (int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo (Edge o) {
        if (y == o.y) {
            return x - o.x;
        }
        return y - o.y;
    }
}

public class No_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            list.add(new Edge(x, y));
        }
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).x + " " + list.get(i).y);
        }
    }
}
