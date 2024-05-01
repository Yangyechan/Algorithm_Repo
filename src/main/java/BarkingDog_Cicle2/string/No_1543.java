package BarkingDog_Cicle2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str= br.readLine();
        String target = br.readLine();

        str = str.replaceAll(target, "1");

        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') ans++;
        }

        System.out.println(ans);
    }
}

//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    String str= br.readLine();
//    String target = br.readLine();
//    char[] ch = new char[str.length()];
//
//    for (int i = 0; i < str.length(); i++) {
//        ch[i] = str.charAt(i);
//    }
//
//    int idx = 0;
//    int ans = 0;
//    while (idx < str.length()) {
//        int tmp = 0;
//        boolean pos = false;
//        for (int i = idx; i < target.length()+idx; i++) {
//            if (i == str.length()) {
//                idx = i;
//                pos = false;
//                break;
//            }
//
//            if (ch[i] == target.charAt(tmp++)) {
//                pos = true;
//            }else {
//                pos = false;
//                idx = i+1;
//                break;
//            }
//        }
//
//        if (pos) {
//            ans++;
//            idx += target.length();
//        }
//    }
//
//    System.out.println(ans);
//}
