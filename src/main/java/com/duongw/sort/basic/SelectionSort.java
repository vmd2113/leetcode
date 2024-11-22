package com.duongw.sort.basic;


/**
 * nguyên lí: thực hiện duyệt từ đầu đến cuối mảng
 * - tại vòng for thứ i thực hiện tìm phần tử nhỏ nhất từ [i+1, n-1], nếu nhỏ hơn a[i] ta thực hiện đổi chỗ
 */
public class SelectionSort {
    public static void printArray(int a[], int nth) {

        System.out.println("Lần thứ: " + nth);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static void selectionSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tem = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tem;
            }
            printArray(a, i);
        }
    }


    public static void main(String[] args) {
        int a[] = {1, 3, 67, -1, 5, 3, 8, 4};
        selectionSort(a);

    }
}
