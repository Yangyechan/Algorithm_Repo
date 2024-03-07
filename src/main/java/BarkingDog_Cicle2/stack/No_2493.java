package BarkingDog_Cicle2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 100000001});

        StringBuilder sb = new StringBuilder();
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(ip[i]);

            while (stack.peek()[1] < num) {
                stack.pop();
            }

            sb.append(stack.peek()[0] + " ");
            stack.push(new int[]{i+1, num});
        }

        System.out.println(sb);
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        Stack<int[]> stack = new Stack<>();
//        stack.push(new int[]{0, 100000001});
//        String[] str = br.readLine().split(" ");
//
//        for (int i = 1; i <= n; i++) {
//            int num = Integer.parseInt(str[i - 1]);
//            while (stack.peek()[1] < num) {
//                stack.pop();
//            }
//            System.out.print(stack.peek()[0] + " ");
//            stack.push(new int[]{i, num});
//        }
//
//    }
//}