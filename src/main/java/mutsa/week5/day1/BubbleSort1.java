package mutsa.week5.day1;

import java.util.Arrays;

public class BubbleSort1 {
    public int[] sortArround(int[] arr, int until){
        int temp = 0;
        for (int i = 0; i < until; i++) {
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        return arr;
    }
    public int[] sort(int[] arr){
        for (int i = 1; i <= arr.length; i++) {
            arr = sortArround(arr, arr.length-i);
        }
        return arr;
    }
    public static void main(String[] args) {
        BubbleSort1 bs = new BubbleSort1();
        int[] arr = {7, 2, 28, 3, 9, 1};
        bs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
