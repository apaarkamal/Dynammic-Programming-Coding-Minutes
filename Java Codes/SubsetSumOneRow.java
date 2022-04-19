package DP;

import java.util.Scanner;

public class SubsetSumOneRow {

    public static void main(String[] args) {



        Scanner scn = new Scanner(System.in);

        int sum = scn.nextInt(), n = scn.nextInt();

        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }

        boolean[] dp = new boolean[sum + 1];
        // one row dp[j]

        dp[0] = true;

        for (int j = 1; j <= sum; j++) {
            dp[j] = false;
        }

        // O(n*sum)
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {

                if (j - a[i] >= 0) {
                    dp[j] |= dp[j - a[i]];
                }

            }

        }
        System.out.println(dp[sum]);
    }
}
