package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class HamiltonPathRecursiveMemo {

    static class Pair{
        int first;
        HashSet<Integer> second;

        public Pair(int first, HashSet<Integer> second) {
            this.first = first;
            this.second = second;
        }
    }

    final static  int N = 10;

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int vis[] = new int[N];

    static int n, m;

    static boolean hamiltonian_path = false;


    static HashMap<Pair, Boolean> mp = new HashMap<>();

    static boolean dp(int cur, HashSet<Integer> St) {

        if (St.size() == n) {
            return true;
        }
        if (mp.containsKey(new Pair(cur, St))) {
            return mp.get(new Pair(cur, St));
        }

        boolean ans = false;
        for (int x : gr[cur]) {
            if (!St.contains(x)) {

                HashSet<Integer> temp = new HashSet<>(St);
                temp.add(x);

                ans |= dp(x, temp);
            }
        }

        mp.put(new Pair(cur, St), ans);
        return ans;

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        for (int i = 0; i < m; i++) {
            int x = scn.nextInt(), y = scn.nextInt();
            gr[x].add(y);
            gr[y].add(x);
        }
        boolean hamiltonian_path = false;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> St = new HashSet<>();
            St.add(i);
            hamiltonian_path |= dp(i, St);
        }


        System.out.println(hamiltonian_path);


    }


}
