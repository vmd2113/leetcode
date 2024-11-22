package com.duongw.sort.basic;

/**
 * Nguyên lý hoạt động (sắp xếp tăng dần):
 * - duyệt từ đầu đến cuối mảng, nếu gặp phần tử đứng trước mà lớn hơn phần tử đứng sau thì thực hiện đổi chỗ
 * - sau n-1 vòng (n là số phần từ) thì mảng sẽ sắp xếp
 */

/**
 * khi thực hiện duyệt, thì so sánh phần từ a[j] và a[j+1], nếu mà a[j] > a[j+1] thì thực hiện đổi chỗ (đối với sắp xếp tăng dần)
 * và a[j] < a[j+1] đối với sắp xếp giảm dần*/


public class BubbleSort {

    public static void printArray(int a[], int nth) {

        System.out.println("Lần thứ: " + nth);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) { // tương đương j = i +1
                // thực hiện so sánh phần tử arr[j] và arr[j+1]
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    ;
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }

            }
            printArray(arr, i);
        }


    }

    /**
     * nâng cấp
     * - khi thực hiện so sánh và xảy ra sự đổi chỗ, ta gắn biến isSorted = false và khi nó bằng true thì chúng ta thực hiện thoát khỏi vòng lặp
     */
    public static void bubbleSortVer2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) { // tương đương j = i +1
                // thực hiện so sánh phần tử arr[j] và arr[j+1]
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    int temp = arr[j];
                    ;
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }

            }
            printArray(arr, i);

            if (isSorted) break;
        }


    }

    public static void bubbleSortVer3(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];

                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
            printArray(a, i);

        }
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 67, -1, 5, 3, 8, 4};
        bubbleSort(a);

        bubbleSortVer3(a);
    }
}
