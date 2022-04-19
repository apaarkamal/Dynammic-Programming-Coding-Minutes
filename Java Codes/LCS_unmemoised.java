package DP;

import java.util.Scanner;

public class LCS_unmemoised {



    static String s, t;

    static int lcs(int i, int j) {
        if (i == s.length() && j == t.length()) return 0;
        if (i == s.length()) return 0;
        if (j == t.length()) return 0;

        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + lcs(i + 1, j + 1);
        }
        else {
            ans = Math.max(lcs(i, j + 1), lcs(i + 1, j));
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        s = scn.next();
        t = scn.next();

        System.out.println(lcs(0,0));

    }
}
