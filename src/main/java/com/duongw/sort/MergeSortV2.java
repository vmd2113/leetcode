package com.duongw.sort;


import java.util.Arrays;

public class MergeSortV2 {

    public static void merge(int[] nums, int left, int mid, int right, int[] buffer) {
        int i = left;       // Con trỏ cho mảng trái
        int j = mid + 1;    // Con trỏ cho mảng phải
        int k = left;       // Con trỏ cho buffer

        // Trộn hai mảng con (left đến mid, mid+1 đến right)
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                buffer[k++] = nums[i++];
            } else {
                buffer[k++] = nums[j++];
            }
        }

        // Copy phần còn lại của mảng trái
        while (i <= mid) {
            buffer[k++] = nums[i++];
        }

        // Copy phần còn lại của mảng phải
        while (j <= right) {
            buffer[k++] = nums[j++];
        }

        // Copy lại từ buffer vào nums
        for (i = left; i <= right; i++) {
            nums[i] = buffer[i];
        }
    }

    public static void mergeSort(int[] nums, int left, int right, int[] buffer) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Sắp xếp mảng con bên trái
        mergeSort(nums, left, mid, buffer);

        // Sắp xếp mảng con bên phải
        mergeSort(nums, mid + 1, right, buffer);

        // Trộn hai mảng đã sắp xếp
        merge(nums, left, mid, right, buffer);
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // Tạo một buffer tạm thời có kích thước bằng mảng gốc
        int[] buffer = Arrays.copyOf(nums, nums.length);

        // Thực hiện sắp xếp
        mergeSort(nums, 0, nums.length - 1, buffer);
    }

    public static void main(String[] args) {
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before sorting: " + Arrays.toString(nums));

        mergeSort(nums);

        System.out.println("After sorting: " + Arrays.toString(nums));
    }
}
