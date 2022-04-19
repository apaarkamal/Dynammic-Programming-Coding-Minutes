package DP;

import java.util.BitSet;
import java.util.Scanner;

public class SubsetSumBitset {

    public static void shiftLeft(BitSet bs, int n) {
        for (int i = bs.length() - 1; i >= 0; i = bs.previousSetBit(i - 1)) {
            bs.clear(i);//from  w  w  w.ja  v a2s  .  c  om
            bs.set(i + 1);
        }
    }


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int N = 13;

        int sum = scn.nextInt(), n = scn.nextInt();

        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }

        BitSet bt = new BitSet(N);
        bt.set(0);

        // O(n)
        for (int i = 1; i <= n; i++) {
            BitSet x = (BitSet) bt.clone();
            shiftLeft(bt, a[i]);
            bt.or(x);
        }

        System.out.println(bt.get(sum));
    }
}
