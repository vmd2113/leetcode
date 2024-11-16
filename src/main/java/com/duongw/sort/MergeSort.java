package com.duongw.sort;

public class MergeSort {


    public static int[] merge(int leftArray[], int rightArray[]) {
        int n = leftArray.length + rightArray.length;
        int result[] = new int[n];

        int leftPos = 0;
        int rightPos = 0;
        int currentPos = 0;

        while (currentPos < n) {
            if (leftPos < leftArray.length && rightPos < rightArray.length) {
                if (leftArray[leftPos] < rightArray[rightPos]) {
                    result[currentPos] = leftArray[leftPos];
                    leftPos++;
                    currentPos++;
                } else {
                    result[currentPos] = rightArray[rightPos];
                    rightPos++;
                    currentPos++;

                }
            } else {
                if (leftPos < leftArray.length) {
                    result[currentPos] = leftArray[leftPos];
                    leftPos++;
                    currentPos++;
                }
                if ((rightPos < rightArray.length)) {
                    result[currentPos] = rightArray[rightPos];
                    rightPos++;
                    currentPos++;
                }

//                if (leftPosition < leftArray.length) {
//                    System.arraycopy(leftArray, leftPosition, result, currentPosition, leftArray.length - leftPosition);
//                } else if (rightPosition < rightArray.length) {
//                    System.arraycopy(rightArray, rightPosition, result, currentPosition, rightArray.length - rightPosition);
//                }
//                break;

            }

        }
        return result;

    }

    public static int[] mergeSort(int leftIndex, int rightIndex, int[] nums) {

        if (leftIndex > rightIndex)

            return new int[0];
        if (leftIndex == rightIndex) {

            int[] element = {nums[leftIndex]};
            return element;


        }
        int midIndex = (leftIndex + rightIndex) / 2;

        int leftArray[] = mergeSort(leftIndex, midIndex, nums);
        int rightArray[] = mergeSort(midIndex + 1, rightIndex, nums);
        int sortedArray[] = merge(leftArray, rightArray);
        return sortedArray;


    }

    public static int[] sortArray(int nums[]) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        return mergeSort(0, nums.length - 1, nums);

    }


    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 99, -5, 4, 7, -9, 10};


        System.out.println("Original array:");
        printArr(arr);

        int sortedArray[] = sortArray(arr);

        System.out.println("Sorted array:");
        printArr(sortedArray);

    }
}



