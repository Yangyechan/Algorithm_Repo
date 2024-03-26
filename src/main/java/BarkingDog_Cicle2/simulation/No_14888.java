package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_14888 {
    static int N;
    static int[] numArr;
    static char[] cal;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numArr = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(ip[i]);
        }

        cal = new char[N-1];
        int idx = 0;
        ip = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(ip[i]);
            if (count > 0) {
                if (i == 0) {
                    for (int j = 0; j < count; j++) {
                        cal[idx++] = '+';
                    }
                } else if (i == 1) {
                    for (int j = 0; j < count; j++) {
                        cal[idx++] = '-';
                    }
                } else if (i == 2) {
                    for (int j = 0; j < count; j++) {
                        cal[idx++] = '*';
                    }
                }else {
                    for (int j = 0; j < count; j++) {
                        cal[idx++] = '/';
                    }
                }
            }
        }

        arr = new int[N-1];
        visited = new boolean[N-1];
        backTracking(0);
        Collections.sort(ans);

        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));
    }
    static void backTracking(int depth) {
        if (depth == N-1) {
            int sum = numArr[0];

            for (int i = 0; i < N-1; i++) {
                char ch = cal[arr[i]];
                if (ch == '+') {
                    sum += numArr[i+1];
                } else if (ch == '-') {
                    sum -= numArr[i+1];
                } else if (ch == '*') {
                    sum *= numArr[i+1];
                }else {
                    sum /= numArr[i+1];
                }
            }

            ans.add(sum);
            return;
        }

        for (int i = 0; i < N-1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
