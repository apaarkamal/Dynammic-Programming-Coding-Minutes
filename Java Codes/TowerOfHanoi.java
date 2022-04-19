package DP;

public class TowerOfHanoi {


    static void TowerOfHanoi(int n, char from, char helper, char to) {

        if (n == 0) return;

        // cout << n << " " << from << " " << helper << " " << to << '\n';

        TowerOfHanoi(n - 1, from, to, helper);
        // reached here
        // nth rod to to
        System.out.println(from + " -> " + to);

        TowerOfHanoi(n - 1, helper, from, to);

    }

    public static void main(String[] args) {

        int n = 4;

        TowerOfHanoi(n, 'A', 'B', 'C');

    }
}
