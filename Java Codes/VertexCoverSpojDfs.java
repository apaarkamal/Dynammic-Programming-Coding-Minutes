package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VertexCoverSpojDfs {



    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int[][] dp = new int[N][2];

    static void dfs(int cur, int par) {

        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (int x : gr[cur]) {
            if (x != par) {

                dfs(x, cur);
                // coming back from dfs
                // dp[x] wil be filled

                dp[cur][0] += dp[x][1];
                dp[cur][1] += Math.min(dp[x][0], dp[x][1]);

            }
        }

    }



    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt() ;

        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();

            gr[x].add(y);
            gr[y].add(x);
        }

        dfs(1, 0);

        // the node which is visited in the end
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
