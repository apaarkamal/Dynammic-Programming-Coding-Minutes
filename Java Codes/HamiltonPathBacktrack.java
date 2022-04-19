package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class HamiltonPathBacktrack {


    final static  int N = (int) (2e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int vis[] = new int[N];

    static int n, m;

    static boolean hamiltonian_path = false;

// bool paths()

    // O(number_of_hamiltonian_paths)
    static void paths(int cur, int cnt) {
        if (cnt == n) {
            hamiltonian_path = true;
            return;
        }

        vis[cur] = 1;

        for (int x : gr[cur]) {
            if (vis[x] == 0) {
                paths(x, cnt + 1);
            }
        }

        // backtracking
        vis[cur] = 0;
        return;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            gr[x].add(y);
            gr[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            paths(i, 1);
        }

        System.out.println(hamiltonian_path);


    }
}
