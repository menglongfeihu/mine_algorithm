package com.menglong.feihu.algorithm;

import com.menglong.feihu.algorithm.model.ListNode;

/**
 * @author lianzeng
 * @version 1.0
 * @date 2020-06-23 : 11:04
 */
public class Solution_19_removeNthFromEnd {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0 ) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

}
