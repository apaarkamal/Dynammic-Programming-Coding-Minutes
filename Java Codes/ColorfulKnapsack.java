package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class ColorfulKnapsack {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        int j, k, n, m, ans = 0, cnt = 0, sum = 0;
        j = scn.nextInt();
        n = scn.nextInt();
        m = scn.nextInt();

        int[][] dp = new int[105][10005];
        ArrayList<Integer>[] v = new ArrayList[105];
        int[] a = new int[105];
        for (int i = 0; i < j; i++) {
            a[i] = scn.nextInt();
        }
        for (int i = 0; i < j; i++) {
            int x = scn.nextInt();
            v[x].add(a[i]);
        }
        for (int x : v[1]) {
            dp[1][x]++;
        }
        for (int i = 1; i < n; i++) {
            for (j = 0; j <= m; j++) {
                if (dp[i][j] != 0) {
                    for (int x : v[i + 1]) {
                        if (j + x <= m) {
                            dp[i + 1][j + x]++;
                        }
                    }
                }
            }
        }
        for (j = 1; j <= m; j++) {
            if (dp[n][j] != 0) {
                ans = Math.max(ans, j);
            }
        }
        if (ans == 0) System.out.println(-1);
        else System.out.println(m-ans);

    }
}
