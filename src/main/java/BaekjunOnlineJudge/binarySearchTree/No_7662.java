package BaekjunOnlineJudge.binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                int num = Integer.parseInt(input[1]);

                if (input[0].equals("D")) {
                    if (tm.isEmpty()) continue;

                    if (num == -1) {
                        int firstKey = tm.firstKey();
                        tm.put(firstKey, tm.get(firstKey) - 1);

                        if (tm.get(firstKey) == 0) {
                            tm.remove(firstKey);
                        }
                    } else {
                        int lastKey = tm.lastKey();
                        tm.put(lastKey, tm.get(lastKey) - 1);

                        if (tm.get(lastKey) == 0) {
                            tm.remove(lastKey);
                        }
                    }
                } else {
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                }
            }

            if (tm.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
            }
        }

        System.out.println(sb);
    }
}
/*
1
12
I 9
I 7
I 9
I 6
I 7
I 7
I 9
D -1
D 1
I 8
D 1
D 1
 */
//import algorithm.tree.BinarySearchTree;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.Set;
//import java.util.TreeSet;
//
//public class No_7662 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        for (int t = 0; t < T; t++) {
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            int k = Integer.parseInt(br.readLine());
//            for (int i = 0; i < k; i++) {
//                String[] input = br.readLine().split(" ");
//
//                if (input[0].equals("D")) {
//                    pq.offer(Integer.parseInt(input[1]));
//                }else {
//                    pq.offer(Integer.parseInt(input[1]));
//                }
//            }
//        }
//    }
//}
