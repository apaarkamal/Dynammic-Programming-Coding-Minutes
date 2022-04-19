package DP;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ToDoDigitDp {



    static final int N = 100005;

    static String s;
    static int[][][] dp = new int[2001][2][2000];
    static int m, mod = (int) (1e9 + 7);

    static int work(int pos, boolean last, int modpro) {
        if (pos == s.length()) {
            if (modpro == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[pos][last ? 1 : 0][modpro] != -1) {
            return dp[pos][last? 1 : 0][modpro];
        }
        int till = (last ? s.charAt(pos) - '0' : 9);
        int ans = 0;
        for (int i = 0; i <= till; i++) {
            ans += work(pos + 1, last && (i == s.charAt(pos) - '0'), (modpro * 10 + i) % m);
            ans %= mod;
        }
        return dp[pos][last ? 1: 0][modpro] = ans % mod;
    }

    static int solve(int n) {
        s = String.valueOf(n);

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++)
                Arrays.fill(dp[i][j], -1);
        }
        int ans = work(0, true, 0);
        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0)
        {
            int i = scn.nextInt(), j=scn.nextInt();
            m=scn.nextInt();
            System.out.println(solve(j) - solve(i - 1));
        }
    }
}
