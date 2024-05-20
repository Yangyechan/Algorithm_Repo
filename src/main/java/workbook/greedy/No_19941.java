package workbook.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int K = Integer.parseInt(ip[1]);

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        String str = br.readLine();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'H') {
                arr[i] = 1;
            }else {
                list.add(i);
            }
        }

        int ans1 = 0;
        for (int p = 0; p < list.size(); p++) {
            int person = list.get(p);

            for (int i = -K; i <= K; i++) {

                int tmp = person + i;

                if (tmp >= 0 && tmp < N) {
                    if (arr[tmp] == 1 && !visited[tmp]) {
                        visited[tmp] = true;
                        ans1++;
                        break;
                    }
                }
            }
        }

        int ans2 = 0;
        visited = new boolean[N];
        for (int p = list.size()-1; p >= 0; p--) {
            int person = list.get(p);

            for (int i = K; i >= -K; i--) {

                int tmp = person + i;

                if (tmp >= 0 && tmp < N) {
                    if (arr[tmp] == 1 && !visited[tmp]) {
                        visited[tmp] = true;
                        ans2++;
                        break;
                    }
                }
            }
        }

        int max = Math.max(ans1, ans2);

        System.out.println(max);
    }
}
