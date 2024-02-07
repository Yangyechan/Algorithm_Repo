package BaekjunOnlineJudge.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        String[] tmp = new String[set.size()];
        Iterator<String> it = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            tmp[i] = it.next();
        }

        Map<Integer, Queue<String>> map = new HashMap<>();
        int[] idx = new int[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            int len = tmp[i].length();
            map.put(len, new LinkedList<>());
            idx[i] = len;
        }

        Arrays.sort(tmp);
        Arrays.sort(idx);
        for (int i = 0; i < tmp.length; i++) {
            map.get(tmp[i].length()).offer(tmp[i]);
        }

        for (int i = 0; i < idx.length; i++) {
            System.out.println(map.get(idx[i]).poll());
        }
    }
}
