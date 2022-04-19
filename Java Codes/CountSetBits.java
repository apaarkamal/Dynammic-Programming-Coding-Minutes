package DP;

public class CountSetBits {
    public static void main(String[] args) {

        int n = 10;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + (i % 2);
            System.out.println(dp[i]);
        }
        // O(n)


    }
}
