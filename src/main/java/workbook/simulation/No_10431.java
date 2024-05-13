package workbook.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for (int t = 0; t < P; t++) {
            String[] ip = br.readLine().split(" ");

            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(ip[1]));

            int ans = 0;
            for (int i = 2; i <= 20; i++) {
                boolean pos = false;
                int num = Integer.parseInt(ip[i]);
                for (int j = 0; j < list.size(); j++) {

                    if (num > list.get(j)) {
                        list.add(j, num);
                        ans += j;
                        pos = true;
                        break;
                    }
                }
                if (!pos) {
                    ans += list.size();
                    list.add(num);
                }
            }

            sb.append(ip[0] + " " + ans + "\n");
        }

        System.out.println(sb);
    }
}
