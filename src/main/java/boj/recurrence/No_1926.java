package boj.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class No_1926 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        System.out.println(pow(a, b, c));
        scanner.close();
    }

    public static long pow(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = pow(a, b / 2, c);
        val = (val * val) % c;
        if (b % 2 == 0) return val;
        return (val * a) % c;
    }
}

