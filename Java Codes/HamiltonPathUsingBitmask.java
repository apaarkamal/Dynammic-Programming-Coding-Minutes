package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HamiltonPathUsingBitmask {

    final static int N = 10;

    static ArrayList<Integer>[] gr = new ArrayList[N];

    static int[][] memo = new int[N][1 << N];

    static int n, m;

    static boolean dp(int cur, int mask) {
        if (mask == (1 << n) - 1) {
            return true;
        }

        if (memo[cur][mask] != -1) {
            return memo[cur][mask] != 0;
        }

        boolean ans = false;
        for (int x : gr[cur]) {
            // xth bit of mask is set or not
            if (((mask >> x) & 1) == 0) {
                ans |= dp(x, mask | (1 << x));
            }
        }

        memo[cur][mask] = ans ? 1 : 0;

        return ans;
    }


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        for (int i = 0; i < m; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            gr[x].add(y);
            gr[y].add(x);
        }
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);

        }

        boolean hamiltonian_path = false;

        for (int i = 0; i < n; i++) {
            hamiltonian_path |= dp(i, (1 << i));
        }


        System.out.println(hamiltonian_path);


    }



}
