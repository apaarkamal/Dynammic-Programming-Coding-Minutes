package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class VertexCoverSpoj {


    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int[][] memo = new int[N][2];

    static int dp(int cur, int take, int par) {

        if (memo[cur][take] != -1) return memo[cur][take];

        int ans = take ;
        for (int x : gr[cur]) {
            if (x != par) {
                // x is only the child vertex
                if (take == 1) {
                    ans += Math.min(dp(x, 0, cur),dp(x, 1, cur));
                }
                else {
                    ans += dp(x, 1, cur);
                }
            }
        }
        return memo[cur][take] = ans;
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        // corrected n-1 as edge count
        for (int i = 0; i < n - 1; i++) {
            int x = sn.nextInt(), y = sn.nextInt();

            gr[x].add(y);
            gr[y].add(x);
        }

        for(int i = 0 ; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println( Math.min(dp(1, 0, -1), dp(1, 1, -1)));
    }
}
