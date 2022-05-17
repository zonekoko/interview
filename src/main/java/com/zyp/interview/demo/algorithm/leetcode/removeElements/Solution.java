package com.zyp.interview.demo.algorithm.leetcode.removeElements;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [0, 10⁴] 内
// 1 <= Node.val <= 50
// 0 <= val <= 50
//
// Related Topics 递归 链表
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/17 16:20
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode tempNode = new ListNode(0);
        ListNode fast = head;
        ListNode low = tempNode;
        while (fast != null){
            if(fast.val != val){
                low.next = fast;
                low = fast;
                fast = fast.next;
                low.next = null;
            }else {
                fast = fast.next;
            }
        }
        return tempNode.next;
    }
}
