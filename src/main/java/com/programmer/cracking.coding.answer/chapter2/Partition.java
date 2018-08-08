package com.programmer.cracking.coding.answer.chapter2;

import com.programmer.cracking.coding.answer.chapter2.base.ListNode;

/**
 * @Author : Growlithe
 * @Date : 2018/8/8 14:02
 * @Description
 */
public class Partition {

    /*
    编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
     */

    /**
     * 这个顺序会变
     *
     * @param pHead
     * @param x
     * @return
     */
    public static ListNode partition(ListNode pHead, int x) {
        ListNode before = null;
        ListNode after = null;

        while (pHead != null) {
            ListNode next = pHead.getNext();
            if (pHead.getData() < x) {
                pHead.setNext(before);
                before = pHead;
            } else {
                pHead.setNext(after);
                after = pHead;
            }

            pHead = next;
        }

        if (before == null) {
            return after;
        }

        ListNode listNode = before;
        while (before.getNext() != null) {
            before = before.getNext();
        }
        before.setNext(after);

        return listNode;
    }

    /**
     * 非函数式编程的问题哈
     *
     * @param pHead
     * @param x
     * @return
     */
    public static ListNode otherPartition(ListNode pHead, int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while (pHead != null) {
            ListNode next = pHead.getNext();
            pHead.setNext(null);
            if (pHead.getData() < x) {
                if (beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.setNext(pHead);
                    beforeEnd = pHead;
                }
            } else {
                if (afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                } else {
                    afterEnd.setNext(pHead);
                    afterEnd = pHead;
                }
            }

            pHead = next;
        }


        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.setNext(afterStart);

        return beforeStart;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(1, null);
        ListNode listNode5 = new ListNode(2, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        listNode1 = Partition.otherPartition(listNode1, 3);
        System.out.println(listNode1);
    }

}
