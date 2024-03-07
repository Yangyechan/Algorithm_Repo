package BarkingDog_Cicle2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class No_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int cnt = 1;

        StringBuilder sb = new StringBuilder();
        while (idx < n) {
            if (stack.isEmpty()) {
                sb.append("+\n");
                stack.push(cnt);
                cnt++;
            }else {
                if (stack.peek() == arr[idx]) {
                    sb.append("-\n");
                    stack.pop();
                    idx++;
                }else {
                    sb.append("+\n");
                    stack.push(cnt);
                    cnt++;
                }

                if (cnt > n + 1) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb);
    }
}
