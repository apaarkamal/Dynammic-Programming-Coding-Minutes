package DP;

import java.util.Scanner;

public class SubsetSumTabulation {
    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);

        int sum = scn.nextInt(), n = scn.nextInt();

        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }

        boolean[][] dp = new boolean[n+1][sum + 1];

        dp[0][0] = true;

        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                // exlcusion
                dp[i][j] = dp[i - 1][j];

                // inclusion
                if (j - a[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - a[i]];
                }
            }
        }

        // cout << dp[n][sum];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
