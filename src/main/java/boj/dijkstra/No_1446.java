package boj.dijkstra;

import java.util.*;

public class No_1446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지름길의 개수
        int D = sc.nextInt(); // 고속도로의 길이
        int[] dp = new int[D + 1]; // 최단 거리를 저장할 배열

        // 초기화
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        // 지름길 정보 입력
        List<int[]> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();

            // 도착지점이 고속도로의 길이보다 작은 경우에만 추가
            if (end <= D) {
                shortcuts.add(new int[]{start, end, distance});
            }
        }

        // 다익스트라 알고리즘
        for (int i = 0; i <= D; i++) {
            // 현재 위치에서 직통으로 갈 수 있는 경우
            if (i + 1 <= D) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }

            // 지름길을 이용하는 경우
            for (int[] shortcut : shortcuts) {
                int start = shortcut[0];
                int end = shortcut[1];
                int distance = shortcut[2];

                // 지름길을 이용할 수 있는 경우
                if (start == i && end <= D) {
                    dp[end] = Math.min(dp[end], dp[i] + distance);
                }
            }
        }

        System.out.println(dp[D]);
    }
}

