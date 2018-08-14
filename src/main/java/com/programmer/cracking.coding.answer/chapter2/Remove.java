package com.programmer.cracking.coding.answer.chapter2;

import com.programmer.cracking.coding.answer.chapter2.base.ListNode;

/**
 * @Author : Growlithe
 * @Date : 2018/8/8 12:51
 * @Description
 */
public class Remove {

    /*
    实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
    给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
     */
    /**
     *
     * @param pNode
     * @return
     */
    public static boolean removeNode(ListNode pNode) {
        if (pNode == null || pNode.getNext() == null){
            return false;
        }

        ListNode tempListNode = pNode.getNext();
        pNode.setNext(tempListNode.getNext());
        pNode.setData(tempListNode.getData());
        return true;
    }


    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(1, null);
        ListNode listNode5 = new ListNode(2, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        Remove.removeNode(listNode2);
        System.out.println(listNode2);
    }
}
