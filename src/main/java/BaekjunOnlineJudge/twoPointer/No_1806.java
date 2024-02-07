package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long s = Long.parseLong(input[1]);
        long[] arr = new long[n];
        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(num[i]);
        }

        int start = 0;
        int end = 0;
        long sum = 0;
        int length = Integer.MAX_VALUE;

        while (true) {
            if (sum >= s) {
                length = Math.min(length, end - start);
                sum -= arr[start++];
            } else if (end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(length);
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class No_1806 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        long s = Long.parseLong(input[1]);
//        long[] arr = new long[n];
//        String[] num = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = Long.parseLong(num[i]);
//        }
//        //Arrays.sort(arr);
//
//        int ed = 0;
//        long min = Long.MAX_VALUE;
//        long sum = arr[0];
//        for (int st = 0; st < n; st++) {
//            while (ed < n && sum < s) {
//                ed++;
//                if (ed != n) {
//                    sum += arr[ed];
//                }
//            }
//            if (ed == n) break;
//            if (min > ed - st + 1) {
//                min = ed - st + 1;
//            }
//            sum -= arr[st];
//        }
//        if (min == Long.MAX_VALUE) {
//            System.out.println(0);
//            return;
//        }
//        System.out.println(min);
//    }
//}
