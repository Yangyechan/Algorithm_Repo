package workbook.bruteforce;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class No_7568 {
//    static class Node implements Comparable<Node> {
//        int idx, kg, length, score;
//
//        Node(int idx, int kg, int length) {
//            this.idx = idx;
//            this.kg = kg;
//            this.length = length;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            if (length < o.length && kg < o.kg) {
//                return 1;
//            } else if (length > o.length && kg > o.kg) {
//                return -1;
//            }else {
//                return 0;
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        List<Node> list = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            String[] ip = br.readLine().split(" ");
//            int x = Integer.parseInt(ip[0]);
//            int y = Integer.parseInt(ip[1]);
//
//            list.add(new Node(i, x, y));
//        }
//
//        Collections.sort(list);
//        Node now = list.get(0);
//        now.score = 1;
//        int tmp = 0;
//        for (int i = 1; i < list.size(); i++) {
//            Node nxt = list.get(i);
//
//            if (now.kg > nxt.kg && now.length > nxt.length) {
//                nxt.score = now.score + 1 + tmp;
//                tmp = 0;
//            } else if (now.kg >= nxt.kg && now.length <= nxt.length) {
//                nxt.score = now.score;
//
//                tmp++;
//            } else if (now.kg < nxt.kg && now.length >= nxt.length) {
//                nxt.score = now.score;
//
//                tmp++;
//            }
//
//            now = nxt;
//        }
//
//        int[] d = new int[N];
//        for (int i = 0; i < list.size(); i++) {
//            d[list.get(i).idx] = list.get(i).score;
//        }
//
//        for (int i = 0; i < N; i++) {
//            System.out.print(d[i] + " ");
//        }
//    }
//}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class No_7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        String[] str;
        for(int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);	// [i][0] : 몸무게
            arr[i][1] = Integer.parseInt(str[1]);	// [i][1] : 키
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int rank = 1;

            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }

            sb.append(rank).append(' ');
        }
        System.out.println(sb);
    }
}