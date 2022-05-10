package com.zyp.interview.demo.algorithm.leetcode.mergeTwoLists;

/**
 * @ClassName Solution
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author zhangyanping
 * @Date 2022/4/7 15:38
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists2(listNode1, listNode2);
        System.out.println(listNode);
    }

    //1->2->4
    //1->3->4

    public static ListNode mergeTwoLists1(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return listNode1 == null ? listNode2 : listNode1;
        }
        ListNode preNode = new ListNode(-1);
        ListNode preV = preNode;
        while (listNode1 != null && listNode2 != null){
            if(listNode1.val <= listNode2.val){
                preV.next = listNode1;
                listNode1 = listNode1.next;
            }else if(listNode2.val < listNode1.val){
                preV.next = listNode2;
                listNode2 = listNode2.next;
            }
            preV = preV.next;
        }
        preV.next = listNode1 == null ? listNode2 : listNode1;
        return preNode.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }


    public static class ListNode {
        private int val;
        private ListNode next;

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


}
