package com.ukipoi.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q19_RemoveNthNodeFromEndofList_Ans2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        removeNthFromEnd(listNode, 5);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode nodeT = head;
        ListNode nodeE = head;
        int i = 1;
        while (nodeE.next != null) {
            if (i>=n+1){
                nodeT = nodeT.next;
            }
            nodeE = nodeE.next;
            i++;
        }
        if (n > i) {
            return head;
        } else if (n == i) {
            return head.next;
        } else if (n == 1) {
            nodeT.next = null;
            return head;
        }
        nodeT.next = nodeT.next.next;
        return head;
    }
}
