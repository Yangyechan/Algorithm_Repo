package BaekjunOnlineJudge.binarySearch;

import java.util.*;
import java.io.*;

public class No_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        ArrayList<Integer> uni = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            uni.add(x[i]);
        }

        Collections.sort(uni);
        uni = new ArrayList<>(new LinkedHashSet<>(uni));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(lowerBound(uni, x[i]) + " ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= arr.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        List<Integer> list = new ArrayList<>();
//        int[] arr = new int[n];
//        String[] input = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            int num = Integer.parseInt(input[i]);
//            arr[i] = num;
//            list.add(num);
//        }
//        Collections.sort(list);
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(list.indexOf(arr[i]));
//        }
//    }
//}
