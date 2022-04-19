package DP;

import java.util.Scanner;

public class Prac {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();

        int[] a = new int[n], b= new int[n], c= new int[m], d= new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
            b[i] = scn.nextInt();
        }
        for (int i = 0; i < m; i++) {
            c[i] = scn.nextInt();
            d[i] = scn.nextInt();
        }

        for (int j = 0; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
            }
            System.out.println(cnt);
        }

    }
}
