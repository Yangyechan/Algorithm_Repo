package BaekjunOnlineJudge.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9012 {
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());



        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push('(');
                }else if (str.charAt(j) == ')'){
                    if (stack.size() == 0) {
                        stack.push(')');
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.size() == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
