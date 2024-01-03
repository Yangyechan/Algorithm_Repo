package week5.day1;

import java.util.Arrays;

public class BubbleSort2 {
    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        BubbleSort2 bs = new BubbleSort2();
        int[] arr = {7, 2, 28, 3, 9, 11};
        bs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
