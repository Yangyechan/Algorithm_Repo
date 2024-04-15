package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < minus.length; i++) {
            String[] tmp = minus[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < tmp.length; j++) {
                int x = Integer.parseInt(tmp[j]);
                sum += x;
            }
            list.add(sum);
        }

        int ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ans -= list.get(i);
        }

        System.out.println(ans);
    }
}
