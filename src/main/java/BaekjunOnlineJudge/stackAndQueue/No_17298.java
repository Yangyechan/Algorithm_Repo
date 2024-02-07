package BaekjunOnlineJudge.stackAndQueue;

import java.io.*;
import java.util.Stack;

public class No_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] a = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            }else {
                ans[i] = stack.peek();
            }
            stack.push(a[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
