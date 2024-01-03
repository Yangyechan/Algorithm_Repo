package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class No_1759 {
    static int L, C;
    static char[] ch;
    static char[] arr;
    static boolean[] visited;
    static int[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        sb = new StringBuilder();
        ch = new char[C];
        arr = new char[L];
        visited = new boolean[C];
        check = new int[2];
        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            ch[i] = str2[i].charAt(0);
        }
        Arrays.sort(ch);
        func(0, 0);
        System.out.println(sb);
    }
    static void func(int depth, int s) {
        if (depth == L) {
            if (check[0] >= 1 && check[1] >= 2) {
                for (char t : arr) {
                    sb.append(t);
                }
                sb.append("\n");
                return;
            }
            return;
        }
        for (int i = s; i < C; i++) {
            if (!visited[i]) {
                if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i'
                        || ch[i] == 'o' || ch[i] == 'u') {
                    visited[i] = true;
                    arr[depth] = ch[i];
                    check[0]++;
                    func(depth + 1, i + 1);
                    visited[i] = false;
                    check[0]--;
                }else {
                    visited[i] = true;
                    arr[depth] = ch[i];
                    check[1]++;
                    func(depth + 1, i + 1);
                    visited[i] = false;
                    check[1]--;
                }
            }
        }
    }
}
