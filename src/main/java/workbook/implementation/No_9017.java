package workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());

            List<List<Integer>> lists = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                lists.add(new ArrayList<>());
            }

            String[] ip = br.readLine().split(" ");
            int[] d = new int[N+1];
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(ip[i]);

                d[num]++;
            }

            int tIdx = 0;
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(ip[i]);

                if (d[num] < 6) continue;

                lists.get(num).add(N-tIdx);
                tIdx++;
            }

            int max = 0;
            int[] score = new int[N+1];
            for (int i = 1; i < N; i++) {
                if (lists.get(i).size() < 6) continue;

                int tmp = 0;
                for (int j = 0; j < 4; j++) {
                    tmp += lists.get(i).get(j);
                }

                if (max < tmp) max = tmp;

                score[i] = tmp;
            }

            List<Integer> candidate = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (score[i] == max) candidate.add(i);
            }

            int idx = 0;
            int nxtMax = 0;
            if (candidate.size() == 1) {
                sb.append(candidate.get(0) + "\n");
            } else {
                for (int i = 0; i < candidate.size(); i++) {
                    if (lists.get(candidate.get(i)).get(4) > nxtMax) {
                        nxtMax = lists.get(candidate.get(i)).get(4);
                        idx = candidate.get(i);
                    }
                }

                sb.append(idx + "\n");
            }
        }

        System.out.println(sb);
    }
}
