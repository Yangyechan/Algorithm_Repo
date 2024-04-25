package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2143 {
    static List<Long> bList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(ip[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        ip = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(ip[i]);
        }

        List<Long> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long tmp = 0;
            for (int j = i; j < n; j++) {
                tmp += A[j];
                aList.add(tmp);
            }
        }

        bList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long tmp = 0;
            for (int j = i; j < m; j++) {
                tmp += B[j];
                bList.add(tmp);
            }
        }

        Collections.sort(bList);

        long ans = 0;
        for (int i = 0; i < aList.size(); i++) {
            long target = T - aList.get(i);
            int st = lowerBound(target);
            int ed = upperBound(target);
            ans += ed - st;
        }

        System.out.println(ans);
    }
    static int lowerBound(long target) {
        int st = 0;
        int ed = bList.size();

        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target <= bList.get(mid)) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st;
    }

    static int upperBound(long target) {
        int st = 0;
        int ed = bList.size();

        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target < bList.get(mid)) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st;
    }
}
