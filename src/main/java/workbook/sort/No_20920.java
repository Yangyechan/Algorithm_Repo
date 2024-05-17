package workbook.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_20920 {
    static class Word implements Comparable<Word> {
        String str;
        int length, cnt;

        Word(String str, int length, int cnt) {
            this.str = str;
            this.length = length;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (o.cnt == cnt) {
                return o.length - length;
            }
            return o.cnt - cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        Map<String, Integer> map = new HashMap<>();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() < M) continue;

            if (!map.containsKey(str)) {
                map.put(str, 1);
                strList.add(str);
            }else {
                int tmp = map.get(str);
                map.put(str, tmp+1);
            }
        }
        Collections.sort(strList);

        List<Word> pq = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);

            pq.add(new Word(str, str.length(), map.get(str)));
        }
        Collections.sort(pq);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pq.size(); i++) {
            String str = pq.get(i).str;
            sb.append(str + "\n");
        }

        System.out.println(sb);
    }
}

/*
12 5
attendance
appearance
append
abbbbbbbbb
swift
swift
swift
mouse
wallet
mouse
ice
age
 */
