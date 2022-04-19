package DP;

import java.util.Scanner;

public class MakeFenceGreatAgain {



    static final int N = 300005;

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();

        while (t-- > 0) {
            int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
            n = sn.nextInt();
            int[] a = new int[n], b = new int[n];
            for (i = 0; i < n; i++) {
                a[i] = sn.nextInt();
                b[i] = sn.nextInt();
            }
            long[][] dp = new long[n][3] ;
            for (i = 0; i < n; i++) {
                dp[i][0] = dp[i][1] = dp[i][2] = (long) 1e18;
            }
            dp[0][0] = 0; dp[0][1] = b[0]; dp[0][2] = 2L * b[0];
            for (i = 1; i < n; i++) {
                for (j = 0; j < 3; j++) {
                    for (k = 0; k < 3; k++) {
                        if (a[i - 1] + j != a[i] + k) {
                            dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + (long) k * b[i]);
                        }
                    }
                }
            }
            System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
        }
    }
}
