package BaekjunOnlineJudge.binarySearchTree;

//import java.util.*;
//
//class Jewel {
//    int weight, value;
//
//    Jewel(int weight, int value) {
//        this.weight = weight;
//        this.value = value;
//    }
//}
//
//public class No_1202 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        Jewel[] jewels = new Jewel[n];
//        for(int i = 0; i < n; i++){
//            int weight = sc.nextInt();
//            int value = sc.nextInt();
//            jewels[i] = new Jewel(weight, value);
//        }
//
//        Arrays.sort(jewels, Comparator.comparingInt(j -> j.weight));
//
//        TreeSet<Integer> bags = new TreeSet<>();
//        for(int i = 0; i < k; i++){
//            int c = sc.nextInt();
//            bags.add(c);
//        }
//
//        long ans = 0;
//
//        for(int i = n - 1; i >= 0; i--){
//            Integer bag = bags.ceiling(jewels[i].weight);
//            if(bag == null) continue;
//            ans += jewels[i].value;
//            bags.remove(bag);
//        }
//        System.out.println(ans);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class bag implements Comparable<bag>{
    int m, v;

    bag(int m ,int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(bag o) {
        if (v == o.v) {
            return m - o.m;
        }
        return o.v - v;
    }
}
public class No_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        PriorityQueue<bag> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            int m = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);
            pq.offer(new bag(m, v));
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < K; i++) {
            int key = Integer.parseInt(br.readLine());
            if (tm.containsKey(key)) {
                int tmp = tm.get(key);
                tm.put(key, tmp + 1);
            }else {
                tm.put(key, 1);
            }
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            bag target = pq.poll();
            Integer x = tm.ceilingKey(target.m);
            if (x != null && tm.get(x) > 0) {
                ans += target.v;
                int tmp = tm.get(x);
                if (tmp == 1) {
                    tm.remove(x);
                }else {
                    tm.put(x, tmp - 1);
                }
            }
        }
        System.out.println(ans);
    }
}
/*
4 4
1 100
2 200
13 200
10 500
10
10
10
14
 */
