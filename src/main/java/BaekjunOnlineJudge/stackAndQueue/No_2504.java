package BaekjunOnlineJudge.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int num = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add('(');
                num *= 2;
            } else if (str.charAt(i) == '[') {
                stack.add('[');
                num *= 3;
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == '(') sum += num;
                stack.pop();
                num /= 2;
            } else if (str.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i - 1) == '[') sum += num;
                stack.pop();
                num /= 3;
            }
        }
        if(stack.isEmpty()) System.out.println(sum);
        else System.out.println(0);
    }
}
