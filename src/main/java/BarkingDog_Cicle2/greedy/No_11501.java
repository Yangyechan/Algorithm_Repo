package BarkingDog_Cicle2.greedy;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class No_11501 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        for (int t = 0; t < T; t++) {
//            int N = Integer.parseInt(br.readLine());
//            String[] ip = br.readLine().split(" ");
//
//            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//            int[] arr = new int[N];
//            List<Integer> max = new ArrayList<>();
//
//            for (int i = 0; i < N; i++) {
//                arr[i] = Integer.parseInt(ip[i]);
//                max.add(arr[i]);
//            }
//            Collections.sort(max);
//
//            long ans = 0;
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < N; i++) {
//                if (arr[i] == max.get(max.size()-1)) {
//
//                    if (list.size() != 0) {
//                        for (int j = 0; j < list.size(); j++) {
//                            ans += arr[i] - list.get(j);
//                        }
//                    }
//
//                    list = new ArrayList<>();
//                    max.remove(max.size()-1);
//
//                }else {
//                    list.add(arr[i]);
//                }
//            }
//            if (!list.isEmpty()) {
//                int last = list.get(list.size()-1);
//                for (int i = 0; i < list.size()-1; i++) {
//                    ans += last - list.get(i);
//                }
//            }
//            sb.append(ans + "\n");
//        }
//
//        System.out.println(sb);
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int max = arr[n-1];
            long sum = 0;
            for (int i = n-2; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                    continue;
                }
                sum += max - arr[i];
            }

            sb.append(sum+ "\n");
        }
        System.out.println(sb);
    }
}