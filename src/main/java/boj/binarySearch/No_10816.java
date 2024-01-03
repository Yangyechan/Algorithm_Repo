package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        String str = br.readLine();
        String[] strings = str.split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(list);
        int m = Integer.parseInt(br.readLine());
        // int[] check = new int[m];
        String str2 = br.readLine();
        String[] strings2 = str2.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(strings2[i]);
            int lowerBound = lowerBound(list, target);
            int upperBound = upperBound(list, target);
            sb.append((upperBound - lowerBound) + " ");
        }
        System.out.println(sb);
    }
    private static int lowerBound(int[] list, int target) {
        int start = 0;
        int end = list.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= list[mid]) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static int upperBound(int[] list, int target) {
        int start = 0;
        int end = list.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target < list[mid]) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] cards = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            cards[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(cards); // 이분탐색을 위해 배열 정렬
//
//        int m = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        //StringBuilder sb = new StringBuilder();
//        int[] check = new int[m];
//        for (int i = 0; i < m; i++) {
//            int target = Integer.parseInt(st.nextToken());
//            int lowerBound = lowerBound(cards, target);
//            int upperBound = upperBound(cards, target);
//            //sb.append((upperBound - lowerBound) + " ");
//            check[i] = upperBound - lowerBound;
//        }
//        for (int i = 0; i < m; i++) {
//            System.out.print(check[i] + " ");
//        }
//        //System.out.println(sb.toString());
//    }
//
//    // lower bound를 찾는 이분탐색 메서드 // -10 -10 2 3 3 6 7 10 10 10
//                                      //  0   1  2 3 4 5 6 7  8  9
//    private static int lowerBound(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length;
//
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (arr[mid] >= target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left; //6
//    }
//
//    // upper bound를 찾는 이분탐색 메서드 // -10 -10 2 3 3 6 7 10 10 10
//                                      //  0   1  2 3 4 5 6  7  8  9
//    private static int upperBound(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length;
//
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (arr[mid] > target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left; // 9
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] list = new int[N];
//        for (int i = 0; i < N; i++) {
//            list[i] = sc.nextInt();
//        }
//        Arrays.sort(list); // -10 -10 2 3 3 6 7 10 10 10
//        int M = sc.nextInt();
//        int[] check = new int[M];
//        for (int i = 0; i < M; i++) {
//            int target = sc.nextInt();
//
//            int start_idx = 0;
//            int end_idx = list.length - 1;
//            while (start_idx < end_idx) {
//                int mid_idx = (start_idx + end_idx) / 2;
//                int mid_value = list[mid_idx];
//                if (target == list[start_idx]) {
//                    check[i]++;
//                    if (target < mid_value) {
//                        start_idx = mid_idx + 1;
//                    }else {
//                        start_idx++;
//                    }
//                }
//                if (target == list[end_idx]) {
//                    check[i]++;
//                    if (target > mid_value) {
//                        end_idx = mid_idx - 1;
//                    }else {
//                        end_idx--;
//                    }
//                }
//
//            }
//        }
//        for (int i = 0; i < M; i++) {
//            System.out.print(check[i] + " ");
//        }
//    }
}
