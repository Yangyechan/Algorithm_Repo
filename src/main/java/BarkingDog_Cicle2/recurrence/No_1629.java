package BarkingDog_Cicle2.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int a = Integer.parseInt(ip[0]);
        int b = Integer.parseInt(ip[1]);
        int c = Integer.parseInt(ip[2]);

        System.out.println(pow(a, b, c));
    }

    static long pow(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long val = pow(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) return val;
        return val * a % c;
    }
}
//    static long POW(long a, long b, long m) {
//        if (b == 1) return a % m;
//        long val = POW(a, b / 2, m);
//        val = val * val % m;
//        if (b % 2 == 0) return val;
//        return val * a % m;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long a = scanner.nextLong();
//        long b = scanner.nextLong();
//        long c = scanner.nextLong();
//        System.out.println(POW(a, b, c));
//    }
//}

