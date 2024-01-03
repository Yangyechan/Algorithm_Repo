package boj.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class No_10866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            if (str[0].equals("push_front")) {
                deque.offerFirst(Integer.parseInt(str[1]));
            } else if (str[0].equals("push_back")) {
                deque.offerLast(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(deque.pollFirst());
            } else if (str[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(deque.pollLast());
            } else if (str[0].equals("size")) {
                System.out.println(deque.size());
            } else if (str[0].equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            } else if (str[0].equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(deque.peekFirst());
                }
            }else {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
