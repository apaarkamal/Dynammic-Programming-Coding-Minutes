package DP;

import java.util.Arrays;

public class SplitArrayLargestSum {


    static class Solution {

        int[][] memo;
        int dp(int i, int[] nums, int m) {
            if (i == nums.length) {
                if (m == 0) return 0;
                return (int) 1e9;
            }
            if (m <= 0) return (int) 1e9;
            // i>=0 && i<n && m>0
            // I can make partitions
            if (memo[i][m] != -1) return memo[i][m];
            int ans = (int) 1e9, sum = 0;
            for (int j = i; j < nums.length; j++) {
                // i....j
                sum += nums[j];
                ans = Math.min(ans, Math.max(sum, dp(j + 1, nums, m - 1)));
            }
            return memo[i][m] = ans;
        }
        int splitArray(int[] nums, int m) {
            memo = new int[nums.length+1][m+1];
            for(int i = 0; i < memo.length; i++){
                Arrays.fill(memo[i], -1);
            }
            return dp(0, nums, m);
        }
    }

    public static void main(String[] args) {

        Solution H = new Solution();
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(H.splitArray(a, 2));

    }
}
