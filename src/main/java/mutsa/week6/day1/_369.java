package mutsa.week6.day1;

import java.util.Scanner;

public class _369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a = num / 10;
        int b = num % 10;
        for (int i = 0; i < num; i++) {
            if (b % 3 == 0 && a != 0){
                System.out.println("*");
            }
        }
        System.out.println(a);
    }
}
