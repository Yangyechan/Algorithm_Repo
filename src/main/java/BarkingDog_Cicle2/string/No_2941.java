package BarkingDog_Cicle2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.replaceAll("c=" , "1");
        str = str.replaceAll("c-", "1");
        str = str.replaceAll("dz=", "1");
        str = str.replaceAll("d-", "1");
        str = str.replaceAll("lj", "1");
        str = str.replaceAll("nj", "1");
        str = str.replaceAll("s=", "1");
        str = str.replaceAll("z=", "1");

        System.out.println(str.length());
    }
}
