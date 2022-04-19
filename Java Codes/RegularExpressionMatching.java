package DP;

import java.util.Arrays;
import java.util.Scanner;

public class RegularExpressionMatching {



    static class Solution {
        String s, p;
        int[][] memo;
        boolean dp(int i, int j) {
            if (i == s.length() && j == p.length()) return true;
            if (j == p.length()) return false;
            // memoisation
            boolean ans = memo[i][j] == 1;
            if (ans) return ans;
            memo[i][j] = 0;
            ans = false;

            if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                // when character matches due to *
                if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                    ans |= dp(i + 1, j);
                }
                // no character matches
                ans |= dp(i, j + 2);
            }
            else {
                if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                    ans |= dp(i + 1, j + 1);
                }
            }

            memo[i][j] = ans ? 1: 0;
            return ans;
        }
        boolean isMatch(String s, String p) {
            this.s = s;
            this.p = p;
            memo = new int[s.length()+1][p.length()+1];
            for(int i = 0; i  < memo.length; i++){
                Arrays.fill(memo[i] , -1);
            }
            return dp(0, 0);
        }
    };

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String s = scn.next(), p = scn.next();


        Solution H =  new Solution();

        System.out.println(H.isMatch(s, p));

    }
}
