package com.duongw.sort;


/**
 * Chọn khóa (pivot): Chọn một phần tử từ mảng làm khóa (pivot). Cách lựa chọn pivot có thể là ngẫu nhiên, hoặc lấy phần tử ở giữa mảng (thông thường là lấy phần ở giữa mảng, trong một số trường hợp thì có thể lấy pivot ở đầu mảng hoặc cuối mảng
 * Phân chia mảng: Phân chia mảng thành hai phần, sao cho các phần tử ở bên trái của pivot nhỏ hơn hoặc bằng pivot, và các phần tử ở bên phải lớn hơn pivot. Đồng thời, pivot được đặt vào vị trí "đúng đắn" trong mảng, nghĩa là các phần tử nhỏ hơn nó đều ở bên trái và các phần tử lớn hơn nó đều ở bên phải.
 * Sắp xếp đệ quy: Tiếp tục thực hiện quy trình phân chia và sắp xếp đệ quy trên cả hai phần của mảng, trái và phải của pivot.
 * Kết hợp các phần tử đã sắp xếp: Kết hợp các phần tử đã sắp xếp từ các phần con thành một mảng đã sắp xếp hoàn chỉnh.
 */
public class QuickSort {

    public static int[] quickSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        return quickSort(nums, 0, nums.length - 1);
    }


    public static int[] quickSort(int[] nums, int left, int right) {
        if (right > left) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);

        }
        return nums;
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[Math.floorDiv((left + right), 2)];
        while (left <= right) {

            // thực hiện tìm kiếm phần tử nhỏ hơn key (ở bên trái)
            while (nums[left] < pivot) {
                left++;
            }
            // thực hiện tìm kiếm phần tử lớn hơn key (ở bên phải)
            while (nums[right] > pivot) {
                right--;
            }

            // đổi chỗ hai phần tử
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }
        return left;


    }


    public static void main(String[] args) {


    }
}
