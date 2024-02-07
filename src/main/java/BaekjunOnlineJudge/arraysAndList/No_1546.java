package BaekjunOnlineJudge.arraysAndList;

import java.util.Scanner;

public class No_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        double[] list = new double[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextDouble();
        }

        double max = 0;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            if (list[i] > max)
                max = list[i];
        }

        for (int i = 0; i < N; i++) {
            list[i] = list[i]/max*100;
            sum += list[i];
        }
        System.out.println(sum/N);
    }
}
