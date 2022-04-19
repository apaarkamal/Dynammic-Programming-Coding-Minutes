package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class HamiltonPathBottomUp {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<Integer>[] gr = new ArrayList[n];
        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            gr[x].add(y);
            gr[y].add(x);
        }


        int[][] dp = new int[n][1 << n];


        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 1;
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            for (int cur = 0; cur < n; cur++) {
                if (dp[cur][mask] != 0) {
                    for (int x : gr[cur]) {
                        if (((mask >> x) & 1) == 0) {
                            dp[x][mask | (1 << x)] = 1;
                        }
                    }
                }
            }
        }

        boolean ans = false;

        for (int i = 0; i < n; i++) {
            ans |= (dp[i][(1 << n) - 1] == 1);
        }

        System.out.println(ans);
    }

}
