package BaekjunOnlineJudge.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class No_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        StringBuilder sb = new StringBuilder();
        sb.append("+" + "\n");
        int idx = 0;
        int cnt = 2;
        while (idx < n) {
            if (stack.isEmpty()) {
                sb.append("+" + "\n");
                stack.push(cnt);
                cnt++;
            }else {
                if (stack.peek() == list[idx]) {
                    sb.append("-" + "\n");
                    stack.pop();
                    idx++;
                }else {
                    sb.append("+" + "\n");
                    stack.push(cnt);
                    cnt++;
                }
                if (cnt > list.length + 1) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

