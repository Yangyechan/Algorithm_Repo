package BaekjunOnlineJudge.arraysAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class No_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            List<Character> idx = new ArrayList<>();
            List<Character> list = new LinkedList<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                idx.add(str.charAt(j));
            }
            ListIterator<Character> it = list.listIterator();
            for (int j = 0; j < idx.size(); j++) {
                switch (idx.get(j)) {
                    case '<' :
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                        break;
                    case '>' :
                        if (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case '-' :
                        if (it.hasPrevious()) {
                            it.previous();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(idx.get(j));
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
