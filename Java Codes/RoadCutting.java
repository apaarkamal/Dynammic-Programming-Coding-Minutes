package DP;

import java.util.Arrays;
import java.util.Scanner;

public class RoadCutting {


    static int[] memo = new int[100000];

    // Space Complexity -> O(n)
// Time complexity -> O(n*n)
    static int rodCutting(int n, int prices[]) {
        if (n == 0) return 0;

        if (memo[n] != -1) return memo[n];

        // O(n) extra work inside each state
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, prices[i] + rodCutting(n - i, prices));
        }

        return memo[n] = ans;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prices[i] = scanner.nextInt();
        }

        Arrays.fill(memo, -1);
        System.out.println(rodCutting(n, prices));






    }
}
