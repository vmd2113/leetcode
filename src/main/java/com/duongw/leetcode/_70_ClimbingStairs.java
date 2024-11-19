package com.duongw.leetcode;

public class _70_ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step*/
    public int climbStairs(int n) {
        if (n == 1 ) return 1;

        // using fibonacci
        int first = 1;
        int second = 1;
        int step  = 0;
        for (int i = 2; i <= n; i++) {
            step = first + second;
            first = second;
            second = step;
        }

        return step;
    }

    public static void main(String[] args) {
        int n = 3;
        _70_ClimbingStairs obj = new _70_ClimbingStairs();
        System.out.println(obj.climbStairs(n));

        int n2 = 4;
        System.out.println(obj.climbStairs(n2));

        int n3 = 5;
        System.out.println(obj.climbStairs(n3));

    }
}
