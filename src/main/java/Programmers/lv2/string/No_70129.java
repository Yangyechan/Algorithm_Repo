package Programmers.lv2.string;

import java.util.*;
public class No_70129 {
    static class Solution {
        public int[] solution(String s) {
            int zeroCnt = 0, transCnt = 0, bfLen = 0, afLen = 0;
            while(!s.equals("1")) {
                bfLen = s.length();
                s = s.replace("0", "");
                afLen = s.length();
                zeroCnt += bfLen - afLen;
                s = Integer.toBinaryString(afLen);
                transCnt++;
            }

            return new int[]{transCnt, zeroCnt};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
