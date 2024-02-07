package BaekjunOnlineJudge.sort;

import java.util.Scanner;

public class No_2750_BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        int temp = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if (list[j] > list[j+1]) {
                    temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(list[i]);
        }
    }
}
