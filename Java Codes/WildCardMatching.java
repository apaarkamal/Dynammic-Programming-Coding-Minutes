package DP;

import java.util.Arrays;
import java.util.Scanner;

public class WildCardMatching {


    static class Solution {
        String s, p;
        int[][] memo;
        boolean dp(int i, int j) {
            if (i == s.length() && j == p.length()) return true;
            if (j == p.length()) return false;
            // if (i == s.size()) ;

            if (memo[i][j] != -1) return memo[i][j] == 1;

            boolean ans = false;

            if (i < s.length() && s.charAt(i) == p.charAt(j)) {
                ans |= dp(i + 1, j + 1);
            }

            else if (p.charAt(j) == '?') {
                if (i == s.length()) {
                    return false;
                }
                else {
                    ans |= dp(i + 1, j + 1);
                }
            }
            else if (p.charAt(j) == '*') {
                if (i < s.length()) {
                    ans |= dp(i + 1, j);
                }
                ans |= dp(i, j + 1);
            }
            memo[i][j] = ans ? 1 : 0;
            return ans;
        }

        boolean isMatch(String ss, String pp) {
            this.s = ss;
            this.p = pp;
            memo = new int[ss.length()+1][pp.length()+1];
            for(int i = 0 ; i < memo.length; i++){
                Arrays.fill(memo[i], -1);
            }
            // 2d array structure filled with -1s
            return dp(0, 0);
        }
    };

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        String s = sn.next(), p = sn.next();

        Solution H = new Solution();
        boolean ans = H.isMatch(s, p);
        System.out.println(ans);

    }
}
