package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class No_2910 { // 다시
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();//HashMap생성
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 해시맵 안에 num이 있으면 기존 값에 +1을 해주어 저장하고
            // 없으면 새로 값을 추가합니다.
            if (map.containsKey(num)) {
                map.put(num , map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        // 키를 모두 array list에 저장해두고
        ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());

        // array list에 저장된 값 기준 내림차순으로 정렬합니다.
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(map.get(b), map.get(a));
            }
        });

        //Iterator로 순회하여 출력한다.
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            for(int i=0; i<map.get(element); i++){
                sb.append(element+" ");
            }

        }
        System.out.println(sb);
    }
}
