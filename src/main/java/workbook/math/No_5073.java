package workbook.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {

            String[] ip = br.readLine().split(" ");

            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);

            if (ip[0].equals("0") && ip[1].equals("0") && ip[2].equals("0")) break;

            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(ip[i]);
            }
            Arrays.sort(arr);

            if (arr[2] >= arr[0] + arr[1]) {
                sb.append("Invalid\n");
                continue;
            }

            if (a == b && b == c) {
                sb.append("Equilateral\n");
            } else if (a == b || b == c || c == a) {
                sb.append("Isosceles\n");
            }else {
                sb.append("Scalene\n");
            }
        }

        System.out.println(sb);

    }
}
