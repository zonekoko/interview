package com.zyp.interview.demo.algorithm.leetcode.postorderTraversal;

//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[3,2,1]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/11 14:41
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        post(result,root);
        return result;
    }

    private static void post(List<Integer> result,TreeNode root){
        if(null == root){
            return;
        }
        post(result,root.left);
        post(result,root.right);
        result.add(root.val);
    }

}
