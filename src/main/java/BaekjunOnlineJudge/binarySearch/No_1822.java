package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1822 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        ArrayList<Integer> A = new ArrayList<>();
//        ArrayList<Integer> B = new ArrayList<>();
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; ++i) {
//            A.add(Integer.parseInt(st.nextToken()));
//        }
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < m; ++i) {
//            B.add(Integer.parseInt(st.nextToken()));
//        }
//
//        Collections.sort(A);
//        Collections.sort(B);
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        for (int num : A) {
//            if (Collections.binarySearch(B, num) >= 0) continue;
//            ans.add(num);
//        }
//        System.out.println(ans.size());
//        for (int num : ans) System.out.print(num + " ");
//    }
//}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nA = Integer.parseInt(input[0]);
        int nB = Integer.parseInt(input[1]);

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        String[] inputA = br.readLine().split(" ");
        for (int i = 0; i < nA; i++) {
            listA.add(Integer.parseInt(inputA[i]));
        }
        Collections.sort(listA);

        String[] inputB = br.readLine().split(" ");
        for (int i = 0; i < nB; i++) {
            listB.add(Integer.parseInt(inputB[i]));
        }
        Collections.sort(listB);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nA; i++) {
            int na = listA.get(i);
            if (Collections.binarySearch(listB, na) >= 0) continue;
            ans.add(na);
        }
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
