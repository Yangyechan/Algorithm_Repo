package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        String str = br.readLine();
        checked(str);
    }

    static void checked(String str) {
        int zero=0;
        int one=0;

        if(str.charAt(0)=='0') zero++;
        else one++;

        for(int i=1;i<str.length();i++) {
            if(str.charAt(i-1)!=str.charAt(i)) {
                if(str.charAt(i)=='0') {
                    zero++;
                }else {
                    one++;
                }
            }
        }
        System.out.println(Math.min(zero, one));
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        int first = s.charAt(0) - '0';
//        int zeroCnt = 0;
//        int oneCnt = 0;
//        for (int i = 1; i < s.length(); i++) {
//            int before = s.charAt(i-1) - '0';
//            int next = s.charAt(i) - '0';
//            if ((before == 0) && next == 1) {
//                zeroCnt++;
//            }
//            if ((before == 1) && next == 0) {
//                oneCnt++;
//            }
//        }
//
//        System.out.println(Math.min(zeroCnt, oneCnt));
//    }
}
