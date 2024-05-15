package workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] s = new int[N+1];

        String[] ip = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            s[i] = Integer.parseInt(ip[i-1]);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ip = br.readLine().split(" ");

            int mf = Integer.parseInt(ip[0]);
            int num = Integer.parseInt(ip[1]);

            if (mf == 1) {
                for (int j = num; j <= N; j+=num) {
                    int tmp = (s[j] + 1) % 2;
                    s[j] = tmp;
                }
            }else {
                s[num] = (s[num] + 1) % 2;
                int l = num - 1;
                int r = num + 1;
                while (l > 0 && r <= N) {
                    if (s[l] == s[r]) {
                        s[l] = (s[l] + 1) % 2;
                        s[r++] = s[l--];
                    }else break;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            System.out.print(s[i] + " ");
            cnt++;
            if (cnt % 20 == 0) System.out.println();
        }
    }
}
