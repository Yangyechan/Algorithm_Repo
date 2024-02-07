package BaekjunOnlineJudge.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'A' && stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else if (str.charAt(j) == 'B' && stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else if (str.charAt(j) == 'A' && stack.peek() == 'A') {
                    stack.pop();
                } else if (str.charAt(j) == 'B' && stack.peek() == 'B') {
                    stack.pop();
                }else {
                    stack.push(str.charAt(j));
                }
            }
            if (stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
