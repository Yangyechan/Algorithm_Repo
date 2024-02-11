package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[100001];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int st = 0;
        int ed = 1;
        visited[arr[0]] = true;
        long ans = 1;
        while (ed < n) {
            if (!visited[arr[ed]]) {
                visited[arr[ed]] = true;
                ans += (ed - st + 1);
                ed++;
            }else {
                visited[arr[st++]] = false;
            }
        }
        System.out.println(ans);
    }
}
