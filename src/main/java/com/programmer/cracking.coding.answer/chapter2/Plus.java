package com.programmer.cracking.coding.answer.chapter2;

import com.programmer.cracking.coding.answer.chapter2.base.ListNode;

import java.util.HashMap;

/**
 * @Author : Growlithe
 * @Date : 2018/8/9 22:12
 * @Description
 */
public class Plus {

    /*
    有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
    编写函数对这两个整数求和，并用链表形式返回结果。
    给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。

    测试样例：
    {1,2,3},{3,2,1}
    返回：{4,4,4}
    {7,1,6},{5,9,2}
    返回: {2-1-9}
     */

    /**
     * @param a
     * @param b
     * @return
     */
    public static ListNode plusAB(ListNode a, ListNode b) {

        HashMap<Integer, Integer> aHashMap = Plus.convertListNodeToHashMap(a);
        HashMap<Integer, Integer> bHashMap = Plus.convertListNodeToHashMap(b);

        Integer sameSize = Plus.fillHashMapToSameSize(aHashMap, bHashMap);

        // 获取相同的长度
        HashMap<Integer, Integer> plusHashMap = new HashMap<>();
        for (int i = 0; i < sameSize; i++) {
            Integer aNum = aHashMap.get(i);
            Integer bNum = bHashMap.get(i);
            Integer sum = aNum + bNum;
            plusHashMap.put(i, sum);
        }

        // 进位处理
        for (int i = 0; i < plusHashMap.size(); i++) {
            if (i < plusHashMap.size() - 1) {
                Integer num = plusHashMap.get(i);
                if (num >= 10) {
                    plusHashMap.put(i, num - 10);
                    plusHashMap.put(i + 1, plusHashMap.get(i + 1) + 1);
                }
            }
        }
        if (plusHashMap.get(plusHashMap.size()-1) >= 10) {
            plusHashMap.put(plusHashMap.size()-1, plusHashMap.get(plusHashMap.size()-1) - 10);
            plusHashMap.put(plusHashMap.size(), 1);
        }

        ListNode listNode = Plus.convertHashMapToListNode(plusHashMap);

        return listNode;
    }


    public static ListNode convertHashMapToListNode(HashMap<Integer, Integer> hashMap) {
        ListNode listNode = new ListNode(hashMap.get(0));

        for (int i = 1; i < hashMap.size(); i++) {
            listNode = Plus.insert(listNode, hashMap.get(i));
        }

        return listNode;
    }

    public static ListNode insert(ListNode head, int data) {

        ListNode n = new ListNode(data);

        //尾插法先要确定头结点是否为空，空的话先将第一个结点给头结点
        ListNode p = head;
        if (head == null) {
            n.setNext(head);
            head = n;
        } else {
            while (p.getNext() != null) {
                //p结点始终指向最后一个结点
                p = p.getNext();
            }
            //在尾部插入新结点
            p.setNext(n);
        }

        return head;
    }

    /**
     * @param listNode
     * @return
     */
    public static HashMap<Integer, Integer> convertListNodeToHashMap(ListNode listNode) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Integer i = 0;
        while (listNode != null) {
            hashMap.put(i, listNode.getData());
            listNode = listNode.getNext();
            i++;
        }

        return hashMap;
    }

    public static Integer fillHashMapToSameSize(HashMap<Integer, Integer> hashMap,
                                                HashMap<Integer, Integer> otherHashMap) {
        if (hashMap.size() > otherHashMap.size()) {
            Plus.fillHashMap(otherHashMap, hashMap.size());
        }
        if (hashMap.size() < otherHashMap.size()) {
            Plus.fillHashMap(hashMap, otherHashMap.size());
        }

        return hashMap.size();
    }

    public static void fillHashMap(HashMap<Integer, Integer> hashMap, Integer otherHashMapSize) {
        for (int i = hashMap.size(); i < otherHashMapSize; i++) {
            hashMap.put(i, 0);
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7, new ListNode(4, new ListNode(0, new ListNode(7, new ListNode(5)))));
        ListNode listNode2 = new ListNode(2, new ListNode(7, new ListNode(2, new ListNode(3, new ListNode(4)))));
        ListNode listNode = Plus.plusAB(listNode1, listNode2);
        System.out.println(listNode);
    }

}
