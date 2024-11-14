package com.duongw.leetcode;

public class _35_SearchInsertPosition {

    private int binarySearch(int nums[], int target) {


        int n = nums.length - 1;
        int right = n;
        int left = 0;

        // using while loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    private int binarySearchRecurse(int nums[], int left, int right, int target) {
        if (left > right) return left;


        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return binarySearchRecurse(nums, mid + 1, right, target);
        else return binarySearchRecurse(nums, left, mid - 1, target);

    }


    public int searchInsert(int[] nums, int target) {
        return binarySearchRecurse(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        _35_SearchInsertPosition searchInsertPosition = new _35_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsertPosition.searchInsert(nums, 2));
        System.out.println(searchInsertPosition.searchInsert(nums, 7));

    }
}