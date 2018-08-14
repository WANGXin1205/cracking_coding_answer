package com.programmer.cracking.coding.answer.chapter2;

import com.programmer.cracking.coding.answer.chapter2.base.ListNode;

import java.util.HashMap;

/**
 * @Author : Growlithe
 * @Date : 2018/8/14 10:25
 * @Description
 */
public class Palindrome {
    /*
    请编写一个函数，检查链表是否为回文。
    给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
    测试样例：
    {1,2,3,2,1}
    返回：true
    {1,2,3,2,3}
    返回：false
     */

    /**
     * @param pHead
     * @return
     */
    public static boolean isPalindrome(ListNode pHead) {
        HashMap<Integer, Integer> hashMap = Plus.convertListNodeToHashMap(pHead);
        ListNode listNode = new ListNode(hashMap.get(hashMap.size()-1));
        for (int i = hashMap.size() - 2; i > 0; i--) {
            Plus.insert(listNode, hashMap.get(i));
        }
        while (pHead.getNext() != null) {
            if (pHead.getData() != listNode.getData()) {
                return false;
            }
            pHead = pHead.getNext();
            listNode = listNode.getNext();
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(1,null);
        ListNode listNode5 = new ListNode(2,listNode6);
        ListNode listNode4 = new ListNode(3,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        Boolean flag = Palindrome.isPalindrome(listNode1);
        System.out.println(flag);
    }
}
