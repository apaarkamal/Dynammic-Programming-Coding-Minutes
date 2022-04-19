package DP;

import java.util.Arrays;
import java.util.Scanner;

public class LIS_todo {


    static String n, m;

    static int[][][][][] memo1 = new int[11][2][2][11][11];

    static int combination(int index, boolean first, boolean last, int prev, int len) {

        // cout << prev << " " << len << '\n';

        if (index == n.length()) {
            if (len == 0) return 1;
            return 0;
        }

        if (memo1[index][first ? 1 : 0][last ? 1 : 0][prev][len] != -1) {
            return memo1[index][first ? 1 : 0][last ? 1 : 0][prev][len];
        }

        int start = (first ? n.charAt(index) - '0' : 0);
        int till = (last ? m.charAt(index) - '0' : 9);
        int ans = 0;


        for (int digits = start; digits <= till; digits++) {
            ans += combination(index + 1, first && (digits == start), last && (digits == till), prev, len);
            if (digits > prev) {
                ans += combination(index + 1, first && (digits == start), last && (digits == till), digits, len - 1);
            }
        }

        return memo1[index][first ? 1 : 0][last ? 1 : 0][prev][len] = ans;

    }

    static int solver(int _n, int _m, int len) {
        n = String.valueOf(_n);
        m = String.valueOf(_m);
        int diff = m.length() - n.length();
        while (diff-- > 0) {
            n = "0" + n;
        }
        for(int i = 0; i < memo1.length; i++){
            for(int ii = 0; ii < memo1[i].length; ii++){
                for(int iii = 0 ; iii < memo1[i][ii].length; iii++){
                    for(int i4 = 0; i4 < memo1[i][ii][iii].length; i4++){
                        Arrays.fill(memo1[i][ii][iii][i4], -1);
                    }
                }
            }
        }
        return combination(0, true, true, 0, len);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {

            int a = scn.nextInt(), b = scn.nextInt();

            for (int len = 10; len >= 0; len--) {
                if (solver(a, b, len) != 0) {
                    System.out.println("Case " + i + ": " + len + " " + solver(a, b, len));
                    break;
                }
            }

        }


    }
}
