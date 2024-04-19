package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_2295 {
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = arr[i] + arr[j];
                list.add(num);
            }
        }
        Collections.sort(list);

        int max = 0;
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int num = arr[i] - arr[j];
                if (binarySearch(num) && arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        System.out.println(max);
    }
    static boolean binarySearch(int target) {
        int st = 0;
        int ed = list.size();

        while (st < ed) {
            int mid = (st + ed) / 2;

            if (target < list.get(mid)) {
                ed = mid;
            } else if (target > list.get(mid)) {
                st = mid + 1;
            }else {
                return true;
            }
        }

        return false;
    }
}
