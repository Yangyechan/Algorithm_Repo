package BarkingDog_Cicle3.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip  = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < ip.length(); i++) {
            char tar = ip.charAt(i);

            arr[tar - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
