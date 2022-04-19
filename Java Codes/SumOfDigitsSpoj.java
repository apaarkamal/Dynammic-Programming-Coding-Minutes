package DP;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfDigitsSpoj {


    static String n;

    static int[][][] memo = new int[10][2][90];

    static int dp(int index, boolean last, int sum) {

        if (index == n.length()) {
            return sum;
        }

        if (memo[index][last ? 1 : 0][sum] != -1) return memo[index][last ? 1 : 0][sum];

        int till = (last ? n.charAt(index) - '0' : 9);
        int ans = 0;

        for (int digits = 0; digits <= till; digits++) {
            ans += dp(index + 1, last && (digits == till), sum + digits);
        }

        return memo[index][last ? 1 : 0][sum] = ans;
    }

    static int solve(int _n) {
        n = String.valueOf(_n);
        for(int i = 0;  i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dp(0, true, 0);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        while (true) {

            int a = scn.nextInt(), b = scn.nextInt();

            if (a == -1 && b == -1) break;

            System.out.println(solve(b) - solve(a - 1));

        }

    }
}
