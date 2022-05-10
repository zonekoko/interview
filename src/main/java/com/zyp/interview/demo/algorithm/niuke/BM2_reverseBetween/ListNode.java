package com.zyp.interview.demo.algorithm.niuke.BM2_reverseBetween;

import lombok.Data;

/**
 * @ClassName ListNode
 * @Description 链表
 * @Author zhangyanping
 * @Date 2022/3/29 14:31
 * @Version 1.0
 */
@Data
public class ListNode {

    private int val;
    ListNode next = null;

    public ListNode(int val){
        this.val = val;
    }
}
