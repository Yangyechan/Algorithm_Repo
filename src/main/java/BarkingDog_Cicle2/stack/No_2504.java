package BarkingDog_Cicle2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(0) == ']' || str.charAt(0) == ')') {
            System.out.println(0);
            return;
        }

        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty() && (c == ')' || c == ']')) {
                System.out.println(0);
                return;
            }
            if (c == '(') {
                stack.push('(');
                tmp *= 2;
            } else if (c == '[') {
                stack.push('[');
                tmp *= 3;
            } else if (c == ')') {
                if (stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i-1) == '[') {
                    System.out.println(0);
                    return;
                } else if (str.charAt(i-1) == '(') {
                    stack.pop();
                    ans += tmp;
                    tmp /= 2;
                }else {
                    stack.pop();
                    tmp /= 2;
                }
            }else {
                if (stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i-1) == '(') {
                    System.out.println(0);
                    return;
                } else if (str.charAt(i-1) == '[') {
                    stack.pop();
                    ans += tmp;
                    tmp /= 3;
                }else {
                    stack.pop();
                    tmp /= 3;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(ans);
    }
}
