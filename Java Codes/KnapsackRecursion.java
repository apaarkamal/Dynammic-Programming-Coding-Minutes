package DP;

public class KnapsackRecursion {



    static final int N = 2001;

    int[] s = new int[N], v = new int[N];
    int[][] memo = new int[N][N];

    // O(n*size)
    int knapsack(int index, int size) {
        if (index == 0) return 0;

        int ans = memo[index][size];

        if (ans != -1) return ans;
        ans = 0;

        // include
        if (s[index] <= size) {
            ans = v[index] + knapsack(index - 1, size - s[index]);
        }
        // exclude
        ans = Math.max(ans, knapsack(index - 1, size));
        memo[index][size] = ans;
        return ans;

    }


}
