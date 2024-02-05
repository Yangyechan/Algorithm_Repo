package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        List<StringBuilder> checkList = new ArrayList<>();

        for (int t = 0; t < M; t++) {
            int[] arr = new int[N];
            List<Integer> list = new ArrayList<>();
            checkList.add(new StringBuilder());

            String[] input2 = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(input2[i]);
                arr[i] = num;
                list.add(num);
            }
            Collections.sort(list);

            for (int i = 0; i < N; i++) {
                int tmp = lowerBound(list, arr[i]);
                checkList.get(t).append(tmp);
            }
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            String str1 = checkList.get(i).toString();
            for (int j = i + 1; j < M; j++) {
                String str2 = checkList.get(j).toString();
                if (str1.equals(str2)) ans++;
            }
        }
        System.out.println(ans);
    }
    static int lowerBound(List<Integer> list, int target) {
        int st = 0;
        int ed = list.size();
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target <= list.get(mid)) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }
        return st;
    }
}
