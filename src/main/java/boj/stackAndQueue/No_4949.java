package boj.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
                    stack.push('[');
                } else if (str.charAt(i) == ']' && !stack.isEmpty()) {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                } else if (str.charAt(i) == '(') {
                    stack.push('(');
                } else if (str.charAt(i) == ')' && !stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (str.charAt(i) == '.') {
                    if (stack.isEmpty()) {
                        //sb.append("yes\n");
                        System.out.println("yes");
                    }else {
                        //sb.append("no\n");
                        System.out.println("no");
                    }
                }
            }
            if (!stack.isEmpty() && str.charAt(str.length() - 1) != '.') {
                System.out.println("no");
            }
        }
        //System.out.println(sb);
    }
}
