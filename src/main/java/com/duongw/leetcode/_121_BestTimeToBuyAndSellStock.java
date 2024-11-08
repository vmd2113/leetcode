package com.duongw.leetcode;

public class _121_BestTimeToBuyAndSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * Example 1:
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     * Example 2:
     * Input: [7,6,4,3,1]
     * Output: 0
     * In this case, no transaction is done, i.e. max profit = 0.
     */





    // thực hiện duyệt mảng 1 lần O(n)
    // gán giá trị cho min_price (một giá trị cao hơn tất cả các phần tử trong mảng) và max_profit = 0
    // cập nhất lại giá trị min_price khi price[i] < min_price
    // chỉ thực hiện cập nhất giá trị max_profit khi price[i] - min_price > max_profit
    public static int maxProfit(int[] prices) {
        int MIN_PRICE = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int price : prices) {
            if (price < MIN_PRICE) {
                MIN_PRICE = price;
            } else if (price - MIN_PRICE > maxProfit) {
                maxProfit = price - MIN_PRICE;
            }
        }
        return maxProfit;
    }


    // Brute force: thực hiện duyệt qua tất cả các phần tử trong danh sách (chiến lược vét cạn): O(n^2)


    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit: " + maxProfit);

    }
}
