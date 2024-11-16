package com.duongw.sort;

import java.util.Arrays;

public class QuickSortV2 {

    // Hàm chính gọi sắp xếp
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    // Đệ quy QuickSort
    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // Chọn pivot ngẫu nhiên để giảm thiểu trường hợp xấu
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = nums[pivotIndex];

        // Đặt pivot vào cuối để dễ thao tác
        swap(nums, pivotIndex, right);

        // Phân chia mảng và lấy chỉ số của pivot sau khi phân chia
        int partitionIndex = partition(nums, left, right, pivot);

        // Đệ quy sắp xếp mảng con bên trái và bên phải
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    // Phân chia mảng dựa trên pivot
    private static int partition(int[] nums, int left, int right, int pivot) {
        int i = left;
        int j = right - 1; // Vì pivot đã được đặt cuối

        while (i <= j) {
            // Di chuyển con trỏ trái đến khi gặp phần tử lớn hơn hoặc bằng pivot
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            // Di chuyển con trỏ phải đến khi gặp phần tử nhỏ hơn hoặc bằng pivot
            while (i <= j && nums[j] > pivot) {
                j--;
            }

            // Đổi chỗ hai phần tử không đúng thứ tự
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // Đặt pivot vào vị trí đúng (giữa hai mảng con)
        swap(nums, i, right);
        return i;
    }

    // Hàm hoán đổi hai phần tử
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before sorting: " + Arrays.toString(nums));

        quickSort(nums);

        System.out.println("After sorting: " + Arrays.toString(nums));
    }
}
