package BarkingDog_Cicle2.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1074 {
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int r = Integer.parseInt(ip[1]);
        int c = Integer.parseInt(ip[2]);
        int size = (int) Math.pow(2, N);

        rec(size, r, c);
        System.out.println(ans);
    }
    static void rec(int size, int r, int c) {
        if (size == 1) return;

        if (r < size/2 && c < size/2) {
            rec(size/2, r, c);
        } else if (r < size/2 && c >= size/2) {
            ans += (size * size / 4);
            rec(size/2, r, c - size/2);
        } else if (r >= size/2 && c < size/2) {
            ans += (size * size / 4) * 2;
            rec(size/2, r - size/2, c);
        }else {
            ans += (size * size / 4) * 3;
            rec(size/2, r - size/2, c - size/2);
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class No_1074 {
//    static int cnt;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        int n = Integer.parseInt(str[0]);
//        int r = Integer.parseInt(str[1]);
//        int c = Integer.parseInt(str[2]);
//        int size = (int) Math.pow(2, n);
//        func(size, r, c);
//        System.out.println(cnt);
//    }
//    static void func(int size, int r, int c) {
//        if (size == 1) {
//            return;
//        }
//        if (r < size / 2 && c < size / 2) {
//            func(size / 2, r, c);
//        } else if (r < size / 2 && c >= size / 2) {
//            cnt += size * size / 4;
//            func(size / 2, r, c - size/2);
//        } else if (r >= size/2 && c < size/2) {
//            cnt += (size*size/4) * 2;
//            func(size/2, r - size/2, c);
//        }else {
//            cnt += (size*size/4) * 3;
//            func(size/2, r - size/2, c - size/2);
//        }
//    }
//}