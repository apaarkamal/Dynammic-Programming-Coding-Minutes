package DP;

import java.util.Arrays;
import java.util.Scanner;

public class OrderedPair {


    static int[] memo = new int[1000];

    // O(n*n)
    static int countWaysOrdered(int n) {
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];
        int ans = 0;

        // for (i....n)
        for (int i = 1; i <= n; i++) {
            ans += countWaysOrdered(n - i);
        }

        return memo[n] = ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Arrays.fill(memo, -1);

        System.out.println(countWaysOrdered(n));

        // bottom up approach
        // O(n)
        int sum = 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = sum + 1;
            sum += dp[i];
        }

        System.out.println(dp[n]);

        // 2^(n-1)
        // O(1)
        System.out.println(Math.pow(2, n - 1));







    }
}
