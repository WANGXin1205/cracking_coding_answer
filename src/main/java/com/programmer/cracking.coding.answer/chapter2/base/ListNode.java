package com.programmer.cracking.coding.answer.chapter2.base;

/**
 * @Author : Growlithe
 * @Date : 2018/8/7 23:04
 * @Description
 */
public class ListNode {
    int data;
    ListNode next = null;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
