package boj.sort;

import java.util.Scanner;

public class No_1427_SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] list = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            list[i] = num;
        }

        int temp = 0;
        for (int i = 0; i < list.length; i++) {
            int max = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[j] > list[max]) {
                    max = j;
                }
            }
            if (list[i] < list[max]) {
                temp = list[i];
                list[i] = list[max];
                list[max] = temp;
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
        }
    }
}
