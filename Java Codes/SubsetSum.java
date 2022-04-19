package DP;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {



    final static int N = 1000;

    static int[] a = new int[N];
    static int n;
    static int[][] memo;

    static boolean subsetSum(int index, int sum) {

        // no elements left for sum
        if (index == -1) return (sum == 0);

        if (memo[index][sum] != -1) return memo[index][sum] == 1;

        boolean ans = false;
        // include a[index] in sum
        if (sum >= a[index]) {
            ans |= subsetSum(index - 1, sum - a[index]);
        }
        // exclude a[index]
        ans |= subsetSum(index - 1, sum);

        memo[index][sum] = ans ? 1 : 0;
        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int sum = scn.nextInt();
        n = scn.nextInt();


        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        memo = new int[n][sum+1];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println(subsetSum(n - 1, sum));
    }
}
