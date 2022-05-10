package com.zyp.interview.demo.algorithm.niuke.BM1_reverseList;

/**
 * @ClassName Solution
 * @Description 给定一个单链表的头结点pHead
 * (该头节点是有值的 ， 比如在下图 ， 它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * 数据范围： 0≤n≤1000
 * 要求：空间复杂度 O(1) ，时间复杂度 O(n) 。
 * @Author zhangyanping
 * @Date 2022/3/29 14:34
 * @Version 1.0
 */
public class Solution {

    public static ListNode ReverseList1(ListNode head){
        if(head == null){
            return null;
        }
        ListNode nextNode = null;
        ListNode curNode = head;
        ListNode tempNode;
        while (curNode != null){
            tempNode  = curNode.next;
            curNode.next = nextNode;
            nextNode = curNode;
            curNode = tempNode;
        }
        return nextNode;
    }

    public  static ListNode ReverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        ListNode reverseHead = ReverseList1(head);
        ListNode reverseHead = ReverseList2(head);
        System.out.println(reverseHead);
    }


}
