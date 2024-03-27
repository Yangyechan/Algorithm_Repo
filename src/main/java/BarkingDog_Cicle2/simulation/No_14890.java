package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14890 {
    static int N, L;
    static int[][] loads;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        L = Integer.parseInt(ip[1]);

        loads = new int[N][N];
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                loads[i][j] = Integer.parseInt(ip[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];

            for (int j = 0; j < N; j++) {
                arr1[j] = loads[i][j];
                arr2[j] = loads[j][i];
            }

            if (check(arr1)) ans++;
            if (check(arr2)) ans++;
        }

        System.out.println(ans);

    }
    static boolean check(int[] arr) {
        int idx = 0;
        int cnt = 1;

        while (idx < N - 1) {
            if (Math.abs(arr[idx+1] - arr[idx]) > 1) return false;

            if (arr[idx] == arr[idx+1]) {
                idx++;
                cnt++;
            } else if (arr[idx] < arr[idx+1]) {
                if (cnt < L) return false;

                cnt = 1;
                idx++;
            }else {
                if (idx + L >= N) return false;
                for (int i = idx+1; i < idx + L; i++) {
                    if (arr[i] != arr[i+1]) return false;
                }

                idx += L;
                cnt = 0;
            }
        }


        return true;
    }
}
