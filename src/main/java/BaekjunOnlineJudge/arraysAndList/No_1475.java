package BaekjunOnlineJudge.arraysAndList;

import java.util.*;

public class No_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] list = new int[10];
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (list[num] == 0) {
                if (num == 6) {
                    if (list[9] > 0) {
                        list[9]--;
                        continue;
                    }
                } else if (num == 9) {
                    if (list[6] > 0) {
                        list[6]--;
                        continue;
                    }
                }
                for (int j = 0; j < list.length; j++) {
                    if (j == num) continue;
                    list[j]++;
                }
                cnt++;
            }else {
                list[num]--;
            }
        }
        System.out.println(cnt);
    }
}
