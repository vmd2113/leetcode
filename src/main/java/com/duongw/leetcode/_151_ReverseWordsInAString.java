package com.duongw.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _151_ReverseWordsInAString {


    // Method 1: sử dụng split và viết function đảo ngược chuỗi

    public static String reverseWords(String s) {
        // Bước 1: Loại bỏ khoảng trắng thừa và tách các từ
        String[] words = s.trim().split("\\s+");

        // Bước 2: Đảo ngược mảng các từ
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        // Bước 3: Trả về chuỗi đã được nối lại
        return reversed.toString();
    }


    // method 2: sử dụng dequeue(stack) để thực hiện quản lí việc chuỗi đảo

    public static String reverseWords2(String s) {

        Deque<String> deque = new ArrayDeque<>();

        int i = 0;
        int length = s.length();

        while (i < length) {
            while (i < length && s.charAt(i) == ' ') {
                i++;
            }
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            if (start < i) {
                String word = s.substring(start, i);
                deque.addFirst(word);
            }
        }

        return String.join(" ", deque);

    }

    // method 3: sử dụng string builder và thực hiện các tác vụ như sử lí khoảng trăng, đảo chuỗi sử dụng while

    public static String reverseWords3(String s) {
        StringBuilder reversed = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Bỏ qua khoảng trắng
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // Xác định từ cuối cùng
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Thêm từ vào StringBuilder
            if (j > i) {
                reversed.append(s, i + 1, j + 1).append(" ");
            }
        }

        return reversed.toString().trim(); // Loại bỏ khoảng trắng cuối cùng
    }

    public static void main(String[] args) {

        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
        System.out.println(reverseWords3(s));

        String s2 = "     test    is full of   space";
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords2(s2));
        System.out.println(reverseWords3(s2));


    }
}
