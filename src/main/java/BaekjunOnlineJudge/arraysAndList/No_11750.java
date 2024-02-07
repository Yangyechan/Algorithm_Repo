package BaekjunOnlineJudge.arraysAndList;

import java.io.IOException;
import java.util.Scanner;

public class No_11750 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//
//        int sum = 0;
//
//        for (byte value : br.readLine().getBytes()) {
//            sum += value - '0';
//        }
//
//        System.out.println(sum);

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String num = sc.next();
        char[] list = num.toCharArray();

        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += list[i] - '0';
        }

        System.out.println(sum);
    }
}
