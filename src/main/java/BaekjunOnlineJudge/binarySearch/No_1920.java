package BaekjunOnlineJudge.binarySearch;

import java.util.*;

public class No_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] listN = new int[N];
        for (int i = 0; i < N; i++) {
            listN[i] = sc.nextInt();
        }
        Arrays.sort(listN);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            boolean find = false;
            int start = 0;
            int end = listN.length - 1;
            while (start <= end) {
                int mid_index = (start + end)/2;
                int mid_value = listN[mid_index];
                if (target > mid_value) {
                    start = mid_index + 1;
                } else if (target < mid_value) {
                    end = mid_index - 1;
                }else {
                    find = true;
                    break;
                }
            }if (find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
//public class No_1920 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            list.add(sc.nextInt());
//        }
//        Collections.sort(list);
//
//        int M = sc.nextInt();
//        int[] listM = new int[M];
//        for (int i = 0; i < M; i++) {
//            listM[i] = sc.nextInt();
//        }
//
//        int[] cheched = new int[M];
//        int target = 0;
//
//        for (int i = 0; i < M; i++) {
//            boolean find = false;
//            target = listM[i];
//            int start = 0;
//            int end = list.size() - 1;
//            while (start <= end) {
//                int mid_index = (start + end)/2;
//                int mid_value = list.get(mid_index);
//                if (mid_value > target) {
//                    end = mid_index - 1;
//                } else if (mid_value < target) {
//                    start = mid_index + 1;
//                }else {
//                    find = true;
//                    break;
//                }
//            }
//            if (find) System.out.println(1);
//            else System.out.println(0);
//        }
//    }
//}
