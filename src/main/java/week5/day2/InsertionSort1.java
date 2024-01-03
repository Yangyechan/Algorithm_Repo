package week5.day2;

import java.util.Arrays;

public class InsertionSort1 {
    public int[] sort(int[] arr, boolean bl){ // 삽입정렬
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                //System.out.printf("%d %d %d\n", i, j, j-1);
                if((bl ? arr[j-1] - arr[j] : arr[j] - arr[j-1] )> 0){ // j = 1, 7-2 > 0  // j = 2, 7-3 > 0  j = 1,
                    int temp = arr[j]; // temp = 2 // temp = 3
                    arr[j] = arr[j-1]; // arr[1] = 7 // arr[2] = 7
                    arr[j-1] = temp; // arr[0] = 2,  arr = [2, 7, 3, 9, 28, 1] // arr[1] = 3, arr [2, 3, 7, 9, 28, 1]
                } else {
                    break;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 9, 28, 1};
        //Character[] arr2 = {'a', 's', 'd', 'f', 'g', 'h'};
        InsertionSort1 is = new InsertionSort1();
        arr = is.sort(arr, true);
        System.out.println(Arrays.toString(arr));
    }
}
