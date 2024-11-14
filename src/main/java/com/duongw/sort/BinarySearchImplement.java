package com.duongw.sort;

public class BinarySearchImplement {

    public int binarySearch(int[] a, int value) {
        int n = a.length;
        int indexLeft = 0;
        int indexRight = n - 1;
        while (indexLeft <= indexRight) {
            int indexMid = indexLeft + (indexRight + indexLeft) / 2;
            if (value == a[indexMid])
                return indexMid;
            else if (value < a[indexMid]) {
                indexRight = indexMid - 1;
            } else {
                indexLeft = indexMid + 1;
            }
        }
        return -1;
    }

    // Bonus: find resonable index of taget value when inserting
    public int binarySearchInsert(int[] a, int value) {
        int n = a.length;
        int indexLeft = 0;
        int indexRight = n - 1;
        while (indexLeft <= indexRight) {
            int indexMid = indexLeft + (indexRight + indexLeft) / 2;
            if (value == a[indexMid])
                return indexMid;
            else if (value < a[indexMid]) {
                indexRight = indexMid - 1;
            } else {
                indexLeft = indexMid + 1;
            }
        }
        return indexLeft;
    }

    // using recursion

    public int binarySearch_(int[] a, int value, int left, int right) {
        int n = a.length;
        if (left <= right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (value == a[mid])
            return mid;
        else if (value < a[mid]) {
            return binarySearch_(a, value, left, mid - 1);
        } else {
            return binarySearch_(a, value, mid + 1, right);
        }
    }
}
