package BarkingDog_Cicle3.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        String ip = br.readLine();

        for (int i = 0; i < ip.length(); i++) {
            int tar = ip.charAt(i) - '0';

            if (tar == 6) {
                if (arr[6] > arr[9]) {
                    arr[9]++;
                    continue;
                }
                arr[6]++;
            } else if (tar == 9) {
                if (arr[9] > arr[6]) {
                    arr[6]++;
                    continue;
                }
                arr[9]++;
            }else {
                arr[tar]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] > max) max = arr[i];
        }

        System.out.println(max);
    }
}
