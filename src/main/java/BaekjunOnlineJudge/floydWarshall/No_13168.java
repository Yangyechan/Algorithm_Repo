package BaekjunOnlineJudge.floydWarshall;

import java.io.*;
import java.util.*;

public class No_13168 {

    static final int MX = 100;
    static HashMap<String, Integer> city_to_id = new HashMap<>();
    static int citycnt = 0;
    static ArrayList<Integer> dest = new ArrayList<>(); // destination
    static int[][][] d = new int[2][MX + 2][MX + 2]; // d[is_railro][u][v] = (cost for u to v)

    static int trans_code(String str) {
        if(str.startsWith("S-") || str.startsWith("V")) return 1; // S-train, V-train: 50% 할인
        else if(str.startsWith("I") || str.startsWith("M")) return 2; // ITX, 무궁화: 공짜
        return 0; // 가격 변동 없음
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int diff = Integer.parseInt(input[1]) * 2;

        String[] name = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            if(!city_to_id.containsKey(name[i])) {
                city_to_id.put(name[i], citycnt++);
            }
        }

        int m = Integer.parseInt(br.readLine());
        name = br.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            dest.add(city_to_id.get(name[i]));
        }

        for(int[][] row : d) {
            for(int[] col : row) {
                Arrays.fill(col, (int)1e9);
            }
        }
        for(int i = 0; i < citycnt; i++) {
            d[0][i][i] = 0;
            d[1][i][i] = 0;
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            String tr = line[0];
            int u = city_to_id.get(line[1]);
            int v = city_to_id.get(line[2]);
            int cost = Integer.parseInt(line[3]) * 2;

            cost = Math.min(d[0][u][v], cost);
            d[0][u][v] = d[0][v][u] = cost;

            int trcode = trans_code(tr);
            if(trcode == 1) cost /= 2;
            else if(trcode == 2) cost = 0;

            cost = Math.min(d[1][u][v], cost);
            d[1][u][v] = d[1][v][u] = cost;
        }


        for(int k = 0; k < citycnt; k++) {
            for(int i = 0; i < citycnt; i++) {
                for(int j = 0; j < citycnt; j++) {
                    for(int t = 0; t < 2; t++) {
                        d[t][i][j] = Math.min(d[t][i][j], d[t][i][k] + d[t][k][j]);
                    }
                }
            }
        }

        for(int i = 1; i < dest.size(); i++) {
            int u = dest.get(i - 1);
            int v = dest.get(i);
            diff -= d[0][u][v];
            diff += d[1][u][v];
        }

        if(diff < 0) System.out.println("Yes");
        else System.out.println("No");
    }
}

