package com.programmer.cracking.coding.answer.chapter2;

import com.programmer.cracking.coding.answer.chapter1.Different;
import com.programmer.cracking.coding.answer.chapter2.base.ListNode;

import java.util.Hashtable;

/**
 * @Author : Growlithe
 * @Date : 2018/8/7 23:04
 * @Description
 */
public class Delete {


    /*
    移除未排序链表中的重复结点
    如果不使用临时缓冲区，该怎么解决
     */

    /**
     *
     * @param listNode
     */
    public static void deleteDup(ListNode listNode) {
        Hashtable<Integer, Boolean> hashTable = new Hashtable<>();
        ListNode preListNode = null;
        while (listNode != null) {
            if (hashTable.containsKey(listNode.getData())) {
                preListNode.setNext(listNode.getNext());
            } else {
                hashTable.put(listNode.getData(),Boolean.TRUE);
                preListNode = listNode;
            }
            listNode = listNode.getNext();
        }

    }

    /**
     * 其实deleteDupWithoutOtherSpace比deleteDup好理解
     * @param listNode
     */
    public static void deleteDupWithoutOtherSpace(ListNode listNode){
        if (listNode == null){
            return;
        }
        ListNode current = listNode;
        while (current != null){
            ListNode runner = current;
            while (runner.getNext() != null){
                if (runner.getNext().getData() == current.getData()){
                    runner.setNext(runner.getNext().getNext());
                }else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(1,null);
        ListNode listNode5 = new ListNode(2,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
//        Delete.deleteDup(listNode1);
        Delete.deleteDupWithoutOtherSpace(listNode1);
        System.out.println(listNode1);
    }
}
