package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumStepsToReachOne {


    final static int N = (int) 1e5;

    static int[] memo = new int[N];

    static int dp(int n)  {
        if (n == 1) return 0;

        int ans = memo[n];

        if (ans != -1) return ans;
        memo[n] = Integer.MAX_VALUE;
        ans = memo[n];

        if (n % 2 == 0) {
            ans = Math.min(ans, dp(n / 2));
        }
        if (n % 3 == 0) {
            ans = Math.min(ans, dp(n / 3));
        }
        ans = Math.min(ans, dp(n - 1));
        ans += 1;

        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Arrays.fill(memo, -1);

        System.out.println(dp(n));

    }
}
