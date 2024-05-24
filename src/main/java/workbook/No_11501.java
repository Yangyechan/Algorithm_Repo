package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class No_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int[] arr = new int[N];
            int[] cnt = new int[1000001];

            String[] ip = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(ip[i]);

                pq.offer(n);
                arr[i] = n;
                cnt[n]++;
            }

            long ans = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == pq.peek()) {
                    pq.poll();
                    cnt[arr[i]]--;
                }else {
                    if (cnt[pq.peek()] > 0) {
                        ans += pq.peek() - arr[i];
                        cnt[arr[i]]--;
                    }else {
                        while (true) {
                            if (cnt[pq.peek()] > 0) {
                                ans += pq.peek() - arr[i];
                                cnt[arr[i]]--;
                                break;
                            }
                            pq.poll();
                        }
                    }
                }
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        for (int t = 0; t < T; t++) {
//            int n = Integer.parseInt(br.readLine());
//            int[] arr = new int[n];
//            String[] str = br.readLine().split(" ");
//            for (int i = 0; i < n; i++) {
//                arr[i] = Integer.parseInt(str[i]);
//            }
//
//            int max = arr[n-1];
//            long sum = 0;
//            for (int i = n-2; i >= 0; i--) {
//                if (max < arr[i]) {
//                    max = arr[i];
//                    continue;
//                }
//                sum += max - arr[i];
//            }
//
//            sb.append(sum+ "\n");
//        }
//        System.out.println(sb);
//    }
//}