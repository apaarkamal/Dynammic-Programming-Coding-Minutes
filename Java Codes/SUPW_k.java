package DP;

import java.util.Scanner;

public class SUPW_k {


    static class segmenttree {
        int[] st;
        int n;
        void init(int _n) {
            n = _n;
            st = new int[4 * _n];
        }
        void build(int l, int r, int node, int a[]) {
            if (l == r) {
                st[node] = a[l];
                return;
            }
            int mid = (l + r) / 2;
            build(l, mid, node * 2 + 1, a);
            build(mid + 1, r, node * 2 + 2, a);
            st[node] = Math.min(st[2 * node + 1], st[2 * node + 2]);
        }

        void update(int l, int r, int indup, int val, int node) {
            if (l == r) {
                st[node] = val;
                return;
            }
            else {
                int mid = (l + r) / 2;
                if (indup >= l && indup <= mid) {
                    update(l, mid, indup, val, node * 2 + 1);
                }
                else {
                    update(mid + 1, r, indup, val, node * 2 + 2);
                }
                st[node] = Math.min(st[2 * node + 1], st[2 * node + 2]);
            }
        }

        int query(int si, int se, int l, int r, int node) {
            if (se < l || si > r || l > r) {
                return Integer.MAX_VALUE;
            }
            if (si >= l && se <= r) {
                return st[node];
            }
            int mid = (si + se) / 2;
            int q1 = query(si, mid, l, r, node * 2 + 1);
            int q2 = query(mid + 1, se, l, r, node * 2 + 2);
            return Math.min(q1, q2);
        }
        void build(int n, int a[]) {
            init(n);
            build(0, n - 1, 0, a);
        }
        int query(int l, int r) {
            return query(0, n - 1, l, r, 0);
        }
        void update(int index, int val) {
            update(0, n - 1, index, val, 0);
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), k = scn.nextInt();
        int[] a = new int[n], b = new int[n], dp = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
            b[i] = Integer.MAX_VALUE;
        }

        segmenttree H = new segmenttree();

        H.build(n, b);

        for (int i = 0; i < k; i++) {
            dp[i] = a[i];
            H.update(i, dp[i]);
        }

        for (int i = k; i < n; i++) {
            int mn = H.query(i - k, i - 1);
            dp[i] = mn + a[i];
            H.update(i, dp[i]);
        }

        // for (int i = 0; i < n; i++) {
        // 	cout << dp[i] << " ";
        // }

        System.out.println(H.query(n-k, n-1));
    }
}
