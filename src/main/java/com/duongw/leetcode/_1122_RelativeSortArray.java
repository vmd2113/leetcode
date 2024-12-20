package com.duongw.leetcode;

import java.util.*;

public class _1122_RelativeSortArray {

    /**
     * 1122. Relative Sort Array
     * Easy
     * Topics
     * Companies
     * Hint
     * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
     * <p>
     * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * Output: [2,2,2,1,4,3,3,9,6,7,19]
     * Example 2:
     * <p>
     * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
     * Output: [22,28,8,6,17,44]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * All the elements of arr2 are distinct.
     * Each arr2[i] is in arr1.
     */


    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // convert arr1 to list
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            list1.add(arr1[i]);
        }

        // get elements in arr2 that are in arr1 to result list
        List<Integer> result = new ArrayList<>();
        for (int num : arr2) {
            while (list1.contains(num)) {
                result.add(num);
                list1.remove(Integer.valueOf(num));
            }
        }

        // sort remaining elements in list1
        Collections.sort(list1);

        // add remaining elements to result list
        result.addAll(list1);


        // convert result list to array
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;

    }

    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        // using hashmap
        Map<Integer, Integer> map = new HashMap<>();


        // put element of arr2 in map
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // sperate elements in arr1
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int num: arr1){
            if (map.containsKey(num)){
                list1.add(num);
            } else {
                list2.add(num);
            }
        }

        list1.sort(Comparator.comparingInt(map::get));
        Collections.sort(list2);


        int[] result = new int[arr1.length];
        int index = 0;

        for (int num : list1) {
            result[index++] = num;
        }
        for (int num : list2) {
            result[index++] = num;
        }

        return result;
    }


    public static void main(String[] args) {
        int arr1[] = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int arr2[] = {2, 1, 4, 3, 9, 6};
        int[] result = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));


    }
}
