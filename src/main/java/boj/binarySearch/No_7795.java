package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] listA = new int[N];
            List<Integer> listB = new ArrayList<>();

            String[] inputA = br.readLine().split(" ");
            String[] inputB = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                listA[i] = Integer.parseInt(inputA[i]);
            }

            for (int i = 0; i < M; i++) {
                listB.add(Integer.parseInt(inputB[i]));
            }
            Collections.sort(listB);

            int ans = 0;
            for (int i = 0; i < N; i++) {
                ans += lowerBound(listB, listA[i]);
            }
            System.out.println(ans);
        }
    }
    static int lowerBound(List<Integer> arr, int target) {
        int st = 0;
        int ed = arr.size();
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target <= arr.get(mid)) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }
        return st;
    }
}
