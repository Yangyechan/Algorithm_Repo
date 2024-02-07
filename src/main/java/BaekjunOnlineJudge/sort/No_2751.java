package BaekjunOnlineJudge.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2751 { // 병합 정렬
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, arr.length);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
    static void mergeSort(int st, int ed) {
        if (ed - st == 1) return;
        int mid = (st + ed) / 2;
        mergeSort(st, mid);
        mergeSort(mid, ed);
        merge(st, mid, ed);
    }
    static void merge(int st, int mid, int ed) {
        int lidx = st;
        int ridx = mid;
        for (int i = st; i < ed; i++) {
            if (lidx == mid) tmp[i] = arr[ridx++];
            else if (ridx == ed) tmp[i] = arr[lidx++];
            else if (arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }
        for (int i = st; i < ed; i++) {
            arr[i] = tmp[i];
        }
    }
 }

//public class No_2751 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        Arrays.sort(arr);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(arr[i] + "\n");
//        }
//        System.out.println(sb);
//    }
//}
