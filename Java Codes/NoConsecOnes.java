package DP;

public class NoConsecOnes {



    // one represents whether
// the number at previous index is one
    static int fun(int index, int n, boolean previous_one) {

        // base case
        if (index == n + 1) return 1;

        int ans = 0;

        // either place 0 here
        ans += fun(index + 1, n, false);

        // or place 1 here
        if (!previous_one) {
            ans += fun(index + 1, n, true);
        }

        return ans;
        // ans for array [index.....n]
    }

    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++) {
            System.out.println( fun(1, i, false));
        }


        // fibonacci series
        // 1,1,2,3,5,8 .....
        // ans = fib(n+2)
    }
}
