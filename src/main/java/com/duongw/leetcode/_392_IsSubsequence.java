package com.duongw.leetcode;

import java.util.HashSet;

public class _392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int indexT = 0;
        int indexS = 0;

        while(indexS<s.length() && indexT<t.length()){
            if (s.charAt(indexS) == t.charAt(indexT)){
                indexS++;

            }
            indexT++;
        }
        return indexS == s.length();



    }

    public static void main(String[] args) {

    }
}
