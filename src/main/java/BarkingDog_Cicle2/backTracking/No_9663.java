package BarkingDog_Cicle2.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class No_9663 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];

        bt(0);
        System.out.println(ans);
    }
    static void bt(int cnt) {
        if (cnt == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[cnt] = i;
            if (pos(cnt)) {
                bt(cnt+1);
            }
        }
    }

    static boolean pos(int x) {
        for (int i = 0; i < x; i++) {
            if (Math.abs(x - i) == Math.abs(arr[x] - arr[i])) return false;
            else if (arr[x] == arr[i]) return false;
        }
        return true;
    }

}
