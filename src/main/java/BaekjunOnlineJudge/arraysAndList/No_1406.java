package BaekjunOnlineJudge.arraysAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        ListIterator<Character> it = list.listIterator();
        while(it.hasNext()) {
            it.next();
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L":
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case "D":
                    if (it.hasNext()) {
                        it.next();
                    }
                    break;
                case "B":
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case "P":
                    it.add(command[1].charAt(0));
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
//        int size = list.size();
//        int c = size; // 4
//        for (int i = 0; i < m; i++) {
//            String p = sc.nextLine();
//            if (p.length() == 3) {
//                char a = p.charAt(2);
//                if (c == list.size()) {
//                    list.add(a);
//                    c++;
//                    continue;
//                }
//                list.add(c, a);
//            }else {
//                if (p.equals("L")) {
//                    c--;
//                    if (c == -1) c++;
//                } else if (p.equals("D")) {
//                    c++;
//                    if (c == size + 1) c--;
//                } else if (p.equals("B")) {
//                    if (c == 0) continue;
//
//                    if (!list.isEmpty()) {
//                        if (c == list.size()) {
//                            list.remove(list.size() - 1);
//                            c--;
//                            continue;
//                        }
//                        if (c-1 < 0) continue;
//                        list.remove(c-1);
//                        c--;
//                    }
//                }
//            }
//        }
//}
