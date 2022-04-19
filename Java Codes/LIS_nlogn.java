package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LIS_nlogn {



    static class fenwick {
        int[] fn;
        int n;
        fenwick() {}
        fenwick(int n) {
            init(n);
        }
        void init(int _n) {
            n = _n + 10;
            fn = new int[n];
        }
        // log(n)
        void update(int x, int val) {
            x++;// 1 based indexing
            while (x < n) {
                fn[x] = Math.max(fn[x], val);
                x += (x & (-x));
            }
        }
        // log(n)
        int query(int x) {
            x++;//1 basaed indexing
            int ans = 0;
            while (x > 0) {
                ans = Math.max(ans, fn[x]);
                x -= (x & (-x));
            }
            return ans;
        }
    }

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int a[] = new int[n];
        int dp[] = new int[n];
        ArrayList<Pair> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
            b.add(new Pair(a[i], 1));
        }




        fenwick H = new fenwick(n);

        int[] lis = new int[n];

        b.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.first == o2.first){
                    return o1.second - o2.second;
                }
                return o1.first - o2.first;
            }
        });

        for (int i = 0; i < n; i++) {
            int val = b.get(i).first;
            int index = b.get(i).second;

            lis[index] = H.query(index - 1) + 1;

            H.update(index, lis[index]);
        }

        // for (int i = 0; i < n; i++) {
        // 	cout << lis[i] << " ";
        // }

        // n logn
        System.out.println(H.query(n-1));

        // inversion count


    }
}
