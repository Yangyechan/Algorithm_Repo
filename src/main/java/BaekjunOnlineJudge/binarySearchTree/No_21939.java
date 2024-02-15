package BaekjunOnlineJudge.binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class practice implements Comparable<practice> {
    int num, level;

    practice(int num, int level) {
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(practice o) {
        if (level == o.level) {
            return o.num - num;
        }
        return o.level - level;
    }
}
public class No_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<practice> ts = new TreeSet<>();
        Map<Integer, practice> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);
            practice tmp = new practice(p, l);
            ts.add(tmp);
            map.put(p, tmp);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            if (input2[0].equals("add")) {
                int p = Integer.parseInt(input2[1]);
                int l = Integer.parseInt(input2[2]);
                practice tmp = new practice(p, l);
                ts.add(tmp);
                map.put(p, tmp);
            } else if (input2[0].equals("recommend")) {
                if (ts.isEmpty()) continue;
                if (input2[1].equals("1")) {
                    sb.append(ts.first().num + "\n");
                }else {
                    sb.append(ts.last().num + "\n");
                }
            }else {
                int p = Integer.parseInt(input2[1]);
                practice tmp = map.get(p);
                ts.remove(tmp);
                map.remove(p);
            }
        }
        System.out.println(sb);
    }
}
