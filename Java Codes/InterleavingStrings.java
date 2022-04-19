package DP;

import java.util.Arrays;
import java.util.Scanner;

public class InterleavingStrings {


    static class Solution {
        String s1, s2, s3;
        int[][] memo;
        boolean dp(int i, int j) {


            int k = i + j;
            if (k == s3.length()) return true;

            if (memo[i][j] != -1) return memo[i][j] != 0;

            boolean ans = false;
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                ans |= dp(i + 1, j);
            }

            if (j < s2.length() && s2.charAt(i) == s3.charAt(k)) {
                ans |= dp(i, j + 1);
            }

            memo[i][j] = ans ? 1 : 0;
            return ans;

        }
        boolean isInterleave(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            if (s1.length() + s2.length() != s3.length()) return false;
            memo = new int[s1.length()+1][s2.length()+1];
            for(int i = 0; i < memo.length; i++){
                Arrays.fill(memo[i] , -1);
            }
            return dp(0, 0);
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next(), s2 =scanner.next(), s3 = scanner.next();


        Solution H = new Solution();
        System.out.println(H.isInterleave(s1, s2, s3));
    }



}
