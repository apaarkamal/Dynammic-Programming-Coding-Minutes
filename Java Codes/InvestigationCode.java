package DP;

import java.util.Arrays;
import java.util.Scanner;

public class InvestigationCode {


    static String n;
    static int a, b, k;

    // 10 * 2 * 100 * 100 states
    static int[][][][] memo = new int[10][2][90][90];

    static int solver(int index, boolean last, int sum_mod, int sum_dig_mod) {

        if (index == n.length()) {
            if (sum_mod == 0 && sum_dig_mod == 0) {
                return 1;
            }
            return 0;
        }

        if (memo[index][last ? 1 : 0][sum_mod][sum_dig_mod] != -1) {
            return memo[index][last ? 1 : 0][sum_mod][sum_dig_mod];
        }

        int till = (last ? n.charAt(index) - '0' : 9);
        int ans = 0;

        for (int digits = 0; digits <= till; digits++) {
            ans += solver(index + 1, last && (digits == till),
                    (sum_mod * 10 + digits) % k,
                    (sum_dig_mod + digits) % k);
        }

        return memo[index][last ? 1 : 0][sum_mod][sum_dig_mod] = ans;

    }

    static int f(int _n) {
        if (k > 90) return 0;
        n = String.valueOf(_n);
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[i].length; j++){
                for(int ij = 0; ij < memo[i][j].length; ij++){
                    Arrays.fill(memo[i][j][ij], -1);
                }
            }
        }
        return solver(0, true, 0, 0);
    }

    public static void main(String[] args) {

             // dont forget to add case ?
        // Case 1:
        // Case 2:

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            a = scn.nextInt();
            b = scn.nextInt();
            k = scn.nextInt();
            System.out.println(f(b) - f(a-1));

        }

    }
}
