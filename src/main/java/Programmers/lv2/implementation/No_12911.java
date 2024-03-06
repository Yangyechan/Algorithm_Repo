package Programmers.lv2.implementation;

public class No_12911 {
    static class Solution {
        public int solution(int n) {
            int answer = 0;
            int cnt = 0;
            String b = Integer.toBinaryString(n);

            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1') cnt++;
            }

            int nxtCnt = 0;
            answer = n;
            while (cnt != nxtCnt) {
                nxtCnt = 0;
                answer++;
                b = Integer.toBinaryString(answer);
                for (int i = 0; i < b.length(); i++) {
                    if (b.charAt(i) == '1') nxtCnt++;
                }
            }
            return answer;
        }
    }
}
