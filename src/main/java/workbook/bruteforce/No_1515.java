package workbook.bruteforce;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class No_1515 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String n = br.readLine();
//        int i=0;
//        while(true) {
//            i++;
//            String num=Integer.toString(i); //현재 기준의 N
//            while(num.length()>0&&n.length()>0) {
//                if(num.charAt(0)==n.charAt(0)) {
//                    n=n.substring(1);
//                }
//                num=num.substring(1);
//            }
//            if(n=="") {
//                System.out.println(i);
//                break;
//            }
//
//        }
//    }
//
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class No_1515 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine();
//        int pt = 0;
//
//        int base = 0;
//        while (base++ <= 30000) {
//            String tmp = String.valueOf(base);
//            for (int i = 0; i < tmp.length(); i++) {
//                if (tmp.charAt(i) == s.charAt(pt))
//                    pt++;
//                if (pt == s.length()) {
//                    System.out.println(base);
//                    return;
//                }
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int pt = 0;
        int base = 0;

        while (base++ <= 40000) {
            String tmp = String.valueOf(base);

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == str.charAt(pt)) {
                    pt++;
                }

                if (str.length() == pt) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}