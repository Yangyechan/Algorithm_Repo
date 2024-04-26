package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_7453 {
    static long[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];
        for (int i = 0; i < n; i++) {
            String[] ip = br.readLine().split(" ");
            A[i] = Long.parseLong(ip[0]);
            B[i] = Long.parseLong(ip[1]);
            C[i] = Long.parseLong(ip[2]);
            D[i] = Long.parseLong(ip[3]);
        }


        long[] arr1 = new long[n*n];
        arr2 = new long[n*n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[idx] = A[i] + B[j];
                arr2[idx++] = C[i] + D[j];
            }
        }

        Arrays.sort(arr2);
        long ans = 0;
        for (int i = 0; i < n*n; i++) {
            long target = -1 * arr1[i];

            int st1 = 0;
            int ed1 = n*n;

            while (st1 < ed1) {
                int mid = (st1 + ed1) / 2;

                if (target <= arr2[mid]) {
                    ed1 = mid;
                }else {
                    st1 = mid + 1;
                }
            }

            int st2 = 0;
            int ed2 = n*n;

            while (st2 < ed2) {
                int mid = (st2 + ed2) / 2;

                if (target < arr2[mid]) {
                    ed2 = mid;
                }else {
                    st2 = mid + 1;
                }
            }

            ans += st2 - st1;
        }

        System.out.println(ans);
    }
    static int lowerBound(long target) {
        int st = 0;
        int ed = arr2.length;

        while (st < ed) {
            int mid = (st + ed) / 2;

            if (target <= arr2[mid]) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st;
    }

    static int upperBound(long target) {
        int st = 0;
        int ed = arr2.length;

        while (st < ed) {
            int mid = (st + ed) / 2;

            if (target < arr2[mid]) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st;
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] A = new int[N], B = new int[N], C = new int[N], D = new int[N];
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            A[i] = Integer.parseInt(st.nextToken());
//            B[i] = Integer.parseInt(st.nextToken());
//            C[i] = Integer.parseInt(st.nextToken());
//            D[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[] CD = new int[N*N];
//        int idx = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                CD[idx++] = C[i] + D[j];
//            }
//        }
//
//        Arrays.sort(CD);
//
//
//
//        long ans = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                int temp = A[i] + B[j];
//                int upper = upperBound(-temp, CD);
//                int lower = lowerBound(-temp, CD);
//                ans += (upper - lower);
//            }
//        }
//        System.out.println(ans);
//    }
//
//
//    static int upperBound(int key, int[] arr) {
//        int start = 0, end = arr.length-1;
//        while (start <= end) {
//            int mid = (start + end)/2;
//            if (arr[mid] > key) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return end;
//    }
//
//    static int lowerBound(int key, int[] arr) {
//        int start = 0, end = arr.length-1;
//        while (start <= end) {
//            int mid = (start + end)/2;
//            if (arr[mid] >= key) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return end;
//    }
//}