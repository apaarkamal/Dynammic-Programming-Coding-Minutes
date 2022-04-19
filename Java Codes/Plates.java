package DP;

import java.util.Scanner;

public class Plates {



    static Scanner scn = new Scanner(System.in);
    static int solve() {
        int n = scn.nextInt(), k = scn.nextInt(), p = scn.nextInt();

        int[][] a = new int[n+1][k+1];
        int[][] pref = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                a[i][j] = scn.nextInt();
                pref[i][j] = pref[i][j - 1] + a[i][j];
            }
        }

        int[][] dp = new int[n+1][p+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                // dp[i][j]
                // pick j plates from first i rows
                for (int x = 0; x <= Math.min(k, j); x++) {
                    dp[i][j] = Math.max(dp[i][j], pref[i][x] +
                            dp[i - 1][j - x]);
                }
            }
        }
        return dp[n][p];
    }

    public static void main(String[] args) {

        int t, z = 1;
        t = scn.nextInt();
        while (z <= t) {
            System.out.println("Case #" + z++ + ": " + solve());
        }

    }
}
