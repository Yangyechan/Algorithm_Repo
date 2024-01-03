package boj.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class No_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        Stack<Long> stack = new Stack<>();
        long first = Long.parseLong(br.readLine());
        stack.push(first);
        for (int i = 1; i < N; i++) {
            long next = Long.parseLong(br.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek() > next) {
                    stack.push(next);
                    cnt += (stack.size() - 1);
                    break;
                }else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                stack.push(next);
            }
        }
        System.out.println(cnt);
    }
}
