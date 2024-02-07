package BaekjunOnlineJudge.binarySearch;

import java.util.Scanner;

public class No_1654 {
    static int k, n;
    static long[] arr;

    static boolean solve(long x) {
        long cur = 0;
        for(int i = 0; i < k; i++) cur += arr[i] / x;
        return cur >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new long[k];
        for(int i = 0; i < k; i++) arr[i] = sc.nextLong();
        long st = 1;
        long en = (long) Math.pow(2, 31) - 1;
        while(st < en){
            long mid = (st+en+1)/2;
            if(solve(mid)) st = mid;
            else en = mid-1;
        }
        System.out.println(st);
    }
}

