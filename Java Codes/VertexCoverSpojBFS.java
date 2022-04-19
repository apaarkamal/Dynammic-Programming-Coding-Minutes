package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VertexCoverSpojBFS {


    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int[][] dp = new int[N][2];

    static int[] vis = new int[N];

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), root = -1;

        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();

            gr[x].add(y);
            gr[y].add(x);
        }

        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (gr[i].size() == 1) Q.add(i);
        }

        while (!Q.isEmpty()) {

            int cur = Q.poll();

            vis[cur] = 1;
            root = cur;

            dp[cur][0] = 0;
            dp[cur][1] = 1;

            for (int x : gr[cur]) {
                if (vis[x] == 1) {
                    // child nodes
                    dp[cur][0] += dp[x][1];
                    dp[cur][1] += Math.min(dp[x][0], dp[x][1]);
                }
                else {
                    // parent node
                    Q.add(x);
                }
            }

        }
        // the node which is visited in the end
        System.out.println(Math.min(dp[root][0], dp[root][1]));
    }
}
