package DP;

import java.util.Scanner;

public class O_N_KnapSack {


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt(), n = scn.nextInt();
        int[] s = new int[n + 1], v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            s[i] = scn.nextInt();
            v[i] = scn.nextInt();
        }

        int[] dp = new int[size + 1];



        for (int i = 1; i <= n; i++) {

            // 0/N knapsack
            for (int j = 0; j <= size; j++) {
                if (j - s[i] >= 0) dp[j] = Math.max(dp[j], dp[j - s[i]] + v[i]);
            }
        }

        System.out.println(dp[size]);


    }
}
