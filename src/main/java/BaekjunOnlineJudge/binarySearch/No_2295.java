package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                list.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(list);

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Collections.binarySearch(list, arr[i]- arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
