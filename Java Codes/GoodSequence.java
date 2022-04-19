package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GoodSequence {



    static final int N = (int) (1e5 + 1);

    static int[] dp_prime = new int[N];

    // O(sqrt(n))
    static ArrayList<Integer>  give_prime_divisors(int n) {
        ArrayList<Integer> div = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                div.add(i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) div.add(n);
        return div;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }


        for (int i = 0; i < n; i++) {
            ArrayList<Integer> prime_div = give_prime_divisors(a[i]);

            int best_ending = 0;
            for (int x : prime_div) {
                best_ending = Math.max(best_ending, dp_prime[x]);
            }

            for (int x : prime_div) {
                dp_prime[x] = best_ending + 1;
            }
        }

        System.out.println(maxElement(dp_prime));


    }

    private static int maxElement(int[] dp_prime) {
        int ans = Integer.MIN_VALUE;
        for(int x: dp_prime){
            ans = Math.max(ans, x);
        }
        return  ans;
    }
}
