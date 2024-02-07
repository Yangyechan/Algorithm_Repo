package algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {36, 12, 18, 15, 41, 19};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
