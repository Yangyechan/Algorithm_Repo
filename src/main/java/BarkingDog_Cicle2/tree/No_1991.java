package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_1991 {
    static List<List<Integer>> lists = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Character> score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = ".ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Map<Character, Integer> alphabet = new HashMap<>();
        score = new HashMap<>();
        for (int i = 0; i <= 26; i++) {
            alphabet.put(str.charAt(i), i);
            score.put(i, str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String ip = br.readLine();
            int key = alphabet.get(ip.charAt(0));
            int left = alphabet.get(ip.charAt(2));
            int right = alphabet.get(ip.charAt(4));

            lists.get(key).add(left);
            lists.get(key).add(right);
        }

        preOrder(1);
        sb.append("\n");
        inOrder(1);
        sb.append("\n");
        postOrder(1);
        sb.append("\n");

        System.out.println(sb);

    }
    static void preOrder(int x) {
        if (x == 0) return;

        sb.append(score.get(x));
        preOrder(lists.get(x).get(0));
        preOrder(lists.get(x).get(1));
    }

    static void inOrder(int x) {
        if (x == 0) return;

        inOrder(lists.get(x).get(0));
        sb.append(score.get(x));
        inOrder(lists.get(x).get(1));
    }

    static void postOrder(int x) {
        if (x == 0) return;

        postOrder(lists.get(x).get(0));
        postOrder(lists.get(x).get(1));
        sb.append(score.get(x));
    }
}
