package DP;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromicPartitioning2 {


    static class Solution {

        String s;
        int[][] memo;
        int[] memo1;

        // memoising?
        // O(n*n)
        boolean is_palindrome(int i, int j) {
            if (i == j) return true;
            if (i == j - 1) return (s.charAt(i) == s.charAt(j));
            if (memo[i][j] != -1) return memo[i][j] == 1;
            boolean ans = is_palindrome(i + 1, j - 1) && (s.charAt(i) == s.charAt(j));
            memo[i][j] = ans ? 1: 0;
            return ans;
        }

        // states O(n)
        int dp(int i) {
            if (i == s.length()) return 0;

            if (memo1[i] != -1) return memo1[i];

            int ans = Integer.MAX_VALUE;
            // O(n)
            for (int j = i; j < s.length(); j++) {
                if (is_palindrome(i, j)) {
                    ans = Math.min(ans, dp(j + 1));
                }
            }
            ans += 1;
            return memo1[i] = ans;
        }

        int minCut(String s) {
            this.s = s;
            int n = s.length();
            memo = new int[n][n];
            for(int i = 0 ; i  <n; i++){
                Arrays.fill(memo[i], -1);
            }
            Arrays.fill(memo1, -1);

            return dp(0) - 1;
        }
    }

    public static void main(String[] args) {


        Scanner scn =  new Scanner(System.in);
        String s  =scn.next();


        Solution H = new Solution();
        System.out.println(H.minCut(s));

    }
}
