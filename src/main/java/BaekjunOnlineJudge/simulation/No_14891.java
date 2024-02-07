package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_14891 {
    static List<List<Integer>> gear;
    static int[] dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            gear.add(new ArrayList<>());
        }
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                int n = str.charAt(j) - '0';
                gear.get(i).add(n);
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] str2 = br.readLine().split(" ");
            int num = Integer.parseInt(str2[0]);
            int d = Integer.parseInt(str2[1]);
            dir = new int[4];
            dir[num - 1] = d;
            dirCheck(num-1);
            rotate();
        }
        int sum = 0;
        if (gear.get(0).get(0) == 1) sum += 1;
        if (gear.get(1).get(0) == 1) sum += 2;
        if (gear.get(2).get(0) == 1) sum += 4;
        if (gear.get(3).get(0) == 1) sum += 8;
        System.out.println(sum);
    }
    static void dirCheck(int num) {
        for (int i = num; i < 3; i++) {
            if (gear.get(i).get(2) != gear.get(i+1).get(6)) {
                dir[i+1] = -dir[i];
            }else {
                break;
            }
        }
        for (int i = num; i > 0; i--) {
            if (gear.get(i).get(6) != gear.get(i-1).get(2)) {
                dir[i-1] = -dir[i];
            }else {
                break;
            }
        }
    }
    static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == -1) {
                int tmp = gear.get(i).get(0);
                gear.get(i).remove(0);
                gear.get(i).add(tmp);
            } else if (dir[i] == 1) {
                int tmp = gear.get(i).get(7);
                gear.get(i).remove(7);
                gear.get(i).add(0, tmp);
            }
        }
    }
}
