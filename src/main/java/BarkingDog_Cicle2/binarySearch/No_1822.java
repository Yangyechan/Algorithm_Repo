package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int a = Integer.parseInt(ip[0]);
        int b = Integer.parseInt(ip[1]);
        List<Integer> list = new ArrayList<>();

        ip = br.readLine().split(" ");
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(ip[i]);
            list.add(num);
        }
        Collections.sort(list);

        ip = br.readLine().split(" ");
        for (int i = 0; i < b; i++) {
            int target = Integer.parseInt(ip[i]);
            int st = 0;
            int ed = list.size();
            boolean pos = false;

            while (st < ed) {
                int mid = (st + ed) / 2;

                if (target < list.get(mid)) {
                    ed = mid;
                } else if (target > list.get(mid)) {
                    st = mid + 1;
                }else {
                    pos = true;
                    break;
                }
            }

            if (pos) list.remove(target);
        }


        StringBuilder sb = new StringBuilder();
        sb.append(list.size());

        for (int i = 0; i < a; i++) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);
    }
}
