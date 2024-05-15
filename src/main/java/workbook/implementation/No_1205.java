package workbook.implementation;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class No_1205 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] ip = br.readLine().split(" ");
//        int N = Integer.parseInt(ip[0]);
//        int score = Integer.parseInt(ip[1]);
//        int P = Integer.parseInt(ip[2]);
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        ip = br.readLine().split(" ");
//        for (int i = 0; i < N; i++) {
//            pq.offer(Integer.parseInt(ip[i]));
//        }
//
//        if (pq.isEmpty()) {
//            System.out.println(1);
//            return;
//        }
//
//        int ans = 1;
//        int cnt = 0;
//        boolean pos = false;
//        int pre = -1;
//        while (!pq.isEmpty() && cnt < P) {
//            int now = pq.poll();
//
//            if (score > now) {
//                if (pre == score) {
//                    ans--;
//                }
//
//                pos = true;
//                break;
//            }else {
//                ans++;
//            }
//
//            cnt++;
//            pre = now;
//        }
//
//        if (pos) System.out.println(ans);
//        else System.out.println(-1);
//    }
//}


import java.util.*;

public class No_1205 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int new_score = scanner.nextInt();
        int p = scanner.nextInt();  //랭킹 리스트에 오를 수 있는 갯수.

        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        if(n == p && new_score <= arr[arr.length-1])
            System.out.print(-1);
        else{
            int rank = 1;
            for(int i=0; i<arr.length; i++){
                if(new_score < arr[i])
                    rank++;
                else
                    break;
            }
            System.out.print(rank);
        }
    }
}
