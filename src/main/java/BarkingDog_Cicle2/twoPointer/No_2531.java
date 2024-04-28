package BarkingDog_Cicle2.twoPointer;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Set;
//
//public class No_2531 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] ip = br.readLine().split(" ");
//        int N = Integer.parseInt(ip[0]);
//        int d = Integer.parseInt(ip[1]);
//        int k = Integer.parseInt(ip[2]);
//        int c = Integer.parseInt(ip[3]);
//
//        int[] sushi = new int[N+k];
//        for (int i = 0; i < N; i++) {
//            sushi[i] = Integer.parseInt(br.readLine());
//        }
//
//        int idx = 0;
//        for (int i = N; i < N+k-1; i++) {
//            sushi[i] = sushi[idx++];
//        }
//
//
//        int ans = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int st = 0; st < N; st++) {
//
//            for (int i = st; i < st+k; i++) {
//                if (set.contains(sushi[i])) continue;
//                set.add(sushi[i]);
//            }
//            set.add(c);
//
//            if (set.size() > ans) ans = set.size();
//
//            set.clear();
//        }
//
//        System.out.println(ans);
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int d = Integer.parseInt(ip[1]);
        int k = Integer.parseInt(ip[2]);
        int c = Integer.parseInt(ip[3]);

        int[] sushi = new int[N+k];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for (int i = N; i < N+k-1; i++) {
            sushi[i] = sushi[idx++];
        }


        int ed = 0;
        int tmp = 0;
        int cnt = 0;
        int ans = 0;
        int[] check = new int[d+1];
        for (int st = 0; st < N; st++) {
            while (ed < N+k-1 && cnt < k) {
                if (check[sushi[ed]] == 0) {
                    tmp++;
                }

                check[sushi[ed++]]++;
                cnt++;
            }

            if (check[c] == 0) {
                if (ans < tmp+1) ans = tmp+1;
            }else {
                if (ans < tmp) ans = tmp;
            }

            cnt--;
            check[sushi[st]]--;
            if (check[sushi[st]] == 0) tmp--;
        }

        System.out.println(ans);
    }
}