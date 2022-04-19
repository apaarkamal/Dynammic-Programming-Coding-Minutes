package DP;

import java.util.Scanner;

public class RecursionSimpleDigitDp {


    static String s;

    static void fun(String ans, int index, boolean last) {

        if (index == s.length()) {
            System.out.println(ans);
            return;
        }

        int till = (last ? (s.charAt(index) - '0') : 9);

        for (int i = 0; i <= till; i++) {
            fun(ans + i, index + 1, (last && (i == till)) );
        }

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        s = scn.next();

        fun("", 0, true);


    }
}
