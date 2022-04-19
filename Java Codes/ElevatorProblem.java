package DP;

import java.util.Scanner;

class Pair{
    int first, second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}
public class ElevatorProblem {

    public static Pair min(Pair a, Pair b) {
        if(a.first < b.first){
            return a;
        }
        if(b.first < a.first){
            return b;
        }
        if(a.second < b.second){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(), n = scanner.nextInt();

        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
             weight[i] =scanner.nextInt();
        }

        Pair[] dp = new Pair[(1 << n)];
        // dp[mask].first = f[mask] = rides
        // dp[mask].second = g[mask] = weight

        dp[0] = new Pair(1, 0);

        for (int mask = 1; mask < 1 << n; mask++) {
            dp[mask] = new Pair(n, 0);
            for (int y = 0; y < n; y++) {
                if (((mask >> y) & 1) != 0) {
                    int new_mask = mask ^ (1 << y);
                    Pair option = dp[new_mask];
                    // include yth person
                    if (option.second + weight[y] <= x) {
                        option.first = option.first;
                        option.second += weight[y];
                    }
                    else {
                        // exclude the yth person
                        // new ride with y
                        option.first++;
                        option.second = weight[y];
                    }
                    dp[mask] = min(dp[mask], option);
                }
            }
        }

        System.out.println(dp[(1<<n)-1].first + " " + dp[(1<<n)-1].second);

    }
}
