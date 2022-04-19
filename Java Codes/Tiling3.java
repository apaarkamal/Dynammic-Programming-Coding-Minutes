package DP;

import java.util.Scanner;

public class Tiling3 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] f = new int[n + 1], g = new int[n + 1];
        f[0] = g[0] = 0;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + 2 * g[i - 2];
            g[i] = g[i - 1] + f[i - 1];
        }

        System.out.println(f[n]);


    }
}
