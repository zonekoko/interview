package com.zyp.interview.demo.algorithm.leetcode.deleteDuplicates;

import lombok.Data;

/**
 * @ClassName ListNode
 * @Description 链表结构
 * @Author zhangyanping
 * @Date 2022/4/27 14:37
 * @Version 1.0
 */
public class ListNode {
      int val;
      ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
