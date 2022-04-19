package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class DistanceTreeOne {

    final static  int N = (int) (2e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int f[] = new int[N], g[] = new int[N];


    static void dfs_g(int cur, int par) {
        for (int x : gr[cur]) {
            if (x != par) {
                dfs_g(x, cur);
                g[cur] = Math.max(g[cur], g[x] + 1);
            }
        }
    }

    static void dfs_f(int cur, int par, int dis_par) {

        int max_1 = -1, max_2 = -1;

        for (int x : gr[cur]) {
            if (x != par) {
                if (g[x] > max_1) {
                    max_2 = max_1;
                    max_1 = g[x];
                }
                else if (g[x] > max_2)
                    max_2 = g[x];
            }
        }

        for (int x : gr[cur]) {
            if (x != par) {

                int new_dis_par = dis_par;

                // for (auto y : gr[cur]) {
                // 	if (y != par && y != x) {
                // 		new_dis_par = max(g[y], new_dis_par);
                // 	}
                // }

                if (g[x] == max_1)
                    new_dis_par = Math.max(new_dis_par, max_2);
                else
                    new_dis_par = Math.max(new_dis_par, max_1);

                dfs_f(x, cur, new_dis_par + 1);

                // for any node in the subtree
                f[cur] = Math.max(f[cur], g[x] + 1);
            }
        }

        // for any node in the supertree
        // supertree = compliment of subtree
        f[cur] = Math.max(f[cur], dis_par + 1);

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            gr[x].add(y);
            gr[y].add(x);
        }

        dfs_g(1, -1);


        // O(N)
        dfs_f(1, -1, -1);

        for (int i = 1; i <= n; i++) {
            System.out.println(f[i]);
        }


    }
}
