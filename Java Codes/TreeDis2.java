package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeDis2 {



    static final int N = (int) (2e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int[] g = new int[N], h = new int[N], f = new int[N];
    static int n;

    static void dfs_g(int cur, int par) {
        for (int x : gr[cur]) {
            if (x != par) {
                dfs_g(x, cur);
                g[cur] += g[x] + h[x];
                h[cur] += h[x];
            }
        }
        h[cur] += 1;
    }

    static void dfs_f(int cur, int par, int sum_par) {

        for (int x : gr[cur]) {
            if (x != par) {

                int new_sum_par = sum_par + (n - h[cur]);

                int current_child_values = g[x] + h[x];

                new_sum_par += (g[cur] - current_child_values);

                dfs_f(x, cur, new_sum_par);

                // for any node in the subtree
                f[cur] += (g[x] + h[x]);
            }
        }

        // for any node in the supertree
        // supertree = compliment of subtree
        f[cur] += sum_par + (n - h[cur]);

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt() ;

        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();

            gr[x].add(y);
            gr[y].add(x);
        }

        // O(N)
        dfs_g(1, -1);

        // O(N)
        dfs_f(1, -1, 0);

        for (int i = 1; i <= n; i++) {
            System.out.println(f[i]);
        }

    }
}
