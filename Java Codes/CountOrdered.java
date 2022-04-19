package DP;

import java.util.Scanner;

public class CountOrdered {


    public static int[] memo = new int[1000];
    public static int countOrdered(int n) {
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += countOrdered(n - i);
        }
        return memo[n] = ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        // O(n*n) solution
        int[] dp = new int[n + 1];
        dp[0] = 1;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum + 1;
            sum += dp[i];
        }

        System.out.println(dp[n]);

        // O(1)
        System.out.println(Math.pow(2, n-1));


    }
}
