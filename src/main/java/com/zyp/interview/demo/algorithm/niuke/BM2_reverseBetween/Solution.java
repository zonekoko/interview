package com.zyp.interview.demo.algorithm.niuke.BM2_reverseBetween;

/**
 * @ClassName Solution
 * @Description 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
 * 例如：
 * 给出的链表为 1→2→3→4→5→NULL, m=2,n=4
 * 返回 1→4→3→2→5→NULL.
 *
 * 数据范围： 链表长度 0<size≤1000，0<m≤n≤size，链表中每个节点的值满足 |val| ≤1000
 * 要求：时间复杂度 O(n) ，空间复杂度 O(n)
 * 进阶：时间复杂度 O(n)，空间复杂度 O(1)
 * @Author zhangyanping
 * @Date 2022/3/29 15:13
 * @Version 1.0
 */
public class Solution {

    public static ListNode reverseBetween(ListNode head,int m,int n){
        if(head == null){
            return null;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode preNode = res;
        ListNode curNode = head;
        ListNode tempNode;
        for (int i = 1; i < m; i++) {
            preNode = curNode;
            curNode = curNode.next;
        }
        for (int i = m; i < n; i++) {
            tempNode = curNode.next;
            curNode.next = tempNode.next;
            tempNode.next = preNode.next;
            preNode.next = tempNode;
        }
        return res.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseBetween(head, 1, 2);
        System.out.println(newHead);
    }
}
