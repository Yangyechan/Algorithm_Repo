package workbook.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        while (true) {
            String str = br.readLine();

            if (str.equals("end")) break;

            String strTmp = str;

            strTmp = strTmp.replaceAll("ee", "e");
            strTmp = strTmp.replaceAll("oo", "o");

            boolean pos = true;
            char now = strTmp.charAt(0);
            int cnt1 = 0;
            int cnt2 = 0;
            int aeiouCnt = 0;

            if (set.contains(now)) {
                cnt1++;
                aeiouCnt++;
            }else {
                cnt2++;
            }

            for (int i = 1; i < strTmp.length(); i++) {
                char nxt = strTmp.charAt(i);

                if (now == nxt) {
                    if ((now == 'e' && nxt == 'e') || (now == 'o' &&  nxt == 'o')) {
                        cnt1++;
                        cnt2 = 0;
                        aeiouCnt++;

                        if (cnt1 == 3) {
                            pos = false;
                            break;
                        }
                    }else {
                        pos = false;
                        break;
                    }
                }

                if (set.contains(nxt)) {
                    cnt1++;
                    cnt2 = 0;
                    aeiouCnt++;

                    if (cnt1 == 3) {
                        pos = false;
                        break;
                    }
                }else {
                    cnt2++;
                    cnt1 = 0;

                    if (cnt2 == 3) {
                        pos = false;
                        break;
                    }
                }

                now = nxt;
            }

            if (!pos || aeiouCnt == 0) {
                sb.append("<" + str + ">" + " is not acceptable.\n");
            }else {
                sb.append("<" + str + ">" + " is acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}
