package DP;

import java.util.Scanner;

public class LIS {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int a[] = new int[n];
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
            dp[i] = 1;
        }

        // O(n*n)
        for (int i = 0; i < n; i++) {

            // dp[i] -> lis if it ends on ith index
            for (int j = 0; j < i; j++) {

                if (a[j] <= a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }

        int lis = 1;

        for (int i = 0; i < n; i++) {
            // cout << a[i] << " " << dp[i] << '\n';
            lis = Math.max(lis, dp[i]);
        }

        System.out.println(lis);
    }
}
