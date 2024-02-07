package mutsa.week5.day2;

import java.util.Arrays;

public class SelectionSort1 {
    public static void main(String[] args) { // 선택정렬
        int[] arr = {7, 2, 3, 9, 28, 11};

        for (int j = 0; j < arr.length - 1; j++) { // j = 0            // 첫번째 과정
            int targetValue = arr[j]; // targetvalue = 7
            int targetIdx = j; // targetIdx = 0
            for (int i = j+1; i < arr.length; i++) { // i = 0+1 = 1 // i = 2 // i =3...     // 두번째 과정 j = 0 일때만 value,idx 바뀜
                if(targetValue > arr[i]){ // 7 > 2 // 2 > 3 -> else // else...
                    targetValue = arr[i]; //targetValue = 2
                    targetIdx = i; // targetIdx = 1
                }
            }
            int temp = arr[j]; // temp = 7                          // 세번째 과정 위에서
            arr[j] = arr[targetIdx]; // arr[0] = 2 (arr[1])
            arr[targetIdx] = temp; // arr[1] = 7
        }

        System.out.println(Arrays.toString(arr));
    }
}
