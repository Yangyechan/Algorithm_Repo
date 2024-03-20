package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_14891 {
    static List<List<Integer>> lists = new ArrayList<>();
    static int[] rot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            String ip = br.readLine();
            for (int j = 0; j < 8; j++) {
                int n = ip.charAt(j) - '0';
                lists.get(i).add(n);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] ip = br.readLine().split(" ");
            int num = Integer.parseInt(ip[0]);
            int dir = Integer.parseInt(ip[1]);

            rot = new int[4];
            rot[num-1] = dir;
            dirConfig(num-1);
            rotate();
        }

        int ans = 0;
        if (lists.get(0).get(0) == 1) ans += 1;
        if (lists.get(1).get(0) == 1) ans += 2;
        if (lists.get(2).get(0) == 1) ans += 4;
        if (lists.get(3).get(0) == 1) ans += 8;

        System.out.println(ans);
    }
    static void dirConfig(int num) {
        for (int i = num; i > 0 ; i--) {
            if (lists.get(i-1).get(2) != lists.get(i).get(6)) {
                rot[i-1] = -rot[i];
            }else break;
        }

        for (int i = num; i < 3; i++) {
            if (lists.get(i).get(2) != lists.get(i+1).get(6)) {
                rot[i+1] = -rot[i];
            }else break;
        }
    }

    static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (rot[i] == 1) {
                int tmp = lists.get(i).get(7);
                lists.get(i).remove(7);
                lists.get(i).add(0, tmp);
            } else if (rot[i] == -1) {
                int tmp = lists.get(i).get(0);
                lists.get(i).remove(0);
                lists.get(i).add(tmp);
            }
        }
    }
}
