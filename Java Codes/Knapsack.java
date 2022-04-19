package DP;

import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt(), n = scanner.nextInt();


        int[] s = new int[n + 1], v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int[] dp = new int[size + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = size; j >= 0; j--) {
                if (j - s[i] >= 0) dp[j] = Math.max(dp[j], dp[j - s[i]] + v[i]);
            }
        }

        System.out.println(dp[size]);


    }

}
