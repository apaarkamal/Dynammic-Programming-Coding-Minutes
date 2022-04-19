package DP;

import java.util.Scanner;

public class PictureWithKittenEasy {

    static Scanner scn = new Scanner(System.in);

    static final int N = 205;

    static int n, k, m;
    static long[] a = new long[N];

    static long[][] memo = new long[N][N];

    static long dp(int cur, int rem) {
        if (memo[cur][rem] != -1) return memo[cur][rem];
        if (cur == n) {
            if (rem == 0) return 0;
            else return (long) -1e18;
        }
        if (rem == 1) {
            if (cur >= n - k) return a[cur];
            else return (long) -1e18;
        }
        int i;
        long ans = (long) -1e18;
        for (i = cur + 1; i < n && i <= cur + k; i++) {
            ans = Math.max(ans, a[cur] + dp(i, rem - 1));
        }
        return memo[cur][rem] = ans;
    }

    static void solve() {
        int i, j;
        long ans = 0, cnt = 0, sum = 0;
        n = scn.nextInt();
        m = scn.nextInt();
        k = scn.nextInt();
        for (i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        ans = (int) -1e18;
        for (i = 0; i < k; i++) {
            ans = Math.max(ans, dp(i, m));
            // cout << i << " " << dp(i, m) << '\n';
        }
        if (ans < 0) ans = -1;
        System.out.println(ans);
        return ;
    }

    public static void main(String[] args) {
        solve();
    }
// 1879965082
}
