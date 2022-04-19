package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class Diameter {

    final static  int N = (int) (2e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int f[] = new int[N], g[] = new int[N];


    public static void dfs(int cur, int par) {
        int max_1 = 0, max_2 = 0;

        for (int x : gr[cur]) {
            if (x != par) {
                dfs(x, cur);

                // g for the cur node
                g[cur] = Math.max(g[x] + 1, g[cur]);
                f[cur] = Math.max(f[x], f[cur]);

                // max 2 values of g[x]
                if (g[x] + 1 > max_1) {
                    max_2 = max_1;
                    max_1 = g[x] + 1;
                }
                else if (g[x] + 1 > max_2) {
                    max_2 = g[x] + 1;
                }
            }
        }

        f[cur] = Math.max(f[cur], max_1 + max_2);

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            gr[x].add(y);
            gr[y].add(x);
        }

        dfs(1, -1);

        System.out.println(f[1]);

    }
}
