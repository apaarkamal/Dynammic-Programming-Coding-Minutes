package DP;

import java.util.*;

public class PalindromicPartitioning {



    static class Solution {

        String s;
        HashMap<Integer, List<List<String>>> mp = new HashMap<>();

        boolean is_palindrome(int i, int j) {
            while (i <= j) {
                if (s.charAt(i)!= s.charAt(j)) return false;
                i++; j--;
            }
            return true;
        }

        List<List<String>> dp(int i) {

            if (i == s.length()) return new ArrayList<>();

            if (mp.containsKey(i))
                return mp.get(i);

            List<List<String>> ans = new ArrayList<>();

            for (int j = i; j < s.length(); j++) {
                if (is_palindrome(i, j)) {

                    List<List<String>> res = dp(j + 1);
                    List<List<String>> res1 = new ArrayList<>();
                    String substring = s.substring(i, j+1);


                    for (int idx =0 ; idx < res.size(); idx++) {
                        res1.add(new ArrayList<>(res.get(idx)));
                    }
                    for (int idx =0 ; idx < res1.size(); idx++) {
                        res1.get(idx).add(0, substring);
                    }

                    if (res1.isEmpty()) {
                        res1.add(new ArrayList<>(Arrays.asList(substring)));
                    }

                    ans.addAll(res1);
                }

            }

            mp.put(i, ans);
            return ans;
        }

        List<List<String>> partition(String s) {
            this.s = s;
            return dp(0);
        }
    };

    public static void main(String[] args) {


        Scanner scn =  new Scanner(System.in);
        String s  = "aab";


        Solution H = new Solution();
        List<List<String>> res = H.partition(s);

        for (List<String> x : res) {
            for (String y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }


    }
}
