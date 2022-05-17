package com.zyp.interview.demo.algorithm.leetcode.inorderSuccessor;
//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
// 如果指定节点没有对应的“下一个”节点，则返回null。
//
// 示例 1:
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /
//1
//
//输出: null
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/16 09:14
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);

        TreeNode leftleft = new TreeNode(2);
        TreeNode rightright = new TreeNode(4);
        left.left = leftleft;
        left.right = rightright;

        leftleft.left = new TreeNode(1);

        root.left = left;
        root.right = right;

        TreeNode treeNode = inorderSuccessor(root, left);
        System.out.println(treeNode);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> treeNodes = new ArrayList<>();
        inorderTree(root,treeNodes);
        for (int i = 0; i < treeNodes.size(); i++) {
            if(treeNodes.get(i) == p){
                if(i < treeNodes.size() - 1){
                    return treeNodes.get(i+1);
                }
            }
        }
        return null;
    }

    public static void inorderTree(TreeNode root,List<TreeNode> treeNodes){
        if(root == null){
            return;
        }
        inorderTree(root.left,treeNodes);
        treeNodes.add(root);
        inorderTree(root.right,treeNodes);
    }
}
