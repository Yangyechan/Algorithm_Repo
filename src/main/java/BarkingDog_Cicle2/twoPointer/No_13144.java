package BarkingDog_Cicle2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }

        int ed = 0;
        long tmp = 0;
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int st = 0; st < N; st++) {
            while (ed < N && !set.contains(arr[ed])) {
                set.add(arr[ed++]);
                tmp++;
            }

            ans += tmp;
            tmp--;
            set.remove(arr[st]);
        }

        System.out.println(ans);
    }
}
