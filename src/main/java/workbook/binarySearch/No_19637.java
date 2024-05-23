package workbook.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_19637 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        Map<Integer, String> map = new HashMap<>();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");

            int n = Integer.parseInt(ip[1]);
            map.put(i, ip[0]);
            arr[i] = n;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());

            int x = lowerBound(n);

            sb.append(map.get(x) + "\n");
        }

        System.out.println(sb);
    }
    static int lowerBound(int target) {
        int st = 0;
        int ed = N;

        while (st < ed) {
            int mid = (st + ed) / 2;

            int midVal = arr[mid];

            if (target <= midVal) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st;
    }
}
