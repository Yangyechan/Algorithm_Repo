package workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] stand = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            stand[i] = Integer.parseInt(ip[i]);
        }

        int height = 1;
        while (true) {
            int l = stand[0] - height;
            int r = stand[0] + height;

            if (l > 0) {
                height++;
                continue;
            }

            if (r >= N) break;

            for (int i = 1; i < M; i++) {
                int x = stand[i] - height;
                int y = stand[i] + height;

                if (x <= r) {
                    r = y;

                    if (r >= N) break;
                }else break;
            }

            if (r >= N) break;
            height++;
        }

        System.out.println(height);
    }
}
