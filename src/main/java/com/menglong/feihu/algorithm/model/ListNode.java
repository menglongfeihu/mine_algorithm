package com.menglong.feihu.algorithm.model;

/**
 * @author lianzeng
 * @version 1.0
 * @date 2020-06-22 : 15:53
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}