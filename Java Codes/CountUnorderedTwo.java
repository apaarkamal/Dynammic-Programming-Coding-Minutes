package DP;

import java.util.Scanner;

public class CountUnorderedTwo {



    // O(n*n*n) after memoisation
    public static int countUnordered(int min, int n) {

        if (n == 0) return 1;

        int ans = 0;
        for (int i = min; i <= n; i++) {
            ans += countUnordered(i, n - i);
        }

        return ans;

    }

    // O(n*n)
    public static int countUnordered2(int min, int n) {

        // memoise

        if (n == 0) return 1;
        if (min > n) return 0;
        if (min == n) return 1;

        // included in the partition
        int ans = countUnordered2(min, n - min)
                // exluded in the partition
                + countUnordered2(min + 1, n);

        return ans;

    }



    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        for (int i = 0; i <= 20; i++) {
            System.out.println(countUnordered(1, i));
        }
        for (int i = 0; i <= 20; i++) {
            System.out.println(countUnordered2(1, i));
        }

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
