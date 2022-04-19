package DP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsecutiveSequence {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        HashMap<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dp.put(a[i], dp.getOrDefault(a[i]-1, 0) + 1);
        }

        int k = 0, start, end = 0;
        for (Map.Entry<Integer, Integer> x : dp.entrySet()) {
            // x.first
            if (k < x.getValue()) end = x.getKey();
            k = Math.max(k, x.getValue());
        }
        System.out.println(k);

        start = end - k + 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == start) {
                // zero-based inedxing
                System.out.println(i+1);
                start++;
            }
            if (start == end + 1) break;
        }

    }
}
