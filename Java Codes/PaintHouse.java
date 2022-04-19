package DP;

import java.util.Scanner;

public class PaintHouse {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] cost = new int[3][n];

        for (int i = 0; i < n; i++) {
            cost[0][i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[1][i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[2][i] = scn.nextInt();
        }

        int[][] dp = new int[3][n];

        dp[0][0] = cost[0][0];
        dp[1][0] = cost[1][0];
        dp[2][0] = cost[2][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[1][j] = dp[2][j] = Integer.MAX_VALUE;

            // for (int i = 0; i < 3; i++) {
            // 	for (int i_ = 0; i_ < 3; i_++) {
            // 		if (i != i_) {
            // 			dp[i][j] = min(dp[i_][j - 1] + cost[i][j]);
            // 		}
            // 	}
            // }

            dp[0][j] = Math.min(dp[2][j - 1], dp[1][j - 1]) + cost[0][j];
            dp[1][j] = Math.min(dp[0][j - 1], dp[2][j - 1]) + cost[1][j];
            dp[2][j] = Math.min(dp[0][j - 1], dp[1][j - 1]) + cost[2][j];
        }

        System.out.println(Math.min(dp[0][n-1], Math.min(dp[1][n-1],dp[2][n-1])));

    }
}
