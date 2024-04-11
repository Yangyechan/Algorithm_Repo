package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int mod = 1000000000;

        int[] arr = new int[1000001];
        int[] minus = new int[1000001];
        arr[1] = 1;
        minus[1] = 1;


        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                arr[i] = (arr[i-1] + arr[i-2]) % mod;
            }
        }else {
            for (int i = 2; i <= -n; i++) {
                minus[i] = ((-1 * minus[i-1]) + minus[i-2]) % mod;
            }
        }


        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append(0 + "\n");
            sb.append(0);
        } else if (n >= 1) {
            sb.append(1 + "\n");
            sb.append(arr[n]);
        }else {
            if (minus[-n] > 0) {
                sb.append(1 + "\n");
                //sb.append(minus[-n]);
            }else {
                sb.append(-1 + "\n");
                //sb.append(-minus[-n]);
            }

            sb.append(Math.abs(minus[-n]));
        }

        System.out.println(sb);
    }
}
