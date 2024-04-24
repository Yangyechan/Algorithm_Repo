package BarkingDog_Cicle2.binarySearch;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class No_1253 {
//    static int N;
//    static long[] arr;
////    static List<Long> list;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//        arr = new long[N];
//        String[] ip = br.readLine().split(" ");
//        for (int i = 0; i < N; i++) {
//            arr[i] = Long.parseLong(ip[i]);
//        }
//        Arrays.sort(arr);
//
//        int ans = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (i == j) continue;
//
//                long target = arr[i] - arr[j];
//                if (target == arr[j] || target == arr[i]) continue;
//                if (binarySearch(target)) {
//                    ans++;
//                    break;
//                }
//            }
//        }
//
//        System.out.println(ans);
//    }
//    static boolean binarySearch(long target) {
//        int st = 0;
//        int ed = N;
//
//        while (st < ed) {
//            int mid = (st + ed) / 2;
//
//            if (target < arr[mid]) {
//                ed = mid;
//            } else if (target > arr[mid]) {
//                st = mid + 1;
//            } else {
//                return true;
//            }
//        }
//
//        return false;
//    }
//}


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
