package programmers.lv2.string;

import java.util.*;
public class No_12939 {
    static class Solution {
        public String solution(String s) {
            List<Integer> list = new ArrayList<>();
            String[] split = s.split(" ");

            for (int i = 0; i < split.length; i++) {
                int num = Integer.parseInt(split[i]);
                list.add(num);
            }
            Collections.sort(list);

            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0) + " " + list.get(list.size()-1));
            String answer = "";
            answer = sb.toString();

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("1 2 3 4"));
    }
}
