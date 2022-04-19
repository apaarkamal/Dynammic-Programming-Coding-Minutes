package DP;

import java.util.Scanner;

public class SPP {



    static final int N = 100005;

    static int mod;

    static final int M = 20;
    static int sz;

    static class Mat {
        int[][] m = new int[M][M];

        void eye()
        {
            for (int i = 0; i < sz; i++)
                m[i][i] = 1;
        }

        Mat multiply( Mat a) {
            Mat r = new Mat();
            for (int i = 0; i < sz; i++)
                for (int j = 0; j < sz; j++)
                    for (int k = 0; k < sz; k++)
                        r.m[i][j] = (r.m[i][j] + m[i][k] * a.m[k][j]) % mod;
            return r;
        }
    }

    static int solve(int b[], int c[], int e, int n)
    {
        Mat r = new Mat(), a = new Mat();
        r.eye();
        a.m[0][0] = 1;
        for (int i = 1; i < sz; i++) {
            a.m[0][i] = c[i - 1];
            a.m[1][i] = c[i - 1];
        }
        for (int i = 2; i < sz; i++) {
            a.m[i][i - 1] = 1;
        }
        while (e != 0) {
            if ((e & 1) == 1)
                r = r.multiply(a);
            a = a.multiply(a);
            e >>= 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += b[i];
        }
        ans = r.m[0][0] * ans;
        ans %= mod;
        for (int i = 1; i < sz; i++) {
            ans += r.m[0][i] * b[n - i];
            ans %= mod;
        }
        return ans;
    }

    static int give(int k, int b[], int c[], int n) {
        if (k < n) {
            int ans = 0;
            for (int i = 0; i <= k; i++) {
                ans += b[i];
                ans %= mod;
            }
            return ans;
        }
        else {
            return solve(b, c, k - n + 1, n) ;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
            n = scanner.nextInt();
            sz = n + 1;
            int[] b = new int[n], c = new int[n];
            for (i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            for (i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            int l, r;
            l = scanner.nextInt();
            r = scanner.nextInt();
            mod = scanner.nextInt();

            System.out.println((give(r, b, c, n) - give(l - 1, b, c, n) + mod) % mod);
        }
    }
}
