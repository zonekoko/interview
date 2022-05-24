package com.zyp.interview.demo.algorithm.leetcode.isPalindromeListNode;
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,2,1]
//输出：true
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围[1, 10⁵] 内
// 0 <= Node.val <= 9
//
//
//
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/23 22:21
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);

        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        low = low.next;
        ListNode preNode = null;
        while (low != null){
            ListNode nextNode = low.next;
            low.next = preNode;
            preNode = low;
            low = nextNode;
        }
        while (preNode != null){
            if(preNode.val != head.val){
                return false;
            }
            preNode = preNode.next;
            head = head.next;
        }
        return true;
    }
}
