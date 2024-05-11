package workbook.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int tmp = 1;
        int room = 1;
        while (tmp < N) {
            tmp += 6 * room;
            room++;
        }

        System.out.println(room);
    }
}
