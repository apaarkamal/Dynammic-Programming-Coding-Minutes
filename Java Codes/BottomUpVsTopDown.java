package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BottomUpVsTopDown {


    public static HashMap<Integer, Integer> mp = new HashMap<>();

// int memo[1e6];

    public static int dp(int n) {
        if (n <= 1) return n;
        if (mp.containsKey(n))
            return mp.get(n);
        int ans = Math.max(dp(n / 2) + dp(n / 3) + dp(n / 4), n);
        mp.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {

        int n;
        Scanner scn = new Scanner(System.in);


//        // top down
//        while ((n = scn.nextInt()) != 0) {
//            // cout << n << '\n';
//
//            // bottom up
//
//            int[] dp = new int[n+1];
//            dp[0] = 0;
//            dp[1] = 1;
//            for (int i = 2; i <= n; i++) {
//                dp[i] = Math.max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
//            }
//            System.out.println(dp(n));
//        }

        while ((n = scn.nextInt()) != 0) {
            System.out.println(dp(n));
        }


    }
}
