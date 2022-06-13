package com.zyp.interview.demo.algorithm.leetcode.binaryTreePaths;
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 746 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/29 17:18
 * @Version 1.0
 */
public class Solution {

    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        addPath(root,"",list);
        return list;

    }

    public static void addPath(TreeNode root,String path,List<String> list){
        if(root != null){
            StringBuilder builder = new StringBuilder(path);
            builder.append(root.val);
            if(root.left == null && root.right == null){
                list.add(builder.toString());
            }else {
                builder.append("->");
                addPath(root.left,builder.toString(),list);
                addPath(root.right,builder.toString(),list);
            }
        }
    }

//    public static List<String> binaryTreePaths1(TreeNode root){
//
//    }
}
