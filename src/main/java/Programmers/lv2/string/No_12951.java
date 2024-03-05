package Programmers.lv2.string;

public class No_12951 {
    static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(i, i+1);
                if (tmp.equals(" ")) {
                    sb.append(tmp);
                    continue;
                }
                else if (i == 0) {
                    if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
                        String tmp2 = tmp.toUpperCase();
                        sb.append(tmp2);
                    }else {
                        sb.append(tmp);
                    }
                }else {
                    if (s.charAt(i-1) == ' ' && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                        String tmp2 = tmp.toUpperCase();
                        sb.append(tmp2);
                    }else if (s.charAt(i-1) != ' ' && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                        String tmp2 = tmp.toLowerCase();
                        sb.append(tmp2);
                    }else {
                        sb.append(tmp);
                    }
                }
            }
            String answer = sb.toString();
            return answer;
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        // 테스트 케이스
        String input1 = "3people unFollowed me";
        String input2 = "for the last week";

        // 결과 출력
        System.out.println(s.solution(input1)); // 기대 출력: "3people Unfollowed Me"
        System.out.println(s.solution(input2)); // 기대 출력: "For The Last Week"
    }
}
