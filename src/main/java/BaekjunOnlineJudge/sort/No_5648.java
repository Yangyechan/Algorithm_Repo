package BaekjunOnlineJudge.sort;

import java.util.Arrays;
import java.util.Scanner;

public class No_5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();
            arr[i] = Long.parseLong(sb.toString());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
