package BaekjunOnlineJudge.sort;

import java.util.Arrays;

public class quick {
    static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

    public static void quickSort(int st, int en) {
        if (en <= st + 1) return; // 수열의 길이가 1 이하이면 함수 종료(base condition)
        int pivot = arr[st]; // 제일 앞의 것을 pivot으로 잡는다.
        int l = st + 1; // 포인터 l
        int r = en - 1; // 포인터 r
        while (true) {
            while (l <= r && arr[l] <= pivot) l++;
            while (l <= r && arr[r] >= pivot) r--;
            if (l > r) break; // l과 r이 역전되면 반복문 탈출
            swap(arr, l, r);
        }
        swap(arr, st, r);
        quickSort(st, r);
        quickSort(r + 1, en);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = arr.length;
        quickSort(0, n);
        System.out.println(Arrays.toString(arr));
    }
}

