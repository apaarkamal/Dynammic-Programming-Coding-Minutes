package DP;

import java.util.Scanner;

public class Spoj3Tile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) != 0) {
            if (n == -1) break;

            int[] f = new int[n + 1], g = new int[n + 1];

            f[0] = g[0] = 1;
            f[1] = g[1] = 0;

            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 2] + 2 * g[i - 2];
                g[i] = g[i - 2] + f[i];
            }

            System.out.println(f[n]);
        }
    }
}
