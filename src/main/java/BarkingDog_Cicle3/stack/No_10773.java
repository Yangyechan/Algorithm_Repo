package BarkingDog_Cicle3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (stack.isEmpty()) continue;
                stack.pop();
            }else stack.push(x);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
