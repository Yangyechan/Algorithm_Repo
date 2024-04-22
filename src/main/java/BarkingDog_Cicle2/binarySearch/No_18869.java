package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int M = Integer.parseInt(ip[0]);
        int N = Integer.parseInt(ip[1]);
        int ans = 0;
        List<Long> list = new ArrayList<>();

        for (int t = 0; t < M; t++) {
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];

            ip = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(ip[i]);
                arr2[i] = Integer.parseInt(ip[i]);
            }
            Arrays.sort(arr1);

            long sum = 0;
            for (int i = 0; i < N; i++) {
                long tmp = (long) Math.pow(10, i);
                sum += lowerBound(arr1, arr2[i]) * tmp;
            }

            list.add(sum);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
    static long lowerBound(int[] arr1, int target) {
        int st = 0;
        int ed = arr1.length;

        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target <= arr1[mid]) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st+1;
    }
}
