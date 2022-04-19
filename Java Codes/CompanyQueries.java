package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyQueries {



    public static final int N = 200001, M = 20;

    public static ArrayList<Integer>[] gr = new ArrayList[N];
    public static int[][] Par = new int[N][M];

    public static void dfs(int cur, int par) {

        Par[cur][0] = par;
        for (int j = 1; j < M; j++) {
            Par[cur][j] = Par[Par[cur][j - 1]][j - 1];
        }

        for (int x : gr[cur]) {
            if (x != par) {
                dfs(x, cur);
            }
        }
    }

    public static int giveKthPar(int x, int k) {

        int cur = x;
        for (int j = 0; j < M; j++) {
            if (((k >> j) & 1) != 0) {
                cur = Par[cur][j];
            }
        }

        if (cur == 0) cur = -1;
        return cur;

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(), q = scn.nextInt();

        for (int i = 2; i <= n; i++) {
            int par = scn.nextInt();
            gr[i].add(par);
            gr[par].add(i);
        }

        dfs(1, 0);

//         for (int i = 1; i <= n; i++) {
//         	for (int j = 0; j < 3; j++) {
//                System.out.println(i + " " + Math.pow(2, j) + " " + Par[i][j]);
//         	}
//         }

        while (q-- > 0) {
            int x = scn.nextInt(), k = scn.nextInt();
            System.out.println(giveKthPar(x, k));
        }

    }
}
