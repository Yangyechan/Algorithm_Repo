package BarkingDog_Cicle2.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_6603 {
    static int k;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] lot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] ip = br.readLine().split(" ");

            if (ip[0].equals("0")) break;

            k = Integer.parseInt(ip[0]);
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(ip[i+1]);
            }

            visited = new boolean[k];
            lot = new int[6];
            backTracking(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void backTracking(int depth, int st) {
        if (depth == 6) {
            for (int nxt : lot) {
                sb.append(nxt + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = st; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lot[depth] = arr[i];
                backTracking(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
