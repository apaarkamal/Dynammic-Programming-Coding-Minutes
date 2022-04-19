package DP;

import java.util.Scanner;

public class CountUnordered {



    // O(n*n*n) after memoisation
    public static int countUnordered(int min, int n) {

        if (n == 0) return 1;

        int ans = 0;
        for (int i = min; i <= n; i++) {
            ans += countUnordered(i, n - i);
        }

        return ans;

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        // O(n*n) solution
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
            }

            for (int k = 0; k <= n; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[n]);

    }
}
