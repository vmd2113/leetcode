package com.duongw.sort.basic;


/**nguyên lí: duyệt từ đầu đến cuối mảng, tại vòng lặp thứ i, coi như [0, i-1] đã thực hiện sắp xếp,
 * ta thưc hiện chèn phần tử a[i] vào vị trí thích hợp
 * - dãy sẽ được sắp xếp sau n -1 vòng lặp */

/**thực hiện: khi thực hiện sắp xếp chèn, ta duyệt từ i =1 chạy đến <n;
 * lấy phần từ a[i] (phần tử đang duyệt) thực hiện so sánh với các phần tử trước đó bằng cách khời tạo biến j = i-1
 * vòng while (thực hiện chạy với điều kiện, số đang xét a[i] <a[j] (sắp xếp tăng dần) và a[i] > a[j] (sắp xếp giảm dần)
 * trong vòng while thực hiện chèn vào vị trí thích hợp (a[j+1] = a[j] và lùi j
 * vòng while sau thực thi xong, ta thực hiện a[j+1] = số đang duyệt (a[i]*/

public class  InsertionSort {

    public static void printArray(int a[], int nth) {

        System.out.println("Lần thứ: " + nth);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static void insertionSort(int arr[]){
        int n = arr.length;

        for (int i = 1; i<n; i++){
            int arr_i = arr[i]; // lấy ra phần tử đang so sánh
            int j = i-1;// biến tam
            while (j>=0 &&  arr[j] >arr_i){
                // khi thấy phần tử lớn hơn thì thực hiện chèn trước số đó (sắp xếp tăng dần)
                arr[j+1] = arr[j];
                j--;

            }
            // sau khi j-- đến khi break vòng while ( thì vị trí cần chèn là i+1)
            arr[j+1] = arr_i;
            printArray(arr, i);

        }

    }

    public static void main(String[] args) {
        int a[] = {1, 3, 67, -1, 5, 3, 8, 4};

        insertionSort(a);

    }
}
