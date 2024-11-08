package com.duongw.javacore.array;

public class LoopInArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int element : arr) {
            System.out.println(element);
        }

        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }




    }
}
