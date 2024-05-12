package workbook.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Set<Integer> set =  new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");

            if (ip[0].equals("add")) {
                set.add(Integer.parseInt(ip[1]));
            } else if (ip[0].equals("remove")) {
                set.remove(Integer.parseInt(ip[1]));
            } else if (ip[0].equals("check")) {
                int num = Integer.parseInt(ip[1]);

                if (set.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            } else if (ip[0].equals("toggle")) {
                int num = Integer.parseInt(ip[1]);

                if (set.contains(num)) set.remove(num);
                else set.add(num);
            } else if (ip[0].equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }else {
                set = new HashSet<>();
            }
        }

        System.out.println(sb);
    }
}
