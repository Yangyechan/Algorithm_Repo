package workbook.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_20006 {
    static class User implements Comparable<User> {
        int level;
        String name;

        User(int level, String name) {
            this.level = level;
            this.name = name;
        }

        public int compareTo(User o) {
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int p = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);

        List<List<User>> lists = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < p; i++) {
            ip = br.readLine().split(" ");

            int l = Integer.parseInt(ip[0]);
            String n = ip[1];

            for (int j = 0; j < 300; j++) {

                if (lists.get(j).isEmpty()) {
                    lists.get(j).add(new User(l, n));
                    break;
                }else {
                    if (lists.get(j).size() < m && lists.get(j).get(0).level - 10 <= l && lists.get(j).get(0).level + 10 >= l) {
                        lists.get(j).add(new User(l, n));
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            if (lists.get(i).size() == m) {
                Collections.sort(lists.get(i));
                sb.append("Started!\n");
                for (int j = 0; j < m; j++) {
                    sb.append(lists.get(i).get(j).level + " " + lists.get(i).get(j).name + " \n");
                }
            }else if (!lists.get(i).isEmpty()){
                Collections.sort(lists.get(i));
                sb.append("Waiting!\n");
                for (int j = 0; j < lists.get(i).size(); j++) {
                    sb.append(lists.get(i).get(j).level + " " + lists.get(i).get(j).name + " \n");
                }
            }
        }

        System.out.println(sb);
    }
}
