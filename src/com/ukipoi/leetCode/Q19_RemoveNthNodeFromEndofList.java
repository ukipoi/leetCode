package com.ukipoi.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q19_RemoveNthNodeFromEndofList {
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
        removeNthFromEnd(listNode, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return head;
        }
        ListNode nodeTemp = head;
        list.add(nodeTemp);
        int i = 1;
        while (nodeTemp.next != null) {
            list.add(nodeTemp.next);
            nodeTemp = nodeTemp.next;
            i++;
        }
        if (n > i) {
            return head;
        } else if (n == i) {
            return head.next;
        } else if (n == 1) {
            list.get(i - 2).next = null;
            return head;
        }
        ListNode node = list.get(i - n - 1);
        node.next = list.get(i - n + 1);
        return head;
    }
}
