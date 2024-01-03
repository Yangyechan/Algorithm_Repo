package boj.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class No_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // () ((( () () ) ( () ) () ))( () )
        //  0      3  3 2    3 2  2 1 0  1 0
        // ((( () ( () () )) ( () ) () )) ( () () )
        //      3    4  4 3 2   3 2  2 1 0   1  1 0
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            }else if ((str.charAt(i) == ')')){
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    sum = sum + stack.size();
                }else {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
