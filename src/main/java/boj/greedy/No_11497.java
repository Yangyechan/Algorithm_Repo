package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] nList = new int[N];
            String[] nStr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                nList[j] = Integer.parseInt(nStr[j]);
            }
            Arrays.sort(nList);
            // 10 10 11 11 12 12 13 14 // 10 11 12 13 14 12 11 10
            System.out.println(calculate(nList));
        }
    }
    public static int calculate (int[] nList) {
        int start = 0;
        int end = nList.length-1;
        int[] nList2 = new int[nList.length];
        for (int i = 0; i < nList.length; i+=2) {
            nList2[start] = nList[i];
            start++;
        }
        for (int i = 1; i < nList.length; i+=2) {
            nList2[end] = nList[i];
            end--;
        }
        int max = 0;
        for (int i = nList2.length-1; i > 0; i--) {
            if (Math.abs(nList2[i] - nList2[i-1]) > max) {
                max = Math.abs(nList2[i] - nList2[i-1]);
            }
        }
        return max;
    }
}
