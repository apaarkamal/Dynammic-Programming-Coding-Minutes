package DP;

import java.util.Arrays;
import java.util.Scanner;

public class OptimalSelection {
    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt(), n = scn.nextInt();
        int[][] price = new int[k][n];
        long[][]  dp = new long[1<<k][n];

        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], (long) 1e18);
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                price[i][j] = scn.nextInt();
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < k; i++) {
            dp[1 << i][0] = price[i][0];
        }

        for (int mask = 0; mask < (1 << k); mask++) {
            for (int d = 1; d < n; d++) {
                // dp[mask][d]
                dp[mask][d] = dp[mask][d - 1];

                for (int x = 0; x < k; x++) {
                    if (((mask >> x) & 1) == 1) {
                        // unset jth bit of mask
                        int new_mask = mask ^ (1 << x);
                        dp[mask][d] = Math.min(dp[mask][d],
                                dp[new_mask][d - 1] + price[x][d]);
                    }
                }
            }
        }

        System.out.println(dp[(1 << k) - 1][n - 1]);


    }
}
