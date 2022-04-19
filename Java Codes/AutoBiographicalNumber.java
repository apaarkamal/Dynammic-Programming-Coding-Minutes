package DP;

public class AutoBiographicalNumber {




    public static final int N = 20;

    public static int length, num[] = new int[N], cnt[] = new int[N];

    public static void auto_bio_graphical_number(int index) {

        // base case
        if (index == length) {
            for (int i = 0; i < length; i++) {
                if (num[i] != cnt[i]) return;
            }

            for (int i = 0; i < length; i++) {
                System.out.print(num[i]);
            }
            System.out.println();

            return;
        }

        for (int _num = 0; _num < length; _num++) {
            num[index] = _num;
            cnt[_num]++;

            auto_bio_graphical_number(index + 1);

            // back tracking
            cnt[_num]--;
            num[index] = -1;

        }

    }

    public static void main(String[] args) {

        length = 4;
        auto_bio_graphical_number(0);

    }
}
