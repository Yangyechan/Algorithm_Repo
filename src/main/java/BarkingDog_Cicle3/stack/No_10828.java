package BarkingDog_Cicle3.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String ip = br.readLine();

            String[] split = ip.split(" ");

            if (split[0].equals("push")) {
                int x = Integer.parseInt(split[1]);
                stack.push(x);
            } else if (split[0].equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                }else {
                    int x = stack.pop();
                    sb.append(x + "\n");
                }
            } else if (split[0].equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (split[0].equals("empty")) {
                if (stack.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }else {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.peek() + "\n");
            }
        }

        System.out.println(sb);
    }
}
