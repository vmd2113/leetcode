package com.duongw.leetcode;

import java.util.*;

public class _2070_MostBeautifulItemForEachQuery {

    /**
     * You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.
     * <p>
     * You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of an item whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.
     * <p>
     * Return an array answer of the same length as queries where answer[j] is the answer to the jth query.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
     * Output: [2,4,5,5,6,6]
     * Explanation:
     * - For queries[0]=1, [1,2] is the only item which has price <= 1. Hence, the answer for this query is 2.
     * - For queries[1]=2, the items which can be considered are [1,2] and [2,4].
     * The maximum beauty among them is 4.
     * - For queries[2]=3 and queries[3]=4, the items which can be considered are [1,2], [3,2], [2,4], and [3,5].
     * The maximum beauty among them is 5.
     * - For queries[4]=5 and queries[5]=6, all items can be considered.
     * Hence, the answer for them is the maximum beauty of all items, i.e., 6.
     * Example 2:
     * <p>
     * Input: items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
     * Output: [4]
     * Explanation:
     * The price of every item is equal to 1, o we choose the item with the maximum beauty 4.
     * Note that multiple items can have the same price and/or beauty.
     * Example 3:
     * <p>
     * Input: items = [[10,1000]], queries = [5]
     * Output: [0]
     * Explanation:
     * No item has a price less than or equal to 5, so no item can be chosen.
     * Hence, the answer to the query is 0.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= items.length, queries.length <= 105
     * items[i].length == 2
     * 1 <= pricei, beautyi, queries[j] <= 109
     */

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sắp xếp items theo price tăng dần
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Tạo mảng maxBeauty, lưu beauty lớn nhất tại mỗi giá trị price tăng dần
        int n = items.length;
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }

        // Kết quả để trả về
        int[] result = new int[queries.length];

        // Xử lý từng query
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int idx = binarySearch(items, query);  // Gọi hàm binarySearch
            result[i] = (idx != -1) ? maxBeauty[idx] : 0;
        }

        return result;
    }

    // Hàm binarySearch để tìm chỉ số lớn nhất có items[idx][0] <= query
    private int binarySearch(int[][] items, int query) {
        int left = 0, right = items.length - 1;
        int idx = -1;  // index để giữ vị trí của giá trị lớn nhất <= query
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] <= query) {
                idx = mid;  // Lưu lại vị trí hợp lệ
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {

    }


}
