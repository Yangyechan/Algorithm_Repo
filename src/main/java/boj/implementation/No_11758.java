package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No_11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings1 = br.readLine().split(" ");
        String[] strings2 = br.readLine().split(" ");
        String[] strings3 = br.readLine().split(" ");

        int x1 = Integer.parseInt(strings1[0]);
        int y1 = Integer.parseInt(strings1[1]);
        int x2 = Integer.parseInt(strings2[0]);
        int y2 = Integer.parseInt(strings2[1]);
        int x3 = Integer.parseInt(strings3[0]);
        int y3 = Integer.parseInt(strings3[1]);

        // 신발끈
        int a = x1*y2 + x2*y3 + x3*y1;
        int b = x2*y1 + x3*y2 + x1*y3;
        if (a - b > 0) {
            System.out.println(1);
        } else if (a - b == 0) {
            System.out.println(0);
        }else {
            System.out.println(-1);
        }
    }
}
