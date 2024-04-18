package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        List<Integer> target = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                target.add(arr[i]);
            }
        }
        Collections.sort(target);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int t = arr[i];
            int st = 0;
            int ed = target.size();

            while (st < ed) {
                int mid = (st + ed) / 2;
                if (t <= target.get(mid)) {
                    ed = mid;
                }else {
                    st = mid + 1;
                }
            }

            sb.append(st + " ");
        }

        System.out.println(sb);
    }
}
