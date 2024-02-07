package BaekjunOnlineJudge.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class No_9466 {
    static int[] arr;
    static int n;
    static int[] state;

    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    static void run(int x) {
        int cur = x;
        while(true) {
            state[cur] = x;
            cur = arr[cur];
            if(state[cur] == x) {
                while(state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            } else if(state[cur] != 0) return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            n = sc.nextInt();
            state = new int[n+1];
            Arrays.fill(state, NOT_VISITED);
            arr = new int[n+1];
            for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                if(state[i] == NOT_VISITED) run(i);
            }
            int cnt = 0;
            for(int i = 1; i <= n; i++) {
                if(state[i] != CYCLE_IN) cnt++;
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}

