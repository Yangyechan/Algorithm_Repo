package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();

        char[] fArr = new char[f.length()+1];
        char[] sArr = new char[s.length()+1];

        for (int i = 1; i <= f.length(); i++) {
            fArr[i] = f.charAt(i-1);
        }

        for (int i = 1; i <= s.length(); i++) {
            sArr[i] = s.charAt(i-1);
        }

        int[][] dp = new int[f.length() + 1][s.length() + 1];
        for (int i = 1; i <= f.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (fArr[i] == sArr[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[f.length()][s.length()]);
    }
}
