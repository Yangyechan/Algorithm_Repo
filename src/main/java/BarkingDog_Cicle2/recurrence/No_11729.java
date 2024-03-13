package BarkingDog_Cicle2.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    static void hanoi (int N, int st, int mid, int ed) {
        if (N == 1) {
            sb.append(st + " " + ed + "\n");
            cnt++;
            return;
        }

        hanoi(N-1, st, ed, mid);
        sb.append(st + " " + ed + "\n");
        cnt++;
        hanoi(N-1, mid, st, ed);
    }
}

//import java.util.*;
//
//public class No_11729 {
//    public static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
//
//        hanoi(N, 1, 2, 3);
//        System.out.println(sb);
//
//    }
//    static void hanoi(int N, int start, int mid, int to) {
//        if (N == 1) {
//            sb.append(start + " " + to + "\n");
//            return;
//        }
//        hanoi(N - 1, start, to, mid);
//        sb.append(start + " " + to + "\n");
//        hanoi(N - 1, mid, start, to);
//    }
//}