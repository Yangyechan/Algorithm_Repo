package BarkingDog_Cicle2.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1182 {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int sum = 0;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        S = Integer.parseInt(ip[1]);

        arr = new int[N];
        ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        visited = new boolean[N];

        backTracking(0);
        System.out.println(ans);
    }
    static void backTracking(int idx) {
        if (idx == N) {
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += arr[i];
                check();
                backTracking(i+1);
                visited[i] = false;
                sum -= arr[i];
            }
        }
    }

    static void check() {
        if (sum == S) ans++;
    }
}
