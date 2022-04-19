package DP;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {


    static class Solution {
        int[] memo;
        int dp(int i, int[] arr, int k) {
            if (i == arr.length) return 0;
            if (memo[i] != -1) return memo[i];
            int ans = 0, mx = 0;
            for (int j = i; j < Math.min((int)arr.length, i + k); j++) {
                mx = Math.max(mx, arr[j]);
                ans = Math.max(ans, mx * (j - i + 1) + dp(j + 1, arr, k));
            }
            return memo[i] = ans;
        }

        int maxSumAfterPartitioning(int[] arr, int k) {
            Arrays.fill(arr, -1);
            return dp(0, arr, k);
        }
    }

    public static void main(String[] args) {


        Solution H = new Solution();
        int[] a = {1, 15, 7, 9, 2, 5, 10};

        System.out.println(H.maxSumAfterPartitioning(a, 3));
    }
}
