package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] ip = br.readLine().split(" ");

        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(card);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        ip = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(ip[i]);
            int low = lowerBound(card, num);
            int upp = upperBound(card, num);
            sb.append(upp - low + " ");
        }

        System.out.println(sb);
    }
    static int lowerBound(int[] card, int target) {
        int st = 0;
        int ed = card.length;
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target <= card[mid]) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }
        return st;
    }

    static int upperBound(int[] card, int target) {
        int st = 0;
        int ed = card.length;
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target < card[mid]) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }
        return st;
    }
}
