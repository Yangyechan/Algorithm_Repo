package BaekjunOnlineJudge.binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_23326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);

        TreeSet<Integer> ts = new TreeSet<>();
        String[] input2 = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(input2[i-1]);
            if (n == 1) {
                ts.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int now = 1;
        for (int i = 0; i < Q; i++) {
            String[] input3 = br.readLine().split(" ");
            if (input3[0].equals("1")) {
                int n = Integer.parseInt(input3[1]);
                if (ts.contains(n)) {
                    ts.remove(n);
                }else {
                    ts.add(n);
                }
            } else if (input3[0].equals("2")) {
                int n = Integer.parseInt(input3[1]);
                now = (now + n) % N;
                if (now == 0) {
                    now = N;
                }
            }else {
                if (ts.isEmpty()) sb.append("-1\n");
                else {
                    Integer n = ts.ceiling(now);
                    if (n != null) {
                        sb.append(n - now + "\n");
                    }else {
                        int tmp = ts.first();
                        sb.append(N - now + tmp + "\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeSet;
//
//class place implements Comparable<place> {
//    int num, dis;
//
//    place(int num, int dis) {
//        this.num = num;
//        this.dis = dis;
//    }
//
//    @Override
//    public int compareTo(place o) {
//        if (dis == o.dis) {
//            return num - o.num;
//        }
//        return o.dis - dis;
//    }
//}
//public class No_23326 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int Q = Integer.parseInt(input[1]);
//        TreeSet<place> ts = new TreeSet<>();
//        Map<Integer, Integer> map = new HashMap<>();
//
//        String[] input2 = br.readLine().split(" ");
//        for (int i = 1; i <= N; i++) {
//            int check = Integer.parseInt(input2[i-1]);
//            if (check == 1) {
//                ts.add(new place(i, check));
//            }else {
//                ts.add(new place(Integer.MAX_VALUE, check));
//            }
//            map.put(i, check);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int now = 1;
//        for (int i = 0; i < Q; i++) {
//            String[] input3 = br.readLine().split(" ");
//            if (input3[0].equals("1")) {
//                int key = Integer.parseInt(input3[1]);
//                if (map.get(key) == 0) {
//                    map.put(key, 1);
//                    ts.remove(new place(0, key));
//                    if (now <= key) {
//                        ts.add(new place(key - now, key));
//                    }else {
//                        ts.add(new place(now + key, key));
//                    }
//                }else {
//                    map.put(key, 0);
//                    ts.remove(new place(0, key));
//                    ts.add(new place(Integer.MAX_VALUE, key));
//                }
//            } else if (input3[0].equals("2")) {
//                int dis = Integer.parseInt(input3[1]);
//                now = (now + dis) % N;
//            }else {
//                if (ts.first().dis == Integer.MAX_VALUE) {
//                    sb.append(-1 + "\n");
//                }else {
//                    sb.append(ts.first().dis + "\n");
//                }
//            }
//        }
//        System.out.println(sb);
//    }
//}
