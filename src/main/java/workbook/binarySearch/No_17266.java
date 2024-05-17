package workbook.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] stand = new int[N];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            stand[i] = Integer.parseInt(ip[i]);
        }


    }
}
