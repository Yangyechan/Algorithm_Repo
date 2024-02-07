package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] m = str.split("-");
        int total = 0;
        for (int i = 0; i < m.length; i++) {
            if (i == 0) {
                total += calculate(m[i]);
            }else {
                total -= calculate(m[i]);
            }
        }
        System.out.println(total);
    }
    private static int calculate (String str) {
        int sum = 0;
        String[] list = str.split("\\+");
        for (int i = 0; i < list.length; i++) {
            int unit = Integer.parseInt(list[i]);
            sum += unit;
        }
        return sum;
    }
}
