package DP;

import java.util.Arrays;
import java.util.Scanner;

public class New {


    static final int N = 16;
    static int[][] a = new int[N][N];
    static int n;
    static int[] memo = new int[(1 << N)];

    static int dp(int mask) {
        if (memo[mask] != -1) return memo[mask];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (((mask >> i) & 1) == 1) continue;
                if (((mask >> j) & 1) == 1) continue;
                ans = Math.max(ans, dp(mask ^ (1 << i) ^ (1 << j)) + a[i][j]);
            }
        }
        return memo[mask] = ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        Arrays.fill(memo, -1);
        System.out.println(dp(0));
    }
}
