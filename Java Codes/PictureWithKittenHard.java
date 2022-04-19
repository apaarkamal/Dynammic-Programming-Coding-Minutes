package DP;

import java.util.Scanner;

public class PictureWithKittenHard {



    final static int N = 5005;

    static int n, k, m;
    static int[] a = new int[N];
    static Scanner scn = new Scanner(System.in);

    static class sparse_table {
        long[][] mat;// 0 based indexing
        int n, m; // size and log
        int[] p2;//log2
        void init(int _n, int _m) {
            n = _n; m = _m;
            mat = new long[n][m];
            p2 = new int[n+1];

            for (int i = 2; i <= n; i++) p2[i] = p2[i / 2] + 1;
        }
        void build(long a[]) {
            int i, j;
            for (i = 0; i < n; i++) mat[i][0] = a[i];
            for (j = 1; j < m; j++) {
                for (i = 0; i + (1 << j) <= n; i++) {
                    mat[i][j] = Math.max(mat[i][j - 1], mat[i + (1 << (j - 1))][j - 1]);
                }
            }
        }
        long query(int l, int r) {
            int pw = p2[r - l];
            return Math.max(mat[l][pw], mat[r - (1 << pw) + 1][pw]);
        }
    }

    static sparse_table table = new sparse_table();

    static void solve() {
        int i, j ;
        long ans = 0, cnt = 0, sum = 0;
        n = scn.nextInt();
        k = scn.nextInt();
        m = scn.nextInt();

        for (i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        long[] dp = new long[n];
        for (i = 0; i < n; i++) {
            if (i >= n - k) dp[i] = a[i];
            else dp[i] = (long) -1e16;
        }
        table.init(n, 13);
        for (j = 2; j <= m; j++) {
            table.build(dp);
            for (i = 0; i < n - 1; i++) {
                dp[i] = a[i] + table.query(i + 1, Math.min(i + k, n - 1));
            }
            dp[n - 1] = (long) -1e16;
        }
        ans = (long) -1e16;
        for (i = 0; i < k; i++) {
            ans = Math.max(ans, dp[i]);
        }
        if (ans < 0) ans = -1;
        System.out.println(ans);
        return ;
    }

    public static void main(String[] args) {
        solve();
    }
}
