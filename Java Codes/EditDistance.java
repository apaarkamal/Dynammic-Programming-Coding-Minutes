package DP;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {



    static String a, b;

    static int[][] memo = new int[2000][2000];

    static int edit_distance(int i, int j) {
        if (i == a.length() && j == b.length()) return 0;
        if (i == a.length()) return (b.length() - j);
        if (j == b.length()) return (a.length() - i);

        if (memo[i][j] != -1) return memo[i][j];

        // i<a.size() && j<b.size()
        int ans;
        if (a.charAt(i) != b.charAt(j)) {
            ans = 1 + Math.min(edit_distance(i + 1, j), Math.min(edit_distance(i, j + 1), edit_distance(i + 1, j + 1)));
        }
        else {
            ans = edit_distance(i + 1, j + 1);
        }
        return memo[i][j] = ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            a = scn.next();
            b = scn.next();

            for(int i = 0; i < 2000; i++){
                Arrays.fill(memo[i], -1);
            }

            System.out.println(edit_distance(0,0));
        }

    }
}
