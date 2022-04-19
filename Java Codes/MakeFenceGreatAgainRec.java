package DP;

import java.util.Scanner;

public class MakeFenceGreatAgainRec {



    static final int N = 300005;
    static int n;
    static int[] a = new int[N], b = new int[N];

    static long[][] dp = new long[N][3] ;


    static long solve(int pos, int prev, int state) {
        if (pos == n) return 0;
        if (dp[pos][state] != -1) return dp[pos][state];
        long ans = (int) 1e18;
        if (a[pos] != prev) {
            ans = Math.min(ans, solve(pos + 1, a[pos], 0));
        }
        if (a[pos] + 1 != prev) {
            ans =  Math.min(ans, b[pos] + solve(pos + 1, a[pos] + 1, 1));
        }
        if (a[pos] + 2 != prev) {
            ans =  Math.min(ans, 2L * b[pos] + solve(pos + 1, a[pos] + 2, 2));
        }
        return dp[pos][state] = ans;
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();

        while (t-- > 0) {
            int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
            n = sn.nextInt();

            for (i = 0; i < n; i++) {
                a[i] = sn.nextInt();
                b[i] = sn.nextInt();
            }


            for (i = 0; i <= n; i++) {
                for (j = 0; j < 3; j++) {
                    dp[i][j] = -1;
                }
            }
            System.out.println( Math.min(solve(0, -1, 0), Math.min(solve(0, -1, 1), solve(0, -1, 2))));
        }
    }
}
