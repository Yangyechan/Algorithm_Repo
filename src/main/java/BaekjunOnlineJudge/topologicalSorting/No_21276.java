package BaekjunOnlineJudge.topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_21276 {
    static List<List<Integer>> lists = new ArrayList<>();
    static List<List<Integer>> child = new ArrayList<>();
    static int[] deg;
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
            child.add(new ArrayList<>());
        }

        Map<Integer, String> name = new HashMap<>();
        Map<String, Integer> number = new HashMap<>();
        String[] ip = br.readLine().split(" ");
        List<String> qck = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            qck.add(ip[i]);
        }
        Collections.sort(qck);

        for (int i = 0; i < N; i++) {
            name.put(i + 1, qck.get(i));
            number.put(qck.get(i), i + 1);
        }

        deg = new int[N + 1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] ip2 = br.readLine().split(" ");
            int numA = number.get(ip2[0]);
            int numB = number.get(ip2[1]);

            deg[numA]++;
            lists.get(numB).add(numA);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists.get(i));
        }

        queue = new LinkedList<>();
        List<Integer> qck2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                queue.offer(i);
                qck2.add(i);
            }
        }

        sb.append(queue.size() + "\n");
        for (int i = 0; i < qck2.size(); i++) {
            sb.append(name.get(qck2.get(i)) + " ");
        }
        sb.append("\n");

        BFS();
        for (int i = 1; i <= N; i++) {
            sb.append(name.get(i) + " " + child.get(i).size() + " ");
            for (int j = 0; j < child.get(i).size(); j++) {
                sb.append(name.get(child.get(i).get(j)) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void BFS() {
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int nxt : lists.get(now)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    queue.offer(nxt);
                    child.get(now).add(nxt);
                }
            }
        }
    }
}
