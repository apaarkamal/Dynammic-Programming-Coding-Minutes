package DP;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocks {



    static class Solution {
        public int memo[][][] = new int[1001][2][101];
        int dp(int i, int buy, int k, int[] prices) {
            if (i == prices.length) return 0;
            if (memo[i][buy][k] != -1) return memo[i][buy][k];
            // dont buy/sell
            int ans = dp(i + 1, buy, k, prices);
            if (k == 0) return 0;
            // buy
            if (buy == 1) {
                ans = Math.max(ans, -prices[i] + dp(i + 1, 0, k, prices));
            }
            else {
                ans = Math.max(ans, prices[i] + dp(i + 1, 1, k - 1, prices));
            }

            return memo[i][buy][k] = ans;
        }
        int maxProfit(int k, int[] prices) {
            for(int i = 0; i < memo.length; i++){
                for(int j = 0; j < memo[0].length; j++){
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dp(0, 1, k, prices);
        }
    };

    public static void main(String[] args) {
        Solution H = new Solution();
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(H.maxProfit(2, prices));
    }
}
