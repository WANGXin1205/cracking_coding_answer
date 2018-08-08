package com.programmer.cracking.coding.answer.chapter2;

import com.programmer.cracking.coding.answer.chapter2.base.ListNode;

/**
 * @Author : Growlithe
 * @Date : 2018/8/8 0:27
 * @Description
 */
public class Solution {

    /*
    输入一个链表，输出该链表中倒数第k个结点。
     */

    /**
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        Integer length = 0;
        ListNode listNode = head;
        while (listNode != null) {
            listNode = listNode.getNext();
            length = length + 1;
        }

        if (k > length) {
            return null;
        }

        for (int i = 0; i < length - k; i++) {
            head = head.getNext();
        }

        return head;
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKthNodeToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode listNode = head;
        ListNode otherListNode = head;

        for (int i = 0; i < k-1; i++) {
            if (otherListNode == null){
                return null;
            }
            otherListNode = otherListNode.getNext();
        }
        if (otherListNode == null){
            return null;
        }

        while (otherListNode.getNext() != null){
            listNode = listNode.getNext();
            otherListNode = otherListNode.getNext();
        }

        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(1, null);
        ListNode listNode5 = new ListNode(2, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
//        listNode1 = Solution.findKthToTail(listNode1, 3);
        listNode1 = Solution.findKthNodeToTail(listNode1,3);
        System.out.println(listNode1);
    }
}
