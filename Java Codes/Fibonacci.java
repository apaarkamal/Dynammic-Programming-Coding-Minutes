package DP;

import java.util.Scanner;

public class Fibonacci {

    static final int mod = (int) (1e9 + 7);
    static final int sz = 2;

    static class Mat {
        int[][] m = new int[sz][sz];

        void identity() {
            for (int i = 0; i < sz; i++) {
                m[i][i] = 1;
            }
        }

        Mat multiply (Mat a) {
            Mat res = new Mat();
            for (int i = 0; i < sz; i++) {
                for (int j = 0; j < sz; j++) {
                    for (int k = 0; k < sz; k++) {
                        res.m[i][j] += m[i][k] * a.m[k][j];
                        res.m[i][j] %= mod;
                    }
                }
            }
            return res;
        }
    }


    static int Fib(int n) {
        if (n == 0) return 0;
        Mat res = new Mat();
        res.identity();
        Mat T = new Mat();
        T.m[0][0] = T.m[0][1] = T.m[1][0] = 1;

        if (n <= 2) return 1;
        n -= 2;

        // log(n)
        while (n > 0) {
            if ((n & 1) != 0) res = res.multiply(T);
            T = T.multiply(T);
            n /= 2;
        }

        return (res.m[0][0] + res.m[0][1]) % mod;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt(), m = scn.nextInt();
            System.out.println((Fib(m+2) - Fib(n+1) + mod) % mod);
        }


    }

}
