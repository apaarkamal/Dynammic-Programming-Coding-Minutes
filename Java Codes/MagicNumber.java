package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MagicNumber {


    static int m, d, mod = (int) (1e9 + 7);
    static String n;

    // memoisation
    static int[][][] memo = new int[2000][2][2000];

    static int dp(int index, boolean last, int dig_mod) {

        if (index == n.length()) {
            return dig_mod == 0 ? 1 : 0;
        }

        if (memo[index][last ? 1 : 0][dig_mod] != -1) return memo[index][last ? 1 : 0][dig_mod];

        int till = (last ? n.charAt(index) - '0' : 9);
        int ans = 0;

        if (index % 2 == 1) {
            // even position
            if (d <= till) {
                ans += dp(index + 1, last && (d == till), (dig_mod * 10 + d) % m);
                ans %= mod;
            }
        }
        else {
            // odd positions
            for (int digits = 0; digits <= till; digits++) {
                // odd position cannot place d
                if (digits == d) continue;
                ans += dp(index + 1, last && (digits == till), (dig_mod * 10 + digits) % m);
                ans %= mod;
            }
        }
        return memo[index][last ? 1 : 0][dig_mod] = ans;
    }


    static int solve(String _n) {
        n = _n;
        for(int  i = 0 ; i < memo.length; i++){
            for(int j = 0; j < memo[i].length; i++){
                Arrays.fill(memo, -1);
            }
        }
        return dp(0, true, 0);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        m = scn.nextInt();
        d = scn.nextInt();

        StringBuilder a = new StringBuilder(scn.next()),  b = new StringBuilder(scn.next());

        int i = a.length() - 1;

        while (i >= 0 && a.charAt(i) == '0') {
            a.setCharAt(i, '9');
            i--;
        }

        a.setCharAt(i, (char) (a.charAt(i)-1));

        // cout << a << '\n';

        // a = a - 1;
        System.out.println( (solve(b.toString()) - solve(a.toString()) + mod) % mod);





    }
}
