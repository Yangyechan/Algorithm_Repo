package workbook.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] ip = br.readLine().split(" ");
//        int[] dis = new int[N-1];
//        for (int i = 0; i < N-1; i++) {
//            dis[i] = Integer.parseInt(ip[i]);
//        }

//        int[] city = new int[N];
        String ip2[] = br.readLine().split(" ");
//        for (int i = 0; i < N; i++) {
//            city[i] = Integer.parseInt(ip2[i]);
//        }

        long ans = 0;
        long now = Long.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            int dis = Integer.parseInt(ip[i]);
            int city = Integer.parseInt(ip2[i]);

            if (now > city) now = city;

            ans += now * dis;
        }

        System.out.println(ans);
    }
}
