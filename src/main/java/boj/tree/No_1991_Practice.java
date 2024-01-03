package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1991_Practice {
    static class Node {
        int left;
        int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            int data = str[0].charAt(0) - 'A' + 1;
            int left = str[1].charAt(0) - 'A' + 1;
            int right = str[2].charAt(0) - 'A' + 1;
            list[data].add(new Node(left, right));
        }
        preOrder(1);
        sb.append("\n");
        inOrder(1);
        sb.append("\n");
        postOrder(1);
        System.out.println(sb.toString());
    }
    private static void preOrder(int d) {
        for (Node target : list[d]) {
            int left = target.left;
            int right = target.right;

            sb.append((char) (d + 'A' -1));
            if (left != -18) preOrder(left);
            if (right != -18) preOrder(right);
        }
    }

    private static void inOrder (int d) {
        for (Node target : list[d]) {
            int left = target.left;
            int right = target.right;

            if (left != -18) inOrder(left);
            sb.append((char)(d + 'A' -1));
            if (right != -18) inOrder(right);
        }
    }

    private static void postOrder (int d) {
        for (Node target : list[d]) {
            int left = target.left;
            int right = target.right;

            if (left != -18) postOrder(left);
            if (right != -18) postOrder(right);
            sb.append((char) (d + 'A' -1));
        }
    }
}
