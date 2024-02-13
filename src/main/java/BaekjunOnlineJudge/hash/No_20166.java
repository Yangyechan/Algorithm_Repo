package BaekjunOnlineJudge.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_20166 {
    static int n, m, k;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
    static char[][] tile;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        tile = new char[n][m];
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input2 = br.readLine();
            for (int j = 0; j < m; j++) {
                tile[i][j] = input2.charAt(j);
            }
        }

        List<String> kList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            map.put(s, 0);
            kList.add(s);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backTracking(i, j, "" + tile[i][j]);
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(map.get(kList.get(i)));
        }
    }

    static void backTracking(int x, int y, String s) {
        if (map.containsKey(s)) {
            int cnt = map.get(s);
            map.put(s, cnt + 1);
        }
        if (s.length() == 5) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = (dx[i] + x + n) % n;
            int ny = (dy[i] + y + m) % m;
            backTracking(nx, ny, s + tile[nx][ny]);
        }
    }
}
