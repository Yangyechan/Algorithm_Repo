package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] arr = new int[X+1];

        if (X == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }


        int[] pre = new int[X+1];
        pre[2] = 1;

        for (int i = 2; i <= X; i++) {
            arr[i] = arr[i-1] + 1;
            pre[i] = i-1;

            if (i % 3 == 0 && arr[i] > arr[i/3] + 1) {
                arr[i] = arr[i/3] + 1;

                pre[i] = i/3;
            }
            if (i % 2 == 0 && arr[i] > arr[i/2] + 1) {
                arr[i] = arr[i/2] + 1;

                pre[i] = i/2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[X] + "\n");

        while (X != 1) {
            sb.append(X + " ");
            X = pre[X];
        }
        sb.append(1);

        System.out.println(sb);
    }
}
