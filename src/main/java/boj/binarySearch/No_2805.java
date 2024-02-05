package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2805 {
    static int N, M;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        tree = new int[N];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(tree);

        long st = 0;
        long end = tree[N-1];
        while (st < end) {
            long mid = (st + end + 1) / 2;
            if (check(mid)) {
                st = mid;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(st);
    }
    static boolean check(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (tree[i] > mid) {
                long tmp = tree[i] - mid;
                sum += tmp;
            }
        }
        return sum >= M;
    }
}
