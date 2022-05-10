package com.zyp.interview.demo.algorithm.leetcode.deleteDuplicates;

/**
 * @ClassName Solution
 * @Description 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 * @Author zhangyanping
 * @Date 2022/4/27 14:36
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);

    }

    /**
     * 思路：
     * 双指针，
     * 如果cur的值和fast的值一样，则fast往后走，
     * 如果当前的列表的值和fast链表的值不一样，直接将cur的next指向fast，fast往后走，cur往后走
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode fast = head;

        while (fast != null){
           if(cur.val == fast.val){
               fast = fast.next;
           }else{
               cur.next = fast;
               fast = fast.next;
               cur = cur.next;
           }
        }
        cur.next = fast;
        return head;
    }
}
