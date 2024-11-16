package com.duongw.leetcode;

public class _2_AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0); // simplify result
        ListNode current = temp; // pointer to current node

        int carry = 0; // carry
        while (l1 != null || l2 != null || carry != 0) {
            // check null of l1 and l2
            int value1 = (l1 != null) ? l1.val : 0;
            int value2 = (l2 != null) ? l2.val : 0;

            // calculate sum
            int sum = value1 + value2 + carry;
            carry = sum / 10;


            // add to current node
            current.next = new ListNode(sum % 10);
            current = current.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return temp.next;


    }

    public static void main(String[] args) {

    }


}
