package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1253 {
    static int ans;
    static int n;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        boolean isZero = false;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            list.add(num);
            if (num > 0) {
                isZero = true;
            }
        }
        if (!isZero) {
            System.out.println(n);
            return;
        }
        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            solve(i);
        }
        System.out.println(ans);;
    }
    static void solve(int i) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            int x = list.get(i) - list.get(j);
            int idx = Collections.binarySearch(list, x);
            if (idx >= 0 && idx < n && list.get(idx) == x) {
                if (idx != i && idx != j) {
                    ans++;
                    return;
                }
            }
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class No_1253 {
//    static int n;
//    static long[] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        arr = new long[n];
//        String[] input = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = Long.parseLong(input[i]);
//        }
//        Arrays.sort(arr);
//
//
//        Set<Long> set = new HashSet<>();
//        long ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int start = lowerBound(j+1, n, arr[i] + arr[j]);
//                int end = upperBound(j+1, n, arr[i] + arr[j]);
//                if (!set.contains(arr[i] + arr[j])) {
//                    set.add(arr[i] + arr[j]);
//                    ans += end-start;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//
//    static int lowerBound(int st, int ed, long target) {
//        while (st < ed) {
//            int mid = (st + ed) / 2;
//            if (target <= arr[mid]) {
//                ed = mid;
//            }else {
//                st = mid + 1;
//            }
//        }
//        return st;
//    }
//
//    static int upperBound(int st, int ed, long target) {
//        while (st < ed) {
//            int mid = (st + ed) / 2;
//            if (target < arr[mid]) {
//                ed = mid;
//            }else {
//                st = mid + 1;
//            }
//        }
//        return st;
//    }
//}
