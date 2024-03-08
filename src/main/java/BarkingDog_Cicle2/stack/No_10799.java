package BarkingDog_Cicle2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (str.charAt(i-1) == '(' && str.charAt(i) == ')') {
                stack.pop();
                ans += stack.size();
            }else {
                stack.pop();
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}
