package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlphaCode {


    public static String s;
    public static int[] memo;
    public static int dp(int i) {

        if (i == s.length()) return 1;

        if (memo[i] != -1) return memo[i];

        int ans = 0;
        if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
            ans += dp(i + 1);
        }

        if (i + 1 < s.length() && (s.charAt(i) == '1')) {
            ans += dp(i + 2);
        }

        if (i + 1 < s.length() && (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
            ans += dp(i + 2);
        }

        return memo[i] = ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            s = scn.next();
            if (s.charAt(0) == '0') break;
            memo = new int[s.length()];
            Arrays.fill(memo, -1);
            System.out.println(dp(0));
        }
    }
}
