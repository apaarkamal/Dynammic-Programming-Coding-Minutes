package DP;

import java.util.Scanner;

public class SUPW {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] a = new int[n], dp = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3]) + a[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        System.out.println(Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]));





    }
}
