package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No_2531 {

    public static int stoi(String s) { return Integer.parseInt(s);}

    static int N,d,k,c;
    static int[] arr, sushi;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        d = stoi(st.nextToken());
        k = stoi(st.nextToken());
        c = stoi(st.nextToken());

        arr = new int[N];
        sushi = new int[d+1];

        for(int i = 0; i < N; i++) {
            arr[i] = stoi(br.readLine());
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int max = 0;

        while(true) {
            if(cnt == k) {
                max = Math.max(max, calc());
                sushi[arr[start]]--;
                if(sushi[arr[start]] == 0) cnt--;
                start++;
            }
            else if(end == N) {
                max = Math.max(max, calc());
                break;
            }
            else if(cnt < k) {
                if(sushi[arr[end]] == 0) cnt++;
                sushi[arr[end]]++;
                end++;
            }
        }
        System.out.println(max);
    }

    public static int calc() {
        int cnt = 0;
        for(int i = 1; i <= d; i++) {
            if(sushi[i] > 0) cnt++;
        }
        if(sushi[c] == 0) cnt++;
        return cnt;
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class No_2531 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int d = Integer.parseInt(input[1]);
//        int k = Integer.parseInt(input[2]);
//        int c = Integer.parseInt(input[3]);
//
//        List<Integer> list = new ArrayList<>();
//        boolean[] check = new boolean[d + 1];
//        for (int i = 0; i < N; i++) {
//            list.add(Integer.parseInt(br.readLine()));
//        }
//
//        /*
//
//         */
//        int st = 0;
//        int ed = 1;
//        int min = 1;
//        int len = 0;
//
//        boolean isCoupon = false;
//        if (list.get(0) == c) isCoupon = true;
//        check[list.get(0)] = true;
//        while (ed < N) {
//            if (len < k) {
//                if (!isCoupon && ed == c) {
//                    isCoupon = true;
//                }
//                if (!check[ed]) {
//                    check[ed] = true;
//                    len = ed - st + 1;
//                    min = Math.max(min, len);
//                }
//            } else if (len == k && ed == c) {
//                if (!isCoupon) {
//                    min++;
//                    ed++;
//                }else {
//                    check[st++] = false;
//                }
//            } else {
//                check[st++] = false;
//            }
//        }
//
//    }
//}
